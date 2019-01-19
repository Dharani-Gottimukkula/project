<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<springform:form action="addsubcategory" method="post"
		modelAttribute="subcategory">
		<table>
			<tr>
				<td><label>Category</label></td>
				<td><springform:select path="category.categoryId">
						<c:forEach items="${categories }" var="category">
							<springform:option value="${category.categoryId}">${category.categoryName}</springform:option>
						</c:forEach>
					</springform:select></td>
			</tr>
			<tr>
				<td><label>Sub Category Name</label></td>
				<td><springform:input path="subCategoryName" /></td>
			</tr>
			<tr>
				<td><label>Sub Category Description</label></td>
				<td><springform:input path="subCategoryDescription" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><springform:button
						value="submit">Add Sub Category</springform:button></td>
			</tr>
		</table>
	</springform:form>
</body>
</html>