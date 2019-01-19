<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<th>SubCategoryId</th>
<th>SubCategoryName</th>
<th>SubCategoryDescription</th>
</tr>

   <c:forEach items="${subcategories}" var="subcategory">
   
   <tr>
  <td> ${subcategory.subCategoryId }</td>
   <td>${subcategory.subCategoryName }</td>
   <td>${subcategory.subCategoryDescription}</td>
   </tr>
   
   </c:forEach>

</table>
</body>
</html>