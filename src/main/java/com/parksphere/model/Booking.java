package com.parksphere.model;



import java.sql.Timestamp;

public class Booking {

    private int bookingId;

    private int userId;
    private int slotId;

    private String vehicleNumber;
    private String vehicleType;

    private String entryOtp;
    private String exitOtp;

    private Timestamp bookingTime;
    private Timestamp entryTime;
    private Timestamp exitTime;

    private double totalAmount;

    private String bookingStatus;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getEntryOtp() {
		return entryOtp;
	}

	public void setEntryOtp(String entryOtp) {
		this.entryOtp = entryOtp;
	}

	public String getExitOtp() {
		return exitOtp;
	}

	public void setExitOtp(String exitOtp) {
		this.exitOtp = exitOtp;
	}

	public Timestamp getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Timestamp bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Timestamp getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Timestamp entryTime) {
		this.entryTime = entryTime;
	}

	public Timestamp getExitTime() {
		return exitTime;
	}

	public void setExitTime(Timestamp exitTime) {
		this.exitTime = exitTime;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
    
    

}
