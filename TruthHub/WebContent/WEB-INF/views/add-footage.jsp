<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a footage</title>
</head>
<body>
	<div align="center">
		<form:form action="saveFootage" method="post" modelAttribute="footage">
			<table>
				<form:hidden path="id" />

				<tr>
					<td>Title</td>
					<td><form:input path="title" /></td>
				</tr>

				<tr>
					<td>Time</td>
					<td><form:input path="time" /></td>
				</tr>

				<tr>
					<td>Location</td>
					<td><form:input path="location" /></td>
				</tr>

				
				<tr>
					<td>Publisher's Username</td>
					<td><form:input path="publisher.username" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add footage"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>