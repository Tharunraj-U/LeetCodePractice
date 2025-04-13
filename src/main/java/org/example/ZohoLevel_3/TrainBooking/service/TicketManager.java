package org.example.ZohoLevel_3.TrainBooking.service;

import org.example.ZohoLevel_3.TrainBooking.model.Passenger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TicketManager {
   private  static  int ticketId=1;
   private  final  int totalConfirmed=1;
   private  final  int total_RAC=1;
   private  final  int totalWaitingList=1;
   Queue<Passenger> racList=new LinkedList<>();
   Queue<Passenger>  waitingList=new LinkedList<>();
    List<Passenger> bookedList = new ArrayList<>();
   List<Passenger> childList=new ArrayList<>();

   List<String> availableBerth=new ArrayList<>();
   String arr[]={"L","M","U"};
    public void InitializeSystem(){
         for(int i=0;i<totalConfirmed;i++){
             availableBerth.add(arr[i%3]);
         }
         for (int i=0;i<totalConfirmed;i++){
             availableBerth.add("SL");
         }
    }
    public  void bookTicket(String name,int age,String gender,String berthPref){
        if(age<5){
            Passenger childPassenger=new Passenger(age,"No Berth",berthPref,gender,name,-1);
            childList.add(childPassenger);
            System.out.println("Child under 5. No ticket allotted, details saved.");
            return ;
        }
        if(bookedList.size() < totalConfirmed){
               String berth=assignBirth(age,gender,berthPref);
               Passenger passenger=new Passenger(age,berth,berthPref,gender,name,ticketId);
               bookedList.add(passenger);
               availableBerth.remove(berth);
               System.out.println("Ticket Booked \nTicket ID :"+ ticketId++ +"\n Allotted Berth: " + berth);
        }else if( racList.size() < total_RAC){
            Passenger passenger=new Passenger(age,"SL",berthPref,gender,name,ticketId);
            racList.add(passenger);
            System.out.println("Added to RAC \nTicket ID :"+ ticketId++ );
        } else if (waitingList.size() < totalWaitingList) {
            Passenger passenger=new Passenger(age,"SL",berthPref,gender,name,ticketId);
            waitingList.add(passenger);
            System.out.println("Added to Waiting  \n Ticket ID :"+ ticketId++);
        }else{
            System.out.println("No tickets available.");
        }
    }

    private String assignBirth(int age, String gender, String berthPref) {
        if(age > 60 || gender.equalsIgnoreCase("F")){
            if(availableBerth.contains("L"))return "L";
        }
        if(availableBerth.contains(berthPref))return berthPref;
        if(availableBerth.contains("L"))return  "L";
        if(availableBerth.contains("M"))return  "M";
        return  "U";
    }

    public  void CancelTicket(int TicketId){
        Passenger passengerToRemove=null;
        for(Passenger p:bookedList){
            if(p.getPassengerId() == TicketId){
                passengerToRemove=p;
                availableBerth.add(passengerToRemove.getAllocatedBerth());
            }
        }
        if(passengerToRemove != null) {
            bookedList.remove(passengerToRemove);
            if (!racList.isEmpty()) {
                Passenger passenger = racList.poll();
                passenger.setAllocatedBerth(assignBirth(passenger.getAge(), passenger.getGender(), passenger.getBirthPreference()));
                bookedList.add(passenger);
                availableBerth.remove(passengerToRemove.getAllocatedBerth());
                if (!waitingList.isEmpty()) {
                    racList.add(waitingList.poll());
                }
            }
            System.out.println("Ticket cancelled and lists updated.");
        }else {
            System.out.println("Passenger ID not found.");
        }

    }
    public void printBookedTickets(){
        System.out.println("--- Booked Tickets ---");
         for(Passenger passenger:bookedList){
            System.out.println("ID :"+passenger.getPassengerId()+"  Passenger Name :"+passenger.getName()+"  Age :"+passenger.getAge()+" Gender :"+passenger.getGender()+" Berth :"+passenger.getAllocatedBerth());
         }
        System.out.println("Total Booked: " + bookedList.size());
    }
    public void printAvailableTickets(){
        System.out.println("--- Available Tickets ---");
        System.out.println("Available  Berth :"+(totalConfirmed -bookedList.size()));
        System.out.println("RAC :"+(total_RAC -racList.size()));
        System.out.println("Waiting List:"+(totalWaitingList -waitingList.size()));

    }



}
