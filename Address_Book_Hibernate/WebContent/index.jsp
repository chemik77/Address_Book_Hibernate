<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css">
<title>Address Book</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<p>Header</p>
		</div>
		<div class="list">
			<a href="read">show table</a><br />
			<table>
				<tbody>
					<tr>
						<th>Name</th>
					</tr>
					<c:forEach items="${requestScope.persons}" var="persons">
						<tr>
							<td><a
								href="showDetails?id=<c:out value="${persons.id }"></c:out>"><c:out
										value="${persons}"></c:out></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="details">
			<p>Details</p>
			<br /> <br />
			<c:out value="${requestScope.contact.email }"></c:out>
			<br /> <br />
			<c:out value="${requestScope.address }"></c:out>

		</div>
		<div class="footer">
			<p>Footer</p>
		</div>
	</div>
</body>
</html>