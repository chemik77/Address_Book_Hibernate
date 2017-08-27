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
			<div class="headerList1">
				<h1>Contact list</h1>
			</div>
			<div class="headerList2">
				<a href="add" class="button">Add</a>
			</div>

			<div class="innerList">
				<br />
				<c:forEach items="${requestScope.persons}" var="persons">
					<ul>
						<li><a
							href="showDetails?id=<c:out value="${persons.id }"></c:out>"
							class="nameList"><c:out value="${persons}"></c:out></a> <br /></li>
					</ul>
				</c:forEach>
			</div>
		</div>
		<div class="details">
			<div class="headerDetails">
				<h1>Details for:</h1>
			</div>
			<div class="innerDetails">
				<c:if test="${requestScope.contact ne null }">
					<div class="name">
						<c:out value="${requestScope.contact.person }"></c:out>
					</div>
					<br />
					<c:out value="${requestScope.contact.email }"></c:out>
					<br />
					<c:out value="${requestScope.contact.phone }"></c:out>
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
						href="update?id=<c:out value="${requestScope.contact.person.id }"></c:out>"
						class="button">Edit</a>
					<a
						href="delete?id=<c:out value="${requestScope.contact.person.id }"></c:out>"
						class="button">Delete</a>
				</c:if>

			</div>

		</div>
		<div class="footer"></div>
	</div>
</body>
</html>