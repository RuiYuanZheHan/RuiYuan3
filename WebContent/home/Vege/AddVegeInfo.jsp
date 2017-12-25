
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>添加菜品</title>
<!-- Bootstrap -->

</head>

<body>
	<div class="navbar navbar-fixed-top">
		<%@ include file="../../AssemblingJSP/mainJSP/top.jsp"%>
	</div>
	<%@ include file="../../AssemblingJSP/Addvege/left.jsp"%>
	<div class="span3" id="sidebar">

		<div class="span9" id="content">
			<div class="row-fluid">
				<!-- block -->
				<div class="block">
					<div class="navbar navbar-inner block-header">
						<div class="muted pull-left">菜品信息</div>
					</div>
					<div class="block-content collapse in">
						<div class="span12">
							<form class="form-horizontal" method="post" action="addvege.do"
								enctype="multipart/form-data">
								<fieldset>
									<legend>菜品信息</legend>
									<div class="control-group">
										<label class="control-label" for="disabledInput">名称</label>
										<div class="controls">
											<input class="input-xlarge disabled" name="name" id="id1"
												type="text" onblur="checkiinfor()" />
										</div>
									</div>
									<div class="control-group success">
										<label class="control-label" for="inputError">价格</label>
										<div class="controls">
											<input type="text" id="id2" name="price"
												onblur="checkiinfor2()" />
										</div>
									</div>
									<div class="control-group success">
										<label class="control-label" for="inputError">种类</label>
										<div class="controls">
											<input type="text" name="kind" id="id3"
												onblur="checkiinfor3()" />
										</div>
									</div>
									<div class="control-group success">
										<label class="control-label" for="inputError">菜系</label>
										<div class="controls">
											<input type="text" name="style" id="id4"
												onblur="checkiinfor4()" />
										</div>
									</div>

									<div class="control-group success">
										<label class="control-label" for="inputError">优惠</label>
										<div class="controls">
											<select name="discount">
												<c:forEach var="emp" items="${list}">
													<option value=' ${emp.pr_id}'>折扣：${emp.discount}
														开始时间${emp.p_time }结束时间--${emp.p_end }</option>
													<br />
												</c:forEach>
											</select>
										</div>
									</div>
									<label class="control-label" for="selectError">上传照片</label>
									<div class="controls">
										<input type="file" name="file" onblur="checkiinfor5()"
											id="id5">
									</div>

									<div class="form-actions">
										<input type="submit" value="添加" class="btn btn-primary" />
										<button type="reset" class="btn">取消</button>
									</div>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="form-actions">
			<%@ include file="../../AssemblingJSP/mainJSP/footer.jsp"%>
		</div>
	</div>
	<script Charset="UTF-8">
		var xmlHttp;
		function checkiinfor() {
			var reg = /^([A-Za-z]|[\u4E00-\u9FA5])+$/;
			var name = document.getElementById("id1").value;
			if(!reg.test(name)){
				alert("只能输入汉字和英文");
			}
				
			else if (name.length == 0) {
				alert("输入名称");
			}
		}

		function checkiinfor2() {
			var reg = new RegExp("^[0-9]*$");
			var price = document.getElementById("id2").value;
			if (!reg.test(price)) {
				alert("输入数字");
			}
			else 
				if (price.length == 0) {
				alert("请输入价格");
			}

		}
		function checkiinfor3() {
			var reg = /^[\u4e00-\u9fa5]+$/;
			var kind = document.getElementById("id3").value;
			if (!reg.test(kind)) {
				alert("输入汉字");
			}
			if (kind.length == 0) {
				alert("输入种类");
			}
		}
		function checkiinfor4() {
			var reg = /^[\u4e00-\u9fa5]+$/;
			var style = document.getElementById("id4").value;
			if (!reg.test(style)) {
				alert("输入汉字");
			}
			if (style.length == 0) {
				alert("输入菜系");
			}

		}
		function checkiinfor5() {
			var file = document.getElementById("id5").value;
			if (file.length == 0) {
				alert("选择照片");
			}
		}
	</script>
</body>
</html>