<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1 style="text-align: center;">Students Details</h1>
		<a href="register" style="background-color: #f44336;
  			color: white;
  			margin-left: 45%;
  			margin-top: -30px;
  			padding: 14px 25px;
  			text-align: center;
  			text-decoration: none;
  			display: inline-block;" 
  			>Add Record </a>
  			<div style="padding-bottom: 10px;"></div>
	</header>
		<table border=1 style="margin-left: auto; margin-right: auto;">
			<tr>
				<th>Enrollment id</th>
				<th>First_Name</th>
				<th>Last_Name</th>
				<th>Gender</th>
				<th>DOB</th>
				<th>DOA</th>
				<th>State</th>
				<th>City</th>
				<th>Mobile</th>
				<th>Ssc</th>
				<th>Hsc</th>
				<th>Category</th>
				<th>Action</th>
			</tr>

			<c:forEach var="tab" items="${data}">

				<tr>
					<td>${ tab.enrollment_id }</td>
					<td>${ tab.first_name }</td>
					<td>${ tab.last_name }</td>
					<td>${ tab.gender }</td>
					<td>${ tab.dob }</td>
					<td>${ tab.doa}</td>
					<td>${ tab.state }</td>
					<td>${ tab.city }</td>
					<td>${ tab.mobile }</td>
					<td>${ tab.ssc_percentage }</td>
					<td>${ tab.hsc_percentage }</td>
					<td>${ tab.category }</td>
					<td><a href="edit/${tab.enrollment_id}">Edit</a>
    				<a href="delete/${tab.enrollment_id}">Delete</a></td>

				</tr>
			</c:forEach>

		</table>
	
</body>
</html>