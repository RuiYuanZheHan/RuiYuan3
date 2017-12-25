<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>优惠管理</title>
<!-- Bootstrap
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="../bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" media="screen">
<link href="../assets/styles.css" rel="stylesheet" media="screen">
<link href="../assets/DT_bootstrap.css" rel="stylesheet" media="screen">
<script src="../vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
 -->
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<%@ include file="../../AssemblingJSP/mainJSP/top.jsp"%>
	</div>
	<div class="row-fluid">
		<%@ include file="../../AssemblingJSP/Addpriv/left.jsp"%>
		<div class="span9" id="content" style="float: left;">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">优惠信息</div>
						</div>
						<div class="block-content collapse in">
							<div class="span12">

								<table class="table table-striped table-bordered" id="example">
									<thead>
										<tr>
											<th>优惠编号</th>
												<th>折扣</th>
											<th>开始日期</th>
											<th>截止日期</th>
											<th>详细</th>
											<th>修改</th>
											<th>删除</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="emp" items="${list}">
											<tr>
												<td>${emp.pr_id}</td>
												<td>${emp.discount}</td>
												<td>${emp.p_time}</td>
												<td>${emp.p_end}</td>
												<td><a href="showpriv.do?id=${emp.pr_id}">查看</a></td>
												<td><a href="privilegeupdate.do?id=${emp.pr_id}">修改</a></td>
												<td><a href="privilegedelete.do?id=${emp.pr_id}">删除</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<table>
									<tr>
										<td>打折菜品数量：${i}</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!-- /block -->
				</div>
			</div>
			<div class="form-actions">
				<%@ include file="../../AssemblingJSP/mainJSP/footer.jsp"%>
			</div>
		</div>
		<hr>
	</div>

</body>
</html>