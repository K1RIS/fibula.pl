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
	<f:form method="post" modelAttribute="user">
		<f:errors path="*" />
		login<f:input path="name" /> 
		haslo<f:input path="password" />
		email<f:input path="email"/>
		<input type="submit" />
	</f:form>
</body>
</html>