<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Publisher List</title>
</head>
<body>
	<div>
		<a href="addpublisher">Add a new publisher</a>
	</div>

	<div align="center">
		Publisher List
		<table border="1">
			<tr>
				<th>username</th>
				<th>country</th>
			</tr>

			<c:forEach var="publisher" items="${publisherList}">
				<tr>
					<td><c:out value="${publisher.username}"></c:out></td>
					<td><c:out value="${publisher.country}"></c:out></td>
					<td><a href="editpublisher?publisherId=${publisher.id}">update
							publisher information!</a></td>
					<td><a href="deletepublisher?publisherId=${publisher.id}">delete
							publisher information!</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>