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
			<h1>Add person:</h1>
			<form name=addForm action=addPerson method=get>
				<table border="0">
					<tr>
						<td>First name</td>
						<td><input type="text" name="firstName"></td>
					</tr>
					<tr>
						<td>Last name</td>
						<td><input type="text" name="lastName"></td>
					</tr>
					<tr>
						<td>Birth date</td>
						<td><input type="text" name="birth" value="YYYY-MM-DD"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email"></td>
						<td>Phone</td>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<td>Street</td>
						<td><input type="text" name="street"></td>
						<td>House no</td>
						<td><input type="text" name="houseNo"></td>
					</tr>
					<tr>
						<td>Zip code</td>
						<td><input type="text" name="zipCode"></td>
						<td>City</td>
						<td><input type="text" name="city"></td>
					</tr>
					<tr>
					<td><a href="read">Back</a></td>
						<td><input type="submit" name="submit" value="Add">
						<td>
					</tr>
				</table>
			</form>
		</div>
		<div class="footer">
			<p>Footer</p>
		</div>
	</div>
</body>
</html>