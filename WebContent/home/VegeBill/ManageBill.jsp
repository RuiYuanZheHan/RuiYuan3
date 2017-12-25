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
								<form class="form-horizontal" method="post"
									action="trueadd.do">
									请输入姓名 <input type="text" name="name" /> <input type="submit"
										value="确认" />
								</form>
							</div>
						</div>
					</div>
					<!-- /block -->
				</div>
			</div>
			<div class="form-actions">
			<a href="../main/login.jsp">返回登录界面</a>
			</div>
		</div>
		<hr>
	</div>
</body>
</html>