<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>EveyInida Bank</title>
<body>
	<h2>Welcome to EvryIndia Bank</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Update Account</h3>
	<form method="POST" name="update_account"
		action="<%=request.getContextPath()%>/update/account">
		<input hidden="hidden" name="aid" value="${aid}" type="text" /> 
		AccountNumber: <input name="accountNumber" value="${account.accountNumber}" type="text" /><br /><br />
		AccountName: <input name="accountNamer" value="${account.accountName}" type="text" /><br /><br />
		BankName: <input name="bankName" value="${account.bankName}" type="text" /><br /><br />
		BarnchName: <input name="barnchName" value="${account.barnchName}" type="text" /><br /><br />
		Balance: <input name="balance" value="${account.balance}" type="text" /><br /><br />
		
		
		 <input value="UpdateAccount" type="submit" />
	</form>
</body>
</html>