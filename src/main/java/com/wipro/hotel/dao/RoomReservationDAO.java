package com.wipro.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.wipro.hotel.bean.RoomReservationBean;
import com.wipro.hotel.util.DBUtil;

public class RoomReservationDAO {
	 public String createRecord(RoomReservationBean bean) {
	        String result = "FAIL";
	        try {
	            Connection con = DBUtil.getDBConnection();
	            String sql = "INSERT INTO ROOMRES_TB VALUES(?,?,?,?,?,?,?)";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, bean.getRecordId());
	            ps.setString(2, bean.getGuestName());
	            ps.setString(3, bean.getRoomType());
	            ps.setDate(4, new java.sql.Date(bean.getCheckInDate().getTime()));
	            ps.setDate(5, new java.sql.Date(bean.getCheckOutDate().getTime()));
	            ps.setString(6, bean.getRoomNo());
	            ps.setString(7, bean.getRemarks());
	            int rows = ps.executeUpdate();
	            if (rows > 0) {
	                result = bean.getRecordId();
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	 
	 public RoomReservationBean fetchRecord(String guestName, java.util.Date checkIn) {
	        RoomReservationBean bean = null;
	        try {
	            Connection con = DBUtil.getDBConnection();
	            String sql = "SELECT * FROM ROOMRES_TB WHERE GUESTNAME=? AND CHECKIN_DATE=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, guestName);
	            ps.setDate(2, new java.sql.Date(checkIn.getTime()));
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                bean = new RoomReservationBean();
	                bean.setRecordId(rs.getString("RECORDID"));
	                bean.setGuestName(rs.getString("GUESTNAME"));
	                bean.setRoomType(rs.getString("ROOMTYPE"));
	                bean.setCheckInDate(rs.getDate("CHECKIN_DATE"));
	                bean.setCheckOutDate(rs.getDate("CHECKOUT_DATE"));
	                bean.setRoomNo(rs.getString("ROOMNO"));
	                bean.setRemarks(rs.getString("REMARKS"));
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return bean;  
	    }
	 
	 public String generateRecordID(String guestName, Date checkInDate) {
		    String recordId = "";
		    try {
		        if (guestName == null || guestName.length() < 2 || checkInDate == null) {
		            return "";
		        }
		        Connection con = DBUtil.getDBConnection();
		        Statement st = con.createStatement();
		        ResultSet rs = st.executeQuery("SELECT ROOMRES_SEQ.NEXTVAL FROM DUAL");
		        int seq = 0;
		        if (rs.next()) {
		            seq = rs.getInt(1);
		        }
		        String datePart = new java.text.SimpleDateFormat("yyyyMMdd").format(checkInDate);
		        String namePart = guestName.substring(0, 2).toUpperCase();
		        recordId = datePart + namePart + seq;
		        rs.close();
		        st.close();
		        con.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return recordId;
		}

	   public boolean recordExists(String guestName, Date checkInDate) {
	        boolean exists = false;
	        RoomReservationBean bean = fetchRecord(guestName, checkInDate);
	        if (bean != null) {
	            exists = true;
	        }
	        return exists;
	    }
	   
	   public List<RoomReservationBean> fetchAllRecords() {
	        List<RoomReservationBean> list = new ArrayList<>();
	        try {
	            Connection con = DBUtil.getDBConnection();
	            String sql = "SELECT * FROM ROOMRES_TB";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            while (rs.next()) {
	                RoomReservationBean bean = new RoomReservationBean();
	                bean.setRecordId(rs.getString("RECORDID"));
	                bean.setGuestName(rs.getString("GUESTNAME"));
	                bean.setRoomType(rs.getString("ROOMTYPE"));
	                bean.setCheckInDate(rs.getDate("CHECKIN_DATE"));
	                bean.setCheckOutDate(rs.getDate("CHECKOUT_DATE"));
	                bean.setRoomNo(rs.getString("ROOMNO"));
	                bean.setRemarks(rs.getString("REMARKS"));
	                list.add(bean);
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;  
	    }
	}


