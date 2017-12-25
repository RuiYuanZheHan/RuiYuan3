<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>酒店人员管理</title>
<!-- Bootstrap -->
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<%@ include file="../../AssemblingJSP/mainJSP/top.jsp"%>
	</div>
	<div class="row-fluid">
		<%@ include file="../../AssemblingJSP/Adduser/left.jsp"%>
		<div class="span9" id="content" style="float: left;">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">用户信息</div>
						</div>
						<div class="block-content collapse in">
							<div class="span12">

								<table class="table table-striped table-bordered" id="example">
									<thead>
										<tr>
											<th>员工姓名</th>
											<th>员工号</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="emp" items="${list}">
											<tr>
												<td>${emp.uname}</td>
												<td>${emp.uid}</td>
												<td><a href="skipupdateuser.do?id=${emp.uname}">修改密码</a></td>
												<td><a href="skipdeleteuser.do?id=${emp.uid}">删除</a></td>
												<td><a href="show.do?id=${emp.uid}">查看</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<table>
									<tr>
										<td>员工数量：${i}</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
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