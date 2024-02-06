<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edite Your Mistakes here.......! ${STUDENT }</h1>

<form action="updateStudent">
<input type="text" name="id" value=${STUDENT.id } readonly="readonly"><br><br>
<input type="text" name="fname" value=${STUDENT.fname }><br><br>
<input type="text" name="lname" value=${STUDENT.lname }><br><br>
<input type="submit" value="Update">


</form>
</body>
</html>