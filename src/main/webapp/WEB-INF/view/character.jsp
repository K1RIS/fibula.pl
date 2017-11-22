<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>name</th>
			<th>gender</th>
			<th>level</th>
			<th>prof</th>
		</tr>
			<tr>
				<td>${hero.name}</td>				
				<td>${hero.gender.name}</td>
				<td>${hero.level}</td>
				<td>${hero.profession.name}</td>
			</tr>
	</table>
</body>
</html>