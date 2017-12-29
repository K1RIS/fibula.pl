<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List"%>
<%@ page import="pl.fibula.entity.Hero"%>
<%@ page import="pl.fibula.entity.User"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page = "../header.jsp" />
	<%
		User user = (User) request.getAttribute("user");
		List<Hero> heroes = user.getHeroes();
	%>
	<p>
		witaj 
		<%
			out.print(user.getName());
		%>
	</p>
	<a href="http://localhost:8080/account/changepassword">change password</a>
	<a href="http://localhost:8080/account/changeemail">change email</a>
	<a href="http://localhost:8080/account/character/create">create character</a>
	<%if(!user.getHeroes().isEmpty()){ %>
	<table>
		<tr>
			<th>nazwa</th>
			<th colspan="2">opcje</th>
		</tr>
		<%
			for (int i = 0; i < heroes.size(); i++) {
		%>
		<tr>
			<td>
				<%
					out.print(heroes.get(i).getName());
				%>
			</td>
			<td><a href="http://localhost:8080/account/character/edit/<%out.print(heroes.get(i).getName());%>">edytuj</a></td>
			<td><a href="http://localhost:8080/account/character/delete/<%out.print(heroes.get(i).getName());%>">usun</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<%} %>
	<a href="http://localhost:8080/account/logout">logout</a>
</body>
</html>