package org.example.ZohoLevel_3.TaxiBooking.model;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private  int id;
    private  char currentPoint = 'A';
    private  int totalEarnings;
    private List<Booking> bookings=new ArrayList<>();
    public  Taxi(int id){
        this.id=id;
    }
    public  boolean isAvailable(int requestTime){
        if(bookings.isEmpty())return true;
        return bookings.get(bookings.size()-1).getDropTime() <= requestTime;
    }
    public  int calculateEarnings(char from,char to){
        int distance=Math.abs(to-from)*15;
        return 100+Math.max(0,distance-5)*10;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public char getCurrentPoint() {
        return currentPoint;
    }


    public int getTotalEarnings() {
        return totalEarnings;
    }

    public int getId() {
        return id;
    }

    public Taxi setBookings(Booking bookings) {
        this.bookings.add(bookings);
        this.currentPoint=bookings.getDropPoint();
        this.totalEarnings+=bookings.getAmount();
        return this;
    }


}
