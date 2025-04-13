package org.example.ZohoLevel_3.TaxiBooking.model;

public class Booking {
    private  int bookingId;
    private  int customerId;
    private  char pickUpPoint;
    private char dropPoint;
    private  int pickUpTime;
    private  int dropTime;
    private  int amount;


    public Booking(int bookingId, int customerId,char pickUpPoint, char dropPoint, int pickUpTime, int dropTime,int amount) {
        this.amount = amount;
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.dropPoint = dropPoint;
        this.dropTime = dropTime;
        this.pickUpPoint = pickUpPoint;
        this.pickUpTime = pickUpTime;
    }

    public int getAmount() {
        return amount;
    }

    public Booking setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Booking setBookingId(int bookingId) {
        this.bookingId = bookingId;
        return this;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Booking setCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public Booking setDropPoint(char dropPoint) {
        this.dropPoint = dropPoint;
        return this;
    }

    public int getDropTime() {
        return dropTime;
    }

    public Booking setDropTime(int dropTime) {
        this.dropTime = dropTime;
        return this;
    }

    public char getPickUpPoint() {
        return pickUpPoint;
    }

    public Booking setPickUpPoint(char pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
        return this;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public Booking setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
        return this;
    }
}
