<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>test</title>
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<th>title</th>
				<th>time</th>
				<th>location</th>
			</tr>

			<c:forEach var="student" items="${footageList}">
				<tr>
					<td>"${footage.title}"</td>
					<td>"${footage.time}"</td>
					<td>"${footage.location}"</td>
				</tr>
			</c:forEach>

		</table>


	</div>

</body>
</html>