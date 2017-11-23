<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List"%>
<%@ page import="pl.fibula.entity.Hero"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Hero> heroes = (List<Hero>) request.getAttribute("heroes");
	%>
	<table>
		<tr>
			<th>name</th>
			<th>profession</th>
			<th>level</th>
			<th>sword fighting</th>
			<th>axe fighting</th>
			<th>spell casting</th>
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
			<td>
				<%
					out.print(heroes.get(i).getProfession());
				%>
			</td>
			<td>
				<%
					out.print(heroes.get(i).getLevel());
				%>
			</td>
			<td>
				<%
					out.print(heroes.get(i).getSwordFighting());
				%>
			</td>
			<td>
				<%
					out.print(heroes.get(i).getAxeFighting());
				%>
			</td>
			<td>
				<%
					out.print(heroes.get(i).getSpellCasting());
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>