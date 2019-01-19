<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>${login_error}
<form action="login" method="POST">
<input type="text" name="username">
<input type="password" name="password">
<input type="submit" value="submit">
</form>

</body>
</html>