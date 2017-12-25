<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改菜品</title>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<%@include file="../../AssemblingJSP/mainJSP/top.jsp"%>
	</div>
	<div class="row-fluid">
		<%@include file="../../AssemblingJSP/Addvege/left.jsp"%>
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
								action="updatevege.do?id=${em.vname }"
								enctype="multipart/form-data">
								<fieldset>
									<div class="control-group">
										<label class="control-label" for="disabledInput">名称</label>
										<div class="controls">
											<input class="input-xlarge disabled" name="name" type="text"
												value="${em.vname}">
										</div>
									</div>
									<div class="control-group success">
										<label class="control-label" for="inputError">价格</label>
										<div class="controls">
											<input type="text" name="price" value="${em.vprice}" id="id2"
												onblur=" checkinfor1()">
										</div>
									</div>
									<div class="control-group"></div>
									<div class="control-group warning">
										<label class="control-label" for="inputError">优惠</label>
										
										<div class="controls">
											<select name="discount">
												<c:forEach var="emp" items="${emp}">
													<option value=' ${emp.pr_id}'>折扣：${emp.discount}
														开始时间${emp.p_time }结束时间--${emp.p_end } </option>
													<br />
												</c:forEach>
											</select>
										</div>
										
										
									</div>
									<div class="control-group success">
										<label class="control-label" for="selectError">上传照片</label>
										<div class="controls">
											<input type="file" name="file" id="id4"
												onblur=" checkinfor3()" />
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
		function checkinfor1() {
			var begin = document.getElementById("id2").value;
			var reg = new RegExp("^[0-9]*$");
			if(!reg.test(begin)){
				alert("只能输入数字")
			}
			if (begin.length == 0) {
				alert("输入价格");
			}
		}

		function checkinfor2() {
			var discount = document.getElementById("id3").value;
			if (discount.length == 0) {
				alert("选择优惠");
			}
		}

		function checkinfor3() {
			var begin = document.getElementById("id4").value;
			if (begin.length == 0) {
				alert("选择照片");
			}
		}
	</script>
</body>
</html>