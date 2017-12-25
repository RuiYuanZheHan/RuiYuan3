<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<td>名称${aa.vname}</td>
		</tr>
		<tr>
			<td>优惠开始时间：${aa.pr_id.getP_time()}</td>
		</tr>
		<tr>
			<td>开始结束时间：${aa.pr_id.getP_end()}</td>
		</tr>

		<tr>
			<td>价格：${aa.vprice}</td>
		</tr>
		<tr>
			<td>种类：${aa.vkind}</td>
		</tr>
		<tr>
			<td>类型：${aa.vege_style}</td>
		</tr>
		<tr>
			<td><img src="showvegephoto.do?id=${aa.vname}"/></td>
		</tr>
		<tr>
			<td><a href="vege.do">返回</a></td>
		</tr>
	</table>
</body>
</html>

