<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap -->
<link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="../../bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" media="screen">
<link href="../../assets/styles.css" rel="stylesheet" media="screen">
</head>
<body id="login">
	<div class="container">
		<form class="form-signin">
			<h2 class="form-signin-heading"></h2>
			<input type="text" class="input-block-level" placeholder="输入用户名"
				id="name" onblur=" checkuinfor()"> <input type="password"
				class="input-block-level" placeholder="输入密码" id="password"
				onblur=" checkpasswordfor()"> 身份：<select id="identity">
				<option value="酒店经理">酒店经理</option>
				<option value="服务员">服务员</option>
			</select> <input type="button" value="登录" onclick="doRequestUsingGET();" /> <input
				type=button value="取消" style="float: right" onclick="reset();">

		</form>
		<a href="../Users/register.do">注册用户</a>
	</div>
	<script Charset="UTF-8">
		var xmlHttp;
		var responseText;

		//创建xmlHttp  
		function createXMLHttpRequest() {
			if (window.ActiveXObject) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} else if (window.XMLHttpRequest) {
				xmlHttp = new XMLHttpRequest();
			}
		}

		//拼出要发送的姓名数据  
		function createQueryString() {
			var name = document.getElementById("name").value;
			var password = document.getElementById("password").value;
			var IDentity = document.getElementById("identity").value;
			if (name.length < 1 && password.length < 1 && IDentity.length < 0) {
				alert("输入不能有空");
				window.location.href = "login.jsp";
			}
			var queryString = "name=" + name + "&password=" + password
					+ "&identity=" + IDentity;
			return queryString;
		}

		//使用get方式发送  
		function doRequestUsingGET() {
			createXMLHttpRequest();
			var queryString = "login.do?";
			queryString = queryString + createQueryString();
			xmlHttp.onreadystatechange = handleStateChange;
			xmlHttp.open("GET", queryString, true);
			xmlHttp.send(null);
		}

		function handleStateChange() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status == 200) {
					responseText = document
							.createTextNode(xmlHttp.responseText);
					var str = xmlHttp.responseText;
					if (str == 1) {
						alert("登录服务端");
						window.location.href = "../VegeBill/vegetablebill.do";
					} else if (str == 2) {
						alert("登录管理端");
						window.location.href = "tomain.do";
					} else if (str == 3) {
						alert("身份不符，重新登录");
						window.location.href = "login.jsp";
					} else {

						alert(" 用户名或密码错，请重新输入");
						window.location.href = "login.jsp";
					}
				}
			}
		}
		function reset() {
			window.location.href = "login.jsp";
		}
		function checkuinfor() {
			var name = document.getElementById("name").value;
			var reg = /^([A-Za-z]|[\u4E00-\u9FA5])+$/;
			if (name.length == 0) {
				alert("用户名不能为空");
			} else	if (!reg.test(name)) {
				alert("输入汉字或字母");
				document.getElementById("name").value = "";
			}

		}
		function checkpasswordfor() {
			var upasswd = document.getElementById("password").value;

			if (upasswd.length == 0) {
				alert("密码不能为空");
			} else if (upasswd.length > 20) {
				alert("密码长度超出限制，应小于20位");
				document.getElementById("password").value = "";
			}
		}
	</script>
</body>
</html>