<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<springform:form action="${pageContext.request.contextPath }/updatecategory" method="post" modelAttribute="category">
<springform:input path="categoryId" readonly="true"/>
<springform:input path="categoryName"/>
<springform:input path="categoryDescription"/>
<springform:button>update</springform:button>
</springform:form>

</body>
</html>