<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="a"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h1>Form Registr</h1>
		<a:form action="register">
			<a:textfield label="Enter Your Name" name="name"></a:textfield>
			<a:textfield label="Enter Your Mail" name="mail"></a:textfield>
			<a:textfield label="Set Password" name="password"></a:textfield>
			<a:submit value="Register"></a:submit>
		</a:form>
	</center>
</body>
</html>