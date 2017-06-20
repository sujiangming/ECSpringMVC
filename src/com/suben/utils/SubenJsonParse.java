package com.suben.utils;

import com.alibaba.fastjson.JSONObject;

public class SubenJsonParse {
	public static JSONObject getJSONObject(int status, String desc, Object object) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", status);
		jsonObject.put("message",desc);
		jsonObject.put("data", object);
		return jsonObject;
	}
}
