<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改会员信息</title>
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
								action="updatevip.do?id=${em.vip_ID }"
								enctype="multipart/form-data">
								<fieldset>
									<!--String sql = "update VIP set name=?,phone=?,email = ?,photo=?,phototype=? where code = ?";-->

									<div class="control-group">
										<label class="control-label" for="disabledInput">名称</label>
										<div class="controls">
											<input class="input-xlarge disabled" name="name" type="text"
												id="id1" value="${em.name}" onblur="checkiinfor()">
										</div>
									</div>
									<div class="control-group success">
										<label class="control-label" for="inputError">电话</label>
										<div class="controls">
											<input type="text" name="phone" value="${em.phone}" id="id2"
												onblur="checkcdinfor1()">
										</div>
									</div>

									<div class="control-group success">
										<label class="control-label" for="inputError">优惠</label>
										<div class="controls">
											<input type="text" name="discount"
												value="${em.privilege_cir}" id="id3"
												onblur=" checkddinfor2() ">
										</div>
									</div>

									<div class="form-actions">
										<button type="submit" class="btn btn-primary">修改</button>
										<button type="reset" class="btn">取消</button>
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
		function checkiinfor() {
			var na = document.getElementById("id1").value;
			var reg = /^([A-Za-z]|[\u4E00-\u9FA5])+$/;
			if (!reg.test(na)) {
				alert("只能输入汉字和英文");
			}
			if (na.length == 0) {
				alert("输入名称");
			}
		}

		function checkcdinfor1() {
			var phone = document.getElementById("id2").value;
			var reg = new RegExp("^[0-9]*$");
			if (!reg.test(phone)) {
				alert("只能输入数字");
			}
			if (phone.length > 11) {
				alert("电话长度过长");

			}
			if (phone.length < 11) {
				alert("电话长度过短");

			}
		}
		function checkddinfor2() {
			var discount = document.getElementById("id3").value;
			var reg = new RegExp("^[0-9]*$");
			if (!reg.test(discount)) {
				alert("只能输入数字");
			}
			if (discount > 10) {
				alert("折扣小于10");
			} else if (discount.length == 0) {
				alert("输入折扣");
			} else if (discount < 1) {
				alert("折扣应大于1");
			}
		}
	</script>
</body>
</html>