<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>添加菜品订单</title>
<!-- Bootstrap -->
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="../bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" media="screen">
<link href="../assets/styles.css" rel="stylesheet" media="screen">
<script src="../vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>

</head>
<body>
	<div class="navbar navbar-fixed-top">
		<%@ include file="../../AssemblingJSP/mainJSP/top.jsp"%>
	</div>
	<%@ include file="../../AssemblingJSP/VegeBill/left.jsp"%>
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
							<form class="form-horizontal" method="post"
								enctype="multipart/form-data">
								<fieldset>
									<table class="table table-striped table-bordered" id="example">
										<thead>
											<tr>
												<th>名称</th>
												<th>优惠开始时间</th>
												<th>优惠结束时间</th>
												<th>价格</th>
												<th>种类</th>
												<th>类型</th>
												<th>添加</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="emp" items="${list}">
												<tr>
													<td>${emp.vname}</td>
													<td>${emp.pr_id.getP_time()}</td>
													<td>${emp.pr_id.getP_end()}</td>
													<td>${emp.vprice}</td>
													<td>${emp.vkind}</td>
													<td>${emp.vege_style}</td>
													<td><a href="addvegetable.do?id=${emp.vname}">添加</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="form-actions">
				<a href="viewbill.do?id=${na }">确定</a>
			</div>
		</div>
		<!--/.fluid-container-->
	</div>
</body>
</html>