<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>显示详细信息</title>
</head>
<body>
	<table>
		<tr>
			<td>姓名：${aa.uname}</td>
		</tr>
		<tr>
			<td>工号：${aa.uid}</td>
		</tr>
		<tr>
			<td>职位：${aa.identify}</td>
		</tr>
		<tr>
			<td><a href="../main/tomain.do">返回</a></td>
		</tr>
	</table>
</body>
</html>

