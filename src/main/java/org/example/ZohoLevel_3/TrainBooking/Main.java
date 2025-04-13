package org.example.ZohoLevel_3.TrainBooking;

import org.example.ZohoLevel_3.TrainBooking.service.TicketManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketManager manager = new TicketManager();
        manager.InitializeSystem();

        while (true) {
            System.out.println("\n1. Book Ticket\n2. Cancel Ticket\n3. Print Booked Tickets\n4. Print Available Tickets\n5. Exit");
            System.out.print("Enter your choice :");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    System.out.print("Gender (M/F): ");
                    String gender = sc.next();
                    System.out.print("Berth Preference (L/M/U): ");
                    String pref = sc.next();
                    manager.bookTicket(name, age, gender, pref);
                    break;

                case 2:
                    System.out.print("Enter Passenger ID to cancel: ");
                    int id = sc.nextInt();
                    manager.CancelTicket(id);
                    break;

                case 3:
                    manager.printBookedTickets();
                    break;

                case 4:
                    manager.printAvailableTickets();
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
