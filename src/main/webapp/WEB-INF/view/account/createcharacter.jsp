<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page = "../header.jsp" />
	<f:form method="post" modelAttribute="hero">
		<f:errors path="*" />
		login<f:input path="name" />
		<f:select path="gender.id" items="${genders}" itemValue="id" itemLabel="name" />
		<input type="submit" />
	</f:form>
</body>
</html>