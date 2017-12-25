<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>酒店会员管理</title>
<!-- Bootstrap -->
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<%@ include file="../../AssemblingJSP/mainJSP/top.jsp"%>
	</div>
	<div class="row-fluid">
		<%@ include file="../../AssemblingJSP/AddVIP/left.jsp"%>

		<div class="span9" id="content" style="float: left;">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">桌位信息</div>
						</div>
						<div class="block-content collapse in">
							<div class="span12">

								<table class="table table-striped table-bordered" id="example">
									<thead>
										<tr>
										<th>会员号</th>
											<th>姓名</th>
											<th>电话</th>		
											<th>优惠</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="emp" items="${list}">
											<tr>
												<td>${emp.vip_ID}</td>
												<td>${emp.name}</td>
												<td>${emp.phone}</td>
												<td>${emp.privilege_cir}</td>
												<td><a href="skipupdatevip.do?id=${emp.vip_ID}">修改</a></td>
												<td><a href="skipdeletevip.do?id=${emp.vip_ID}">删除</a></td>
												<td><a href="showvip.do?id=${emp.vip_ID}+&name=${emp.name}">详细信息</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<table>
									<tr>
										<td>会员数：${i}</td>
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