<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��ʾ��ϸ��Ϣ</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>������${aa.name}</td>
			</tr>
			<tr>
				<td>�绰��${aa.phone}</td>
			</tr>
			<tr>
				<td>�ۿۣ�${aa.privilege_cir}</td>
			</tr>
		</thead>
		<tr>
			<td>��Ա����</td>
			<td>����</td>
			<td>�Ͳ�ʱ��</td>
			<td>�������</td>
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
			<td>�����ѽ��</td>
			<td>${sum}</td>
		</tr>
		<tr>
			<td><a href="vip.do">����</a></td>
		</tr>
	</table>



</body>
</html>

