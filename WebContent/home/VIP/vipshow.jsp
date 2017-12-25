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
		<thead>
			<tr>
				<td>姓名：${aa.name}</td>
			</tr>
			<tr>
				<td>电话：${aa.phone}</td>
			</tr>
			<tr>
				<td>折扣：${aa.privilege_cir}</td>
			</tr>
		</thead>
		<tr>
			<td>会员名称</td>
			<td>菜名</td>
			<td>就餐时间</td>
			<td>订单编号</td>
		</tr>

		<tbody>
			<c:forEach var="emp" items="${list}">
				<tr>
					<td>${emp.consumer}</td>
					<td>${emp.vegemodel.getVname()}</td>
					<td>${emp.eattime}</td>
					<td>${emp.vegebillid}</td>
				</tr>
			</c:forEach>

		</tbody>
		<tr>
			<td>总消费金额</td>
			<td>${sum}</td>
		</tr>
		<tr>
			<td><a href="vip.do">返回</a></td>
		</tr>
	</table>



</body>
</html>

