package com.suben.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.suben.entity.User;
import com.suben.service.inter.IUserService;
import com.suben.utils.SubenJsonParse;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;

	// 判断登录用户的是否存在
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		boolean ret = userService.isUserExist(userName, password);
		if (ret == true) {
			return "home";
		} else {
			return "index";
		}

	}

	// 跳转到注册页面
	@RequestMapping(value = "/toRegister", method = RequestMethod.GET)
	public String toRegister(User user) {
		return "register";
	}

	// 注册新用户
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("realname") String realname, @RequestParam("userName") String userName,
			@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("telphone") String telphone, Model model) {
		// 这里需要进行判断，判断当前所注册的用户名在数据库中是否已经存在，并给出校验的标识，这个由js代码实现
		User user = new User();
		return (userService.saveOrUpdateUser(user) == true) ? "success" : "register";
	}

	// 使用注解校验用户注册
	@RequestMapping(value = "/testRegister", method = RequestMethod.POST)
	public String registerUser(@Valid User user, BindingResult bindingResult, Model model,
			@RequestParam("userName") String userName) {
		if (bindingResult.hasErrors()) {
			System.out.println("有错误" + bindingResult);
			return "register";
		}
		User user1 = userService.getUserByNameOrPwd(userName, null);
		if (user1 == null) {
			bindingResult.getFieldError(userName);
			userService.saveOrUpdateUser(user);
			return "success";
		} else {
			model.addAttribute("flag", "error");
			model.addAttribute("flags", "该用户名已经存在，请重新输入");
			return "register";
		}

	}

	// 测试请求URL带有参数的方法
	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public String toSuccess(@PathVariable String userName, Model model) {

		return "success";
	}

	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	@ResponseBody
	public String getUserList() throws Exception {
		List<User> userList = (List<User>) userService.getUserList("User");
		JSONObject result = new JSONObject();
		if (null == userList || 0 == userList.size()) {
			result.put("status", "0");
			result.put("message", "获取数据失败");
			result.put("data", userList);
		} else {
			result.put("status", "1");
			result.put("message", "获取数据成功");
			result.put("data", userList);
		}
		return result.toString();
	}

	@RequestMapping("/get")
	@ResponseBody
	public void get(HttpServletRequest req, HttpServletResponse res) {
		List<User> userList = (List<User>) userService.getUserList("User");
		JSONObject result = null;
		if (null == userList || 0 == userList.size()) {
			result = SubenJsonParse.getJSONObject(0, "获取数据失败！", userList);
		} else {
			result = SubenJsonParse.getJSONObject(1, "获取数据成功！", userList);
		}
		String ret = result.toString();
		res.setContentType("text/plain");
		String callbackFunName = req.getParameter("callbackparam");// 得到js函数名称
		try {
			res.getWriter().write(callbackFunName + "(" + ret + ")"); // 返回jsonp数据
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "app/login", method = RequestMethod.POST)
	public void appLogin(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = JSON.parseObject(json);
		String userName = object.getString("userName");
		String password = object.getString("password");

		User user = userService.getUserByNameOrPwd(userName, password);

		JSONObject result = null;
		if (null != user) {
			result = SubenJsonParse.getJSONObject(1, "获取数据成功！", user);
		} else {
			result = SubenJsonParse.getJSONObject(0, "获取数据失败！", user);
		}
		try {
			response.getWriter().write("(" + result.toString() + ")");// 返回jsonp数据
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 注册新用户
	@RequestMapping(value = "app/register", method = RequestMethod.POST)
	public void appRegister(@RequestBody String json, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		JSONObject object = JSON.parseObject(json);
		System.out.println("--object--" + object.toString());
		String userName = object.getString("userName");
		String password = object.getString("password");
		String email = object.getString("email");
		String realName = object.getString("realname");
		String telPhone = object.getString("telphone");
		// 这里需要进行判断，判断当前所注册的用户名在数据库中是否已经存在，并给出校验的标识，这个由js代码实现
		User user = userService.getUserByNameOrPwd(userName, password);
		if (null != user) {
			response.getWriter().write("(" + SubenJsonParse.getJSONObject(0, "用户名已存在！", user).toString() + ")");// 返回jsonp数据
		} else {
			user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setTelphone(telPhone);
			user.setUserName(userName);
			user.setRealname(realName);
			boolean ret = userService.saveOrUpdateUser(user);
			if (ret) {
				response.getWriter().write("(" + SubenJsonParse.getJSONObject(1, "注册成功！", user).toString() + ")");// 返回jsonp数据
			}
		}

	}
}
