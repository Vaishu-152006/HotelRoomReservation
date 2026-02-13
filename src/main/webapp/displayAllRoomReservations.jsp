<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.wipro.hotel.bean.RoomReservationBean" %>
<%@ page import="java.text.SimpleDateFormat" %>
    
<%
Object obj = request.getAttribute("list");
List<RoomReservationBean> list = null;

if (obj != null) {
    list = (List<RoomReservationBean>) obj;
}
%>
<% 
String message = (String) request.getAttribute("message");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>All Room Reservations</h2>
<%
if (list != null && !list.isEmpty()) {
%>
<table border="1">
<tr>
    <th>Record ID</th>
    <th>Guest Name</th>
    <th>Room Type</th>
    <th>Check-In</th>
    <th>Check-Out</th>
    <th>Room No</th>
    <th>Remarks</th>
</tr>
<%
for (RoomReservationBean bean : list) {
%>
<tr>
    <td><%= bean.getRecordId() %></td>
    <td><%= bean.getGuestName() %></td>
    <td><%= bean.getRoomType() %></td>
    <td><%= sdf.format(bean.getCheckInDate()) %></td>
    <td><%= sdf.format(bean.getCheckOutDate()) %></td>
    <td><%= bean.getRoomNo() %></td>
    <td><%= bean.getRemarks() %></td>
</tr>
<%
}
%>

</table>
<%
} else {
%>
<h3><%= message %></h3>
<%
}
%>
<a href="menu.html">Back to Menu</a>
</body>
</html>