package org.example.ZohoLevel_3.Taxi;

import org.example.ZohoLevel_3.Taxi.service.TaxiService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of Taxi :");
        int n=sc.nextInt();
        TaxiService taxiService=new TaxiService();
        taxiService.initializeTaxis(n);


        while (true){
            System.out.println("\n🛺 Taxi Booking System");
            System.out.println("1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    bookTaxi();
                    break;
                case 2:
                    taxiService.displayTaxiDetails();
                    break;
                case 3:
                    System.out.println("Goodbye 👋");
                    return;
                default:
                    System.out.println("❌ Invalid choice");
            }
            }

    }
    public static  void bookTaxi(){
        Scanner sc=new Scanner(System.in);
        TaxiService taxiService=new TaxiService();
        System.out.print("Enter the Pick Up Point :");
        char pickUpPoint=sc.nextLine().charAt(0);

        System.out.print("Enter The Drop Point :");
        char dropPoint=sc.nextLine().charAt(0);

        System.out.print("Enter the timing ");
        int time=sc.nextInt();
        if(!taxiService.bookTaxi(pickUpPoint,dropPoint,time)){
            System.out.println("❌ No taxis available at this time.\n");
        }
    }
}
