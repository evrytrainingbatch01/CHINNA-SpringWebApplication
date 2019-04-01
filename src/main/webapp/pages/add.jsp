<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>EvryIndia Bank</title>
<body>
	<h2>Welcome to EvryIndia Bank</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Add Account</h3>
	<form method="POST" name="add_account"
		action="<%=request.getContextPath()%>/add/account">
		AccountNumber: <input name="accountNumber" value="${accountNumber}" type="text" /> <br /><br />
		AccountName: <input name="accountName" value="${accountName}" type="text" /> <br /><br />
		 BankName: <input name="bankName" value="${bankName}" type="text" /> <br /><br />
		 BranchName: <input name="branchName" value="${branchName}" type="text" /> <br /><br />
		 Balance: <input name="balance" value="${balance}" type="text" /> <br /><br />
		  <input value="Add Account" type="submit" />
	</form>
</body>
</html>