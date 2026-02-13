package com.wipro.hotel.bean;

import java.sql.Date;

public class RoomReservationBean {
	 private String recordId;
	 private String guestName;
	 private String roomType;
	 private Date checkInDate;
	 private Date checkOutDate;
	 private String roomNo;
	 private String remarks;
	 public String getRecordId() {
		 return recordId;
	 }
	 public void setRecordId(String recordId) {
		 this.recordId = recordId;
	 }
	 public String getGuestName() {
		 return guestName;
	 }
	 public void setGuestName(String guestName) {
		 this.guestName = guestName;
	 }
	 public String getRoomType() {
		 return roomType;
	 }
	 public void setRoomType(String roomType) {
		 this.roomType = roomType;
	 }
	 public Date getCheckInDate() {
		 return checkInDate;
	 }
	 public void setCheckInDate(Date checkInDate) {
		 this.checkInDate = checkInDate;
	 }
	 public Date getCheckOutDate() {
		 return checkOutDate;
	 }
	 public void setCheckOutDate(Date checkOutDate) {
		 this.checkOutDate = checkOutDate;
	 }
	 public String getRoomNo() {
		 return roomNo;
	 }
	 public void setRoomNo(String roomNo) {
		 this.roomNo = roomNo;
	 }
	 public String getRemarks() {
		 return remarks;
	 }
	 public void setRemarks(String remarks) {
		 this.remarks = remarks;
	 }
}
