<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.text.SimpleDateFormat" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Room Reservation</title>
</head>
<body>
<h2>Add Room Reservation</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="newRecord"/>
Record ID: <input type="text" name="recordId"/><br><br>
Guest Name: <input type="text" name="guestName"/><br><br>
Room Type:
<select name="roomType">
<option value="Single">Single</option>
<option value="Double">Double</option>
<option value="Deluxe">Deluxe</option>
</select><br><br>
Check-In Date:<input type="text" name="checkInDate" placeholder="yyyy-MM-dd"/><br><br>
Check-Out Date:<input type="text" name="checkOutDate" placeholder="yyyy-MM-dd"/><br><br>
Room No: <input type="text" name="roomNo"/><br><br>
Remarks: <input type="text" name="remarks"/><br><br>
<input type="submit" value="Add Reservation"/>
</form>
</body>
</html>