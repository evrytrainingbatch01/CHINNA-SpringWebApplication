<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>EvryIndia Bank</title>
<body>
	<h2>Spring MVC and JDBC CRUD Example</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${account != null}">
			<h3>List of Accounts</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>AID</th>
						<th>AccountNumber</th>
						<th>AccountName</th>
						<th>BankName</th>
						<th>BranchName</th>
						<th>Balance</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ac" items="${account}">
						<tr>
							<td>${ac.aid}</td>
							<td>${ac.accountNumber}</td>
							<td>${ac.accountName}</td>
							<td>${ac.bankName}</td>
							<td>${ac.brnchName}</td>
							<td>${ac.balance}</td>
							<td><a
								href="<%=request.getContextPath()%>/update/account/${ac.aid}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/delete/account/${ac.aid}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        No Account found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>