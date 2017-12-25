<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示详细信息</title>
</head>
<body>
	<table>
		<tr>
			<td>编号：${aa.pr_id}</td>
		</tr>
		<tr>
			<td>优惠：${aa.discount}</td>
		</tr>
		<tr>
			<td>开始时间：${aa.p_time}</td>
		</tr>
		<tr>
			<td>结束时间：${aa.p_end}</td>
		</tr>
		<tr>
			<td><a href="priv.do">返回</a></td>
		</tr>
	</table>
</body>
</html>

