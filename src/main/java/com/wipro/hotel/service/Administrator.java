package com.wipro.hotel.service;

import java.sql.Date;
import java.util.List;import com.wipro.hotel.bean.RoomReservationBean;
import com.wipro.hotel.dao.RoomReservationDAO;
import com.wipro.hotel.util.InvalidInputException;

public class Administrator {
	   RoomReservationDAO dao = new RoomReservationDAO();
	    public String addRecord(RoomReservationBean bean) {
	        try {
	            if (bean == null || 
	                bean.getGuestName() == null || 
	                bean.getCheckInDate() == null) {
	                throw new InvalidInputException();
	            }
	            if (bean.getGuestName().length() < 2) {
	                return "INVALID GUEST NAME";
	            }
	            if (bean.getCheckOutDate().before(bean.getCheckInDate())) {
	                return "INVALID DATE RANGE";
	            }
	            if (dao.recordExists(bean.getGuestName(), bean.getCheckInDate())) {
	                return "ALREADY EXISTS";
	            }
	            String status = dao.createRecord(bean);
	            return status;
	        } catch (InvalidInputException e) {
	            return "INVALID INPUT";
	        }
	    }
	    
	    public RoomReservationBean viewRecord(String guestName, Date checkInDate) {
	        return dao.fetchRecord(guestName, checkInDate);
	    }
	    public List<RoomReservationBean> viewAllRecords() {
	        return dao.fetchAllRecords();
	    }
	}


