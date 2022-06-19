<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="dashboard.css"/>
</head>
<body>
<div  class="bg-container">
<div>
	<h1>Displaying All Active Requests</h1>
		<table>
			<thead>
				<tr>
					<td>Name</td>
					<td>Email</td>
					<td>Message</td>
					<td>isActive</td>
					<td>changeStatus</td>
					<td>createdAt</td>
				</tr>
			</thead>
			<tb>
			 <c:forEach items="${activeRequests}" var="query">
			   <tr>
			     <td>${query.name}</td>
			     <td>${query.email}</td>
			     <td>${query.message}</td>
			     <c:if test="${query.isActive==true}">
			     	<td>1</td>
			     </c:if>
			     <td><form action="dashboard" method="post">
			     	<button type="submit" name="getQueryId" value="${query.id}">make archive</button>
			     </form></td>
			     <td>${query.date}</td>
			   </tr>
			  </c:forEach>
			  </tb>
		</table>
	</div>
<div>
<div>
	<h1>Displaying All Archive Requests</h1>
		<table>
			<thead>
				<tr>
					<td>Name</td>
					<td>Email</td>
					<td>Message</td>
					<td>isActive</td>
					<td>createdAt</td>
				</tr>
			</thead>
			<tb>
			 <c:forEach items="${archiveRequests}" var="query">
			   <tr>
			     <td>${query.name}</td>
			     <td>${query.email}</td>
			     <td>${query.message}</td>
			     <c:if test="${query.isActive==false}">
			     	<td>0</td>
			     </c:if>
			     <td>${query.date}</td>
			   </tr>
			  </c:forEach>
			  </tb>
		</table>
	</div>
<div>
</body>
</html>