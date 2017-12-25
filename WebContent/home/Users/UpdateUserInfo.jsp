<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>修改密码</title>
</head>

<body>
	<div class="navbar navbar-fixed-top">
		<%@include file="../../AssemblingJSP/mainJSP/top.jsp"%>

	</div>
	<div class="row-fluid">
		<%@include file="../../AssemblingJSP/Adduser/left.jsp"%>
		<!--/span-->
		<div class="span9" id="content">
			<div class="row-fluid">
				<!-- block -->
				<div class="block">
					<div class="navbar navbar-inner block-header">
						<div class="muted pull-left">基本信息</div>
					</div>
					<div class="block-content collapse in">
						<div class="span12">
							<form class="form-horizontal" method="post"
								action="updateuser.do?id=${em.uname }">
								<!--	String sql = "update user set college=?,email=?,phone = ?,code = ?,photo=?,phototype=? where IDcard = ?";  -->
								<fieldset>
									<div class="control-group">
										<label class="control-label" for="disabledInput">姓名</label>
										<div class="controls">
											<input class="input-xlarge disabled" name="name" type="text" id="id1"
											onblur=" checkinfor()"
												value="${em.uname}">
										</div>
										<div class="control-group">
											<label class="control-label" for="disabledInput">输入新密码</label>
											<div class="controls">
												<input class="input-xlarge disabled" name="password"
													type="password" value="${em.password}"   id="id2" onblur=" checkinfor1()">
											</div>
										</div>
										<div class="form-actions">
											<button type="submit" class="btn btn-primary">修改</button>
											<button type="reset" class="btn">取消</button>
										</div>
									</div>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="form-actions">
				<%@ include file="../../AssemblingJSP/mainJSP/footer.jsp"%>
			</div>
		</div>
	</div>
	<script Charset="UTF-8">
		var xmlHttp;
		var responseText;

	
		function checkinfor() {
			var discount = document.getElementById("id1").value;
			var reg = /^([A-Za-z]|[\u4E00-\u9FA5])+$/;
			if(!reg.test(name)){
				alert("输入汉字或字母");
			}else if (discount.length > 5 ) {
				alert("名字五个字以内");
			}
			else if(discount.length==0){
				alert("输入名字");
			}else if(discount.length==5){
				alert("名字五个字以内");
			}
		}
		function checkinfor1() {
			var begin = document.getElementById("id2").value;
			if (begin.length == 0) {
				alert("输入密码");
			}else if(begin.length > 7){
				alert("密码七位以下");
			}else if(begin.length == 7)
				alert("密码七位以下");
				
		}
	</script>
</body>
</html>