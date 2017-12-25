<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>优惠区</title>
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
						<div class="muted pull-left">修改优惠信息</div>
					</div>
					<div class="block-content collapse in">
						<div class="span12">
							<form class="form-horizontal" method="post"
								action="skipupdatepriv.do?id=${em.pr_id }"
								enctype="multipart/form-data">
								<fieldset>
									<legend>修改优惠信息</legend>
									<div class="control-group success">
										<label class="control-label" for="inputError">折扣</label>
										<div class="controls">
											<input type="text" name="discount" value="${em.discount }"   id="id1" onblur=" checkinfor()">
										</div>
									</div>
									<div class="control-group success">
										<label class="control-label" for="inputError">开始时间</label>
										<div class="controls">
											<input type="date" name="begin" value="${em.p_time }" id="id2" onblur=" checkinfor1()">
										</div>
									</div>
									<div class="control-group success">
										<label class="control-label" for="inputError">结束时间</label>
										<div class="controls">
											<input type="date" name="end" value="${em.p_end }" id="id3" onblur=" checkinfor2()">
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
		
		function checkinfor() {
			var discount = document.getElementById("id1").value;
			var reg = /^[-+]?[0-9]+(\.[0-9]+)?$/;
			if (!reg.test(discount)) {
				alert("只能输入数字");
				document.getElementById("id1").value="";
			}
			if (discount > 9 ) {
				alert("优惠小于10");
			}else if(discount<0){
				alert("优惠大于0");
			}
			if(discount.length==0){
				alert("输入优惠信息");
			}
		}
		function checkinfor1() {
			var begin = document.getElementById("id2").value;
		
	
			if (begin.length == 0) {
				alert("请输入正确的年月日yy-MM-dd");
			}
		}

		function checkinfor2() {
			var end = document.getElementById("id3").value;
			if (end.length == 0) {
				alert("请输入正确的年月日yyyy-MM-dd");
			}
		}
	</script>
</body>
</html>