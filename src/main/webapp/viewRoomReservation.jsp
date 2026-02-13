<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Room Reservation</title>
</head>
<body>
<h2>View Room Reservation</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="viewRecord"/>
Guest Name: <input type="text" name="guestName"/><br><br>
Check-In Date: <input type="date" name="checkInDate"/><br><br>
<input type="submit" value="View Reservation"/>
</form>
</body>
</html>