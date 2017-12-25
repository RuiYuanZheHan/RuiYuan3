<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>添加用户</title>

</head>
<body>
	<div class="navbar navbar-fixed-top">
		<%@ include file="../../AssemblingJSP/mainJSP/top.jsp"%>
	</div>
	<%@ include file="../../AssemblingJSP/Adduser/left.jsp"%>
	<div class="span3" id="sidebar">

		<div class="span9" id="content">
			<div class="row-fluid">
				<!-- block -->
				<div class="block">
					<div class="navbar navbar-inner block-header">
						<div class="muted pull-left">酒店人员基本信息</div>
					</div>
					<div class="block-content collapse in">
						<div class="span12">
							<form class="form-horizontal">
								<fieldset>
									<legend>员工信息</legend>
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
										<select id="identity">
												<option value="酒店经理">酒店经理</option>
												<option value="服务员">服务员</option>
												</select>
										</div>
									</div>

									<div class="form-actions">
										<input type="Button" class="btn btn-primary" value="添加"
											onclick="doRequestUsingGET()" />
										<button type="reset" class="btn">取消</button>
									</div>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="form-actions">
				<%@ include file="../../AssemblingJSP/mainJSP/footer.jsp"%>
			</div>

		</div>
	</div>
	<script Charset="UTF-8">

		var xmlHttp;
		var responseText;
		function checkinfor() {
			var reg = /^([A-Za-z]|[\u4E00-\u9FA5])+$/;
			var name = document.getElementById("name").value;
			
			if (name.length == 0) {
				alert("请输入姓名");
			}else if(!reg.test(name)){
				alert("输入汉字或字母");
				document.getElementById("name").value="";
			}
		}
		function checkinfor1() {
			var password = document.getElementById("password").value;
			if (password.length == 0) {
				alert("请输入密码");
			}else if(password.length>20){
				alert("密码过长");
				document.getElementById("password").value="";
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
			var identify = document.getElementById("identity").value;
			if(name.length<1||password.length<1||identify.length<1){
				alert("输入不能有空");
				window.location.href = "skipadduser.do";
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
						alert("添加成功");
						window.location.href = "tomain.do";
					} else {
						alert("添加失败" + " ,请重新输入");
						window.location.href = "skipadduser.do";
					}
				}
			}
		}
	</script>
</body>

</html>