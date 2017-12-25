<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>优惠菜品界面</title>

</head>
<body>
	<div class="navbar navbar-fixed-top">
		<%@ include file="../../AssemblingJSP/mainJSP/top.jsp"%>
	</div>
	<%@ include file="../../AssemblingJSP/Addpriv/left.jsp"%>
	<div class="span3" id="sidebar">
		<div class="span9" id="content">
			<div class="row-fluid">
				<!-- block -->
				<div class="block">
					<div class="navbar navbar-inner block-header">
						<div class="muted pull-left">增加优惠信息</div>
					</div>
					<div class="block-content collapse in">
						<div class="span12">
							<form class="form-horizontal">
								<fieldset>
									<legend>优惠信息</legend>
									<div class="control-group success">
										<label class="control-label" for="inputError">优惠折扣</label>
										<div class="controls">
											<input type="text" id="discount" onblur="checkinfor()">
										</div>
									</div>
									<div class="control-group success">
										<label class="control-label" for="inputError">开始时间</label>
										<div class="controls">
											<input type="date" id="begin" onblur="checkinfor1()">
										</div>
									</div>
									<div class="control-group success">
										<label class="control-label" for="inputError">结束时间</label>
										<div class="controls">
											<input type="date" id="end" onblur="checkinfor2()">
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
			var discount = document.getElementById("discount").value;
			var begin = document.getElementById("begin").value;
			var end = document.getElementById("end").value;
			var iDate = new Date(begin.replace(/\-/g, '/'));
			var oDate = new Date(end.replace(/\-/g, '/'));
			if (iDate > oDate) {
				alert("结束日期不能小于开始日期,请重新输入！")
				window.location.href = "skipaddpriv.do";
			}
			if (discount.length < 1) {
				alert("提交失败");
				window.location.href = "skipaddpriv.do";
			}
			var queryString = "discount=" + discount + "&begin=" + begin
					+ "&end=" + end;
			return queryString;
		}
		//使用get方式发送  
		function doRequestUsingGET() {
			createXMLHttpRequest();
			var queryString = "addpriv.do?";
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
						window.location.href = "priv.do";
					} else {
						alert("添加失败" + " ,请重新输入");
						window.location.href = "skipaddpriv.do";
					}
				}
			}
		}
		function checkinfor() {
			var discount = document.getElementById("discount").value;
		<!--var reg = new RegExp("^[0-9]*$");-->
		var reg = /^[-+]?[0-9]+(\.[0-9]+)?$/;
			if (!reg.test(discount)) {
				alert("只能输入数字");
				document.getElementById("discount").value = "";
			} 
			if (discount > 9) {
				alert("优惠小于10");
				document.getElementById("discount").value = "";
			} else if (discount < 1) {
				alert("优惠大于0");
				document.getElementById("discount").value = "";
			}
		}
		function checkinfor1() {
			var begin = document.getElementById("begin").value;
			if (begin.length == 0) {
				alert("请输入正确的年月日yy-MM-dd");
			}
		}

		function checkinfor2() {
			var end = document.getElementById("end").value;
			if (end.length == 0) {
				alert("请输入正确的年月日yyyy-MM-dd");
			}
		}
	</script>
</body>
</html>