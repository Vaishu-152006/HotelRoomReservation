<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.wipro.hotel.bean.RoomReservationBean" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
RoomReservationBean bean =
    (RoomReservationBean) request.getAttribute("bean");

String message = (String) request.getAttribute("message");

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation Details</title>
</head>
<body>

<h2>Reservation Details</h2>

<%
if (bean != null) {
%>
Record ID: <%= bean.getRecordId() %><br><br>
Guest Name: <%= bean.getGuestName() %><br><br>
Room Type: <%= bean.getRoomType() %><br><br>
Check-In Date: <%= sdf.format(bean.getCheckInDate()) %><br><br>
Check-Out Date: <%= sdf.format(bean.getCheckOutDate()) %><br><br>
Room No: <%= bean.getRoomNo() %><br><br>
Remarks: <%= bean.getRemarks() %><br><br>
<%
} else {
%>
<h3><%= message != null ? message : "No matching records exists! Please try again!" %></h3>
<%
}
%>

<br>
<a href="menu.html">Back to Menu</a>

</body>
</html>
