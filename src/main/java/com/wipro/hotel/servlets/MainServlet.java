package com.wipro.hotel.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.wipro.hotel.bean.RoomReservationBean;
import com.wipro.hotel.service.Administrator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Administrator admin = new Administrator();
    public String addRecord(HttpServletRequest request) {
        String result = "FAIL";
        try {
            RoomReservationBean bean = new RoomReservationBean();
            bean.setRecordId(request.getParameter("recordId"));
            bean.setGuestName(request.getParameter("guestName"));
            bean.setRoomType(request.getParameter("roomType"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date utilCheckIn = sdf.parse(request.getParameter("checkInDate"));
            Date utilCheckOut = sdf.parse(request.getParameter("checkOutDate"));
            java.sql.Date sqlCheckIn =new java.sql.Date(utilCheckIn.getTime());
            java.sql.Date sqlCheckOut =new java.sql.Date(utilCheckOut.getTime());
            bean.setCheckInDate(sqlCheckIn);
            bean.setCheckOutDate(sqlCheckOut);
            bean.setRoomNo(request.getParameter("roomNo"));
            bean.setRemarks(request.getParameter("remarks"));
            result = admin.addRecord(bean);
        } catch (Exception e) {
            e.printStackTrace(); 
            result = "FAIL";
        }
        return result;
    }
    public RoomReservationBean viewRecord(HttpServletRequest request) {
        RoomReservationBean bean = null;
        try {
            String guestName = request.getParameter("guestName");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date utilDate =sdf.parse(request.getParameter("checkInDate"));
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            bean = admin.viewRecord(guestName, sqlDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public List<RoomReservationBean> viewAllRecords() {
        return admin.viewAllRecords();
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if (operation == null) {
            response.sendRedirect("error.html");
            return;
        }
        try {
            if ("newRecord".equals(operation)) {
                String result = addRecord(request);
                if ("FAIL".equals(result) ||
                    "INVALID INPUT".equals(result) ||
                    "INVALID GUEST NAME".equals(result) ||
                    "INVALID DATE RANGE".equals(result) ||
                    "ALREADY EXISTS".equals(result)) {
                    response.sendRedirect("error.html");
                } else {
                    response.sendRedirect("success.html");
                }
            }
            else if ("viewRecord".equals(operation)) {
                RoomReservationBean bean = viewRecord(request);
                if (bean == null) {
                    request.setAttribute("message",
                            "No matching records exists! Please try again!");
                } else {
                    request.setAttribute("bean", bean);
                }

                RequestDispatcher rd =request.getRequestDispatcher("displayRoomReservation.jsp");
                rd.forward(request, response);
            }

            else if ("viewAllRecords".equals(operation)) {
                List<RoomReservationBean> list = viewAllRecords();
                if (list == null || list.isEmpty()) {
                    request.setAttribute("message","No records available!");
                } else {
                    request.setAttribute("list", list);
                }
                RequestDispatcher rd =request.getRequestDispatcher("displayAllRoomReservations.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}
