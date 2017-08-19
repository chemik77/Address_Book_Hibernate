<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/style.css" type="text/css">
<title>Address Book</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>Address Book</h1>
		</div>
		<div class="list">
			<h1>All Contacts</h1>
			<a href="add">Add</a> <br /> <br />
			<c:forEach items="${requestScope.persons}" var="persons">
				<a href="showDetails?id=<c:out value="${persons.id }"></c:out>"><c:out
						value="${persons}"></c:out></a>
				<br />
			</c:forEach>

		</div>
		<div class="details">
			<h1>Details for:</h1>
			<c:if test="${requestScope.contact ne null }">
				<c:out value="${requestScope.contact.person }"></c:out>
				<br />
				<br />
				<c:out value="${requestScope.contact.email }"></c:out>
				<br />
				<c:out value="${requestScope.contact.phone }"></c:out>
				<br />
				<br />
				<p>Address:</p>
				<c:out value="${requestScope.address.street }"></c:out>
				<c:out value="${requestScope.address.houseNo }"></c:out>
				<br />
				<c:out value="${requestScope.address.zipCode }"></c:out>
				<c:out value="${requestScope.address.city }"></c:out>
				<br />
				<br />
				<br />

				<a
					href="update?id=<c:out value="${requestScope.contact.person.id }"></c:out>">Edit</a>
				<a
					href="delete?id=<c:out value="${requestScope.contact.person.id }"></c:out>">Delete</a>
			</c:if>


		</div>
		<div class="footer">
			<p>Footer</p>
		</div>
	</div>
</body>
</html>