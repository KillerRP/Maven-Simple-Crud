<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
<h2>Edit Form</h2>
	<form:form method="POST" action="/springJDBC/editsave">
	<form:hidden  path="enrollment_id" />
		Enter FirstName: 
		<form:input path="first_name" />
			<br />
			<br />
		Enter LastName: <form:input path="last_name" />
			<br />
			<br />
		Enter Gender: <form:input path="gender" />
			<br />
			<br />
		Enter Date of Birth: <form:input path="dob" />
			<br />
			<br />
		Enter State: <form:input path="state" />
			<br />
			<br />
		Enter Marks: <form:input path="marks" />
			<br />
			<br />
		Enter Course: <form:input path="course" />
			<br />
			<br />
		Enter Date of admission: <form:input path="doa" />
			<br />
			<br />
		Enter City: <form:input path="city" />
			<br />
			<br />
		Enter Mobile: <form:input path="mobile" />
			<br />
			<br />
		SSC Percentage: <form:input path="ssc_percentage" />
			<br />
			<br />
		HSC Percentage: <form:input path="hsc_percentage" />
			<br />
			<br />
		Category: <form:input path="category" />
			<br />
			<br />
			<input type="submit" value="Edit">
			<br />
			<br />
		</form:form>

</body>
</html>