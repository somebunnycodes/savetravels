<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> 
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
	
		<h1>Expense Details</h1>
		<a href="/">Go back</a>
		
		<table class="table">
			<tr>
				<th>Expense Details:</th>
				<td><c:out value="${expense.name}"/></td>
			</tr>
			<tr>
				<th>Expense Description:</th>
				<td><c:out value="${expense.description}"/></td>
			</tr>
			<tr>
				<th>Vendor:</th>
				<td><c:out value="${expense.vendor}"/></td>
			</tr>
			<tr>
				<th>Amount Spent:</th>
				<td><c:out value="${expense.amount}"/></td>
			</tr>
		</table>
	</div>

</body>
</html>