<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>添加会员</title>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<%@ include file="../../AssemblingJSP/mainJSP/top.jsp"%>
	</div>
	<%@ include file="../../AssemblingJSP/AddVIP/left.jsp"%>
	<div class="span3" id="sidebar">

		<div class="span9" id="content">
			<div class="row-fluid">
				<!-- block -->
				<div class="block">
					<div class="navbar navbar-inner block-header">
						<div class="muted pull-left">基本信息</div>
					</div>
					<div class="block-content collapse in">
						<div class="span12">
							<form class="form-horizontal">
								<fieldset>
									<legend>会员信息</legend>
									<div class="control-group">
										<label class="control-label" for="selectError">姓名</label>
										<div class="controls">
											<input id="na" type="text" onblur="checkiinfor()">
										</div>
									</div>
									<div class="control-group error">
										<label class="control-label" for="inputError">手机号</label>
										<div class="controls">
											<input type="text" id="phone" onblur="checkcdinfor1() ">
										</div>
									</div>
									<div class="control-group error">
										<label class="control-label" for="inputError">优惠折扣</label>
										<div class="controls">
											<input type="text" id="discount" onblur=" checkddinfor2()">
										</div>
									</div>
									<div class="form-actions">
										<input type="Button" value="添加" class="btn btn-primary"
											onclick="doRequestUsingGET()" />
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
			var na = document.getElementById("na").value;
			var phone = document.getElementById("phone").value;
			var discount = document.getElementById("discount").value;
			if (na.length < 1 && phone.length < 1 && discount.length < 1) {
				alert("输入不能有空");
				window.location.href = "skipaddvip.do";
			}
			var queryString = "na=" + na + "&phone=" + phone + "&discount="
					+ discount;
			return queryString;
		}
		//使用get方式发送  
		function doRequestUsingGET() {
			createXMLHttpRequest();
			var queryString = "addvip.do?";
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
						window.location.href = "vip.do";
					} else {
						alert("添加失败" + " ,请重新输入");
						window.location.href = "skipaddvip.do";
					}
				}
			}
		}
		function checkiinfor() {

			var reg = /^([A-Za-z]|[\u4E00-\u9FA5])+$/;
			var na = document.getElementById("na").value;
			if (na.length == 0) {
				alert("输入名称");
			} else if (!reg.test(na)) {
				alert("只能输入汉字和英文");
				document.getElementById("na").value = "";
			}

		}
		function checkcdinfor1() {
			var phone = document.getElementById("phone").value;
			var reg = new RegExp("^[0-9]*$");
			if (!reg.test(phone)) {
				alert("电话格式非法");
			}
			if (phone.length > 11) {
				alert("电话长度过长");

			}
			if (phone.length < 11) {
				alert("电话长度过短");

			}
		}
		function checkddinfor2() {
			var discount = document.getElementById("discount").value;
			var reg = /^[-+]?[0-9]+(\.[0-9]+)?$/;
			if (discount.length == 0) {
				alert("输入折扣");
			} else if (discount > 9) {
				alert("折扣小于10");
			} else if (discount < 1) {
				alert("折扣大于1");
			} else if (!reg.test(discount)) {
				alert("只能输入数字");
				document.getElementById("discount").value = "";
			}
		}
	</script>
</body>
</html>