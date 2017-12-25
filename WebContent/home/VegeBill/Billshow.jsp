<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>酒店酒品管理</title>
<!-- Bootstrap -->
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="../bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" media="screen">
<link href="../assets/styles.css" rel="stylesheet" media="screen">
<link href="../assets/DT_bootstrap.css" rel="stylesheet" media="screen">
<script src="../vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<%@ include file="../../AssemblingJSP/mainJSP/top.jsp"%>
	</div>
	<div class="row-fluid">
		<%@ include file="../../AssemblingJSP/VegeBill/left.jsp"%>

		<div class="span9" id="content" style="float: left;">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">酒品信息</div>
						</div>
						<div class="block-content collapse in">
							<div class="span12">
								<table class="table table-striped table-bordered" id="example">
									<thead>
										<tr>
											<th>客户名称</th>
											<th>菜品名称</th>
											<th>会员编号</th>
											<th>就餐时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="emp" items="${billlist}">
											<tr>
												<td>${emp.consumer}</td>
												<td>${emp.vegemodel.getVname()}</td>
												<td>${emp.vipmodel.getVip_ID()}</td>
												<td>${emp.eattime}</td>
												<td><a href="billdelete.do?id=${emp.vegebillid}">删除</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<table>
									<tr>
										<td>总价：${sum}</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!-- /block -->
				</div>
			</div>
			<div class="form-actions">
				<a href="vegetablebill.do">返回主界面</a>
			</div>
		</div>
		<hr>
	</div>
</body>
</html>