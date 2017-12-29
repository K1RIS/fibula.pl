<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
  <script src="/registervalidate.js"></script>

</head>
<body>
	<jsp:include page = "../header.jsp" />
	<f:form method="post" modelAttribute="user">
		<f:errors path="*" />
	    <div id="login">
	     	<label>login<f:input path="name"/></label>
	    </div>
		<div id="password">
	      haslo<f:input path="password" />
	    </div>
		<div id="email">
	  		<label>email<f:input path="email"/></label>
	    </div>
		<input type="submit" />
	</f:form>
</body>
</html>
