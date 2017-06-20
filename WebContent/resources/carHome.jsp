<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<!--解决IE CSS 圆角兼容性问题 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>凯里运管所车辆管理平台</title>
<!-- 可选: 包含 jQuery 库 -->
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/css/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css" />
<link href="../resources/css/suben.css" rel="stylesheet" type="text/css" />
<script src="../resources/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script type="text/javascript" src="../resources/js/suben.js"></script>
<script type="text/javascript">
function register() {
	window.location.href = "/KaiLiCarsManagerV1.2/user/toRegister";
}
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<table width="1140px" height="38px" align="center">
				<tbody>
					<tr>
						<td><img alt=""
							src="../resources/../resources/../resources/images/car.png"
							align="left"
							style="text-align: center; margin-left: 5px; margin-top: 5px; float: left"></td>
						<td colspan="2" width="80px"></td>
						<td colspan="10" width="570px" align="center"><b>客运车管理系统</b></td>
						<td bgcolor="#D9D9D9" align="right"><a
							href="/KaiLiCarsManagerV1.2/">登陆 | </a></td>
						<td bgcolor="#D9D9D9"><a
							href="javascript:register();">注册</a></td>
						<td colspan="2" width="10px"></td>
						<td><a href="#"><span class="glyphicon glyphicon-minus"></span></a></td>
						<td><a href="#"><span
								class="glyphicon glyphicon-unchecked"></span></a></td>
						<td><a href="index.html"><span
								class="glyphicon glyphicon-remove"></span></a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="main-body">
			<div id="menu"></div>
			<div id="mainContent">
				<div id="sidebar">
					<p></p>
					<span
						style="margin-top: 100px; margin-left: 8px; font-size: 12px; font-family: Microsoft Yahei, Helvetica Neue, Helvetica, Arial, sans-serif; color: #DEDEDE;">信息管理</span>
					<table class="table">
						<tr>
							<td><img id="taxi"
								src="../resources/../resources/../resources/images/czc.png"></td>
							<td><a href="#"><img alt=""
									src="../resources/../resources/../resources/images/bus.png"></a></td>
						</tr>
						<tr>
							<td><a href="qiye.html"><img alt=""
									src="../resources/../resources/../resources/images/qiye.png"></a></td>
							<td><a href="user.html"><img alt=""
									src="../resources/../resources/../resources/images/cyry.png"></a></td>
						</tr>
					</table>
					<p></p>
					<span
						style="margin-left: 8px; font-size: 12px; font-family: Microsoft Yahei, Helvetica Neue, Helvetica, Arial, sans-serif; color: #DEDEDE;">考核管理</span>
					<table class="table">
						<tr>
							<td><a href="#"><img alt=""
									src="../resources/../resources/../resources/images/czc.png"></a></td>
							<td><a href="#"><img alt=""
									src="../resources/../resources/../resources/images/bus.png"></a></td>
						</tr>
						<tr>
							<td><img alt=""
								src="../resources/../resources/../resources/images/qiye.png"></td>
							<td><img alt=""
								src="../resources/../resources/../resources/images/cyry.png"></td>
						</tr>
					</table>
					<p></p>
					<span
						style="margin-left: 8px; font-size: 12px; font-family: Microsoft Yahei, Helvetica Neue, Helvetica, Arial, sans-serif; color: #DEDEDE;">信誉管理</span>
					<table class="table">
						<tr>
							<td><a href="http://www.baidu.com"><img alt=""
									src="../resources/../resources/../resources/images/11.png"></a></td>
							<td><a href="#C4"><img alt=""
									src="../resources/../resources/../resources/images/hm.png"></a></td>
						</tr>
						<tr>
							<td><a href="#C4"><img alt=""
									src="../resources/../resources/../resources/images/wz.png"></a></td>
							<td></td>
						</tr>
					</table>
					<p></p>
					<p>
						<span
							style="margin-left: 8px; font-size: 12px; font-family: Microsoft Yahei, Helvetica Neue, Helvetica, Arial, sans-serif; color: #DEDEDE;">下载导出</span>
					</p>
					<span style="float: left"><a href="http://www.baidu.com"><img
							alt=""
							src="../resources/../resources/../resources/images/xiazai.png"></a></span>
				</div>
				<div id="sidebar2"></div>
				<div id="content">
					<div id="mainContent-left">
						<div id="search">
							<table>
								<tr>
									<td><input type="image" width="22" height="18"
										class="searchaction" alt="submit"
										src="../resources/images/magglass.gif" onclick="loadXMLDoc()"
										id="bnt" /></td>
									<td><input type="text"
										style="border-radius: 10px; background: #D9D9D9;"
										name="license_number" class="searchinput" id="searchInput"
										placeholder="搜索中..." /></td>
									<td width="20px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td><span id="addUserInfo"
										class="glyphicon glyphicon-plus"></span></td>
								</tr>
							</table>
						</div>
						<span
							style="text-align: center; display: block; padding-top: 5px;">展开全部
							&nbsp;<a onclick="hiddenDiv()"><span id="showAll"
								class="glyphicon glyphicon-chevron-up"></span></a>
						</span>
					</div>
					<div id="mainContent-left-bottom">
						<p></p>
						<!-- <span
							style="margin-left: 8px;width:80px; font-size: 12px; font-family: Microsoft Yahei, Helvetica Neue, Helvetica, Arial, sans-serif;">出租车（1232）</span> -->
						<table class="table table-hover" width="280px" id="tabTaxi">
							
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>