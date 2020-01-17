<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>updating a publisher</title>
</head>
<body>
	<div align="center">
		<form:form action="updatePublisher" method="post" 
			modelAttribute="editedpublisher">
			<table>
					<form:hidden path="id" />
				
				<tr>
					<td>Username</td>
					<td><form:input path="username" /></td>
				</tr>

				<tr>
					<td>Country</td>
					<td><form:input path="country" /></td>
				</tr>

				<tr>
					<td colspan="3"><input type="submit" value="update publisher information"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>