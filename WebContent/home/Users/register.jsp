<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>注册</title>
<link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="../../bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" media="screen">
<link href="../../assets/styles.css" rel="stylesheet" media="screen">
<script src="../../vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<%@ include file="../../AssemblingJSP/mainJSP/top.jsp"%>
	</div>
	<div class="span3" id="sidebar">
		<div class="span9" id="content">
			<div class="row-fluid">
				<!-- block -->
				<div class="block">
					<div class="navbar navbar-inner block-header">
						<div class="muted pull-left">用户注册</div>
					</div>
					<div class="block-content collapse in">
						<div class="span12">
							<form class="form-horizontal">
								<fieldset>
									<legend>注册</legend>
									<div class="control-group">
										<label class="control-label" for="focusedInput">姓名</label>
										<div class="controls">
											<input class="input-xlarge focused" id="name" type="text"
												onblur="checkinfor()">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="disabledInput">密码</label>
										<div class="controls">
											<input class="input-xlarge disabled" id="password"
												type="password" onblur="checkinfor1()" />
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="disabledInput">身份</label>
										<div class="controls">
											<input class="input-xlarge disabled" id="identify"
											value="服务员" 	type="text"  onblur="checkinfor2()"/>
										</div>
									</div>

									<div class="form-actions">
										<input type="Button" class="btn btn-primary" value="注册"
											onclick="doRequestUsingGET()" />
										<button type="reset" class="btn">取消</button>
									</div>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
			<a href = "../main/login.jsp">返回</a>
		</div>
	</div>
	<script Charset="UTF-8">
		var xmlHttp;
		var responseText;
		function checkinfor() {
			var reg = /^([A-Za-z]|[\u4E00-\u9FA5])+$/;
			var name = document.getElementById("name").value;
			if(!reg.test(name)){
				alert("输入汉字或字母");
			}
			else if (name.length == 0) {
				alert("请输入姓名");
			}
		}
		function checkinfor1() {
			var password = document.getElementById("password").value;
			if (password.length == 0) {
				alert("请输入密码");
			}else if(password.length>20){
				alert("密码过长");
			}

		}
		function checkinfor2() {
			var identify = document.getElementById("identify").value;
			if (identify!="服务员") {
				alert("身份只能为服务员");
				 document.getElementById("identify").value="";
					window.location.href = "register.jsp";
			}

		}
		
		//创建xmlHttp  

		function createXMLHttpRequest() {
			if (window.ActiveXObject) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} else if (window.XMLHttpRequest) {
				xmlHttp = new XMLHttpRequest();
			}
		}

		//获取输入变量
		function createQueryString() {
			var name = document.getElementById("name").value;
			var password = document.getElementById("password").value;
			var identify = document.getElementById("identify").value;
			if(name.length<1||password.length<1||identify.length<1){
				alert("输入不能有空");
				window.location.href = "register.jsp";
			}
			var queryString = "name=" + name + "&password=" + password
					+ "&identify=" + identify;
			return queryString;
		}

		//使用get方式发送  
		function doRequestUsingGET() {
			createXMLHttpRequest();
			var queryString = "users.do?";
			queryString = queryString + createQueryString();
			xmlHttp.onreadystatechange = handleStateChange;
			xmlHttp.open("GET", queryString, true);
			xmlHttp.send(null);
		}
		function handleStateChange() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status == 200) {
					var str = xmlHttp.responseText;
					if (str == 1) {
						alert("添加成功,请登录！");
						window.location.href = "../main/login.jsp";
					} else {
						alert("添加失败" + " ,请重新输入");
						window.location.href = "register.jsp";
					}
				}
			}
		}
	</script>
</body>
</html>