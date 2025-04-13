package org.example.ZohoLevel_3.TaxiBooking.service;
import org.example.ZohoLevel_3.TaxiBooking.model.Booking;
import org.example.ZohoLevel_3.TaxiBooking.model.Taxi;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TaxiService {
//    Duration duration=Duration.between()
    private  static  List<Taxi> taxis=new ArrayList<>();
    private  int customerCount=1;
    public void initializeTaxis(int n){
        for(int i=1;i<=n;i++){
            taxis.add(new Taxi(i));
        }
        System.out.println(n+" Taxi Initialized Successfully");
    }
    public boolean bookTaxi(char from,char to,int pickUpTime){
        int customerId=customerCount++;
        Taxi selectTaxi=null;
        int minDistance=Integer.MAX_VALUE;
        for(Taxi taxi:taxis){
            if(taxi.isAvailable(pickUpTime)) {
                int distance = Math.abs(taxi.getCurrentPoint() - from);
                if (distance < minDistance || (distance == minDistance) && (selectTaxi == null || taxi.getTotalEarnings() < selectTaxi.getTotalEarnings())) {
                    selectTaxi = taxi;
                    minDistance = distance;
                }
            }
        }
        if(selectTaxi==null)return false;
        int dropTime=pickUpTime+Math.abs(to-from);
        int amount=selectTaxi.calculateEarnings(from,to);
        int bookingId=selectTaxi.getBookings().size()+1;
        Booking booking=new Booking(bookingId,customerId,from,to,pickUpTime,dropTime,amount);
        selectTaxi.setBookings(booking);
        System.out.println(" Taxi-"+selectTaxi.getId()+" is Booked for you \\n");
        saveToFile(booking,selectTaxi.getId());
        return true;
    }
    public  void displayTaxiDetails(){
        System.out.flush();
        for (Taxi taxi : taxis) {
            System.out.println("🚖 Taxi-" + taxi.getId() + " Total Earnings: Rs." + taxi.getTotalEarnings());
            System.out.printf("%-10s %-12s %-6s %-6s %-12s %-10s %-8s%n",
                    "BookingID", "CustomerID", "From", "To", "PickupTime", "DropTime", "Amount");
            for (Booking b : taxi.getBookings()) {
                System.out.printf("%-10d %-12d %-6c %-6c %-12d %-10d %-8d%n",
                        b.getBookingId(), b.getCustomerId(), b.getPickUpPoint(), b.getDropPoint(),
                        b.getPickUpTime(), b.getDropTime(), b.getAmount());
            }
            System.out.println();
        }
    }
    public  void saveToFile(Booking b,int taxiId){
        try(FileWriter fw=new FileWriter("C:\\Users\\DELL\\Desktop\\LeetCodePractice\\src\\main\\java\\org\\example\\ZohoLevel_3\\Taxi\\data\\bookings.txt",true)){
             fw.write("Taxi-" + taxiId + ": BookingID=" + b.getBookingId() + ", CustomerID=" + b.getCustomerId() +
                     ", From=" + b.getPickUpPoint() + ", To=" + b.getDropPoint() +
                     ", PickupTime=" + b.getPickUpTime() + ", DropTime=" + b.getDropTime() +
                     ", Amount=" + b.getAmount() + "\n");

        }catch (Exception e){
            System.out.println("Error saving booking to file.");
        }

    }
}
