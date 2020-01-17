<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<body>
	<div>
		<a href="addfootage">Add a new footage</a>
	</div>

	<div align="center">
		Real Footage List
		<table border="1">
			<tr>
				<th>title</th>
				<th>time</th>
				<th>location</th>
			</tr>

			<c:forEach var="footage" items="${footageList}">
				<tr>
					<td><c:out value="${footage.title}"></c:out></td>
					<td><c:out value="${footage.time}"></c:out></td>
					<td><c:out value="${footage.location}"></c:out></td>
					<td><a href="editfootage?footageId=${footage.id}">update
							footage information!</a></td>
					<td><a href="deletefootage?footageId=${footage.id}">delete
							footage information!</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>