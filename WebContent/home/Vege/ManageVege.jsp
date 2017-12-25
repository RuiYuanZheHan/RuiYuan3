
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>酒店菜品管理</title>
</head>
<body>
	<div class="navbar navbar-fixed-top">

		<%@ include file="../../AssemblingJSP/mainJSP/top.jsp"%>

	</div>
	<div class="row-fluid">
		<%@ include file="../../AssemblingJSP/Addvege/left.jsp"%>
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

											<th>名称</th>
											<th>优惠开始时间</th>
											<th>优惠结束时间</th>
											<th>价格</th>
											<th>种类</th>
											<th>类型</th>
											<th>修改</th>
											<th>删除</th>
											<th>查看</th>
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
												<td><a href="skipupdatevege.do?id=${emp.vname}">修改</a></td>
												<td><a href="skipdeletevege.do?id=${emp.vname}">删除</a></td>
												<td><a href="showvege.do?id=${emp.vname}">详细信息</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<table>
									<tr>
										<td>菜品数目：${i}</td>
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