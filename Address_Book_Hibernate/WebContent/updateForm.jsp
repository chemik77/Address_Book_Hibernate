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
				<h1>Edit person:</h1>
			</div>
			<div class="innerDetails">
				<form name=updateForm action=updatePerson method=get>
					<table border="0">
						<tr>
							<td>First name</td>
							<td><input type="text" name="firstName"
								value="<c:out value="${person.firstName }"></c:out>"></td>
							<td><input type="hidden" name="personId"
								value="<c:out value="${person.id }"></c:out>"></td>
							<td><input type="hidden" name="contactId"
								value="<c:out value="${contact.id }"></c:out>"></td>
							<td><input type="hidden" name="addressId"
								value="<c:out value="${address.id }"></c:out>"></td>
						</tr>
						<tr>
							<td>Last name</td>
							<td><input type="text" name="lastName"
								value="<c:out value="${person.lastName }"></c:out>"></td>
						</tr>
						<tr>
							<td>Birth date</td>
							<td><input type="text" name="birth"
								value="<c:out value="${person.birth }"></c:out>"></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="text" name="email"
								value="<c:out value="${contact.email }"></c:out>"></td>
							<td>Phone</td>
							<td><input type="text" name="phone"
								value="<c:out value="${contact.phone }"></c:out>"></td>
						</tr>
						<tr>
							<td>Street</td>
							<td><input type="text" name="street"
								value="<c:out value="${address.street }"></c:out>"></td>
							<td>House no</td>
							<td><input type="text" name="houseNo"
								value="<c:out value="${address.houseNo }"></c:out>"></td>
						</tr>
						<tr>
							<td>Zip code</td>
							<td><input type="text" name="zipCode"
								value="<c:out value="${address.zipCode }"></c:out>"></td>
							<td>City</td>
							<td><input type="text" name="city"
								value="<c:out value="${address.city }"></c:out>"></td>
						</tr>
						<tr>
							<td><br /></td>
						</tr>
						<tr>
							<td><a href="read" class="button">Back</a>  <input
								type="submit" name="submit" value="Save" class="submit">
							<td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>