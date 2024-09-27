package org.example;

import java.util.TreeMap;

class MyCalendarTwo {
    TreeMap<Integer, Integer> map;
    
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // Mark the start of the event as +1 and the end as -1
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int activeBookings = 0;
        // Sweep through the map to track overlapping intervals
        for (int event : map.values()) {
            activeBookings += event;
            if (activeBookings > 2) {
                // If there's a triple booking, rollback the changes and return false
                map.put(start, map.get(start) - 1);
                if (map.get(start) == 0) {
                    map.remove(start);
                }
                map.put(end, map.get(end) + 1);
                if (map.get(end) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }
        
        return true;
    }

    // Main method to test the booking system
    public static void main(String[] args) {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        
        // Test cases
        System.out.println(myCalendar.book(10, 20));  // Expected: true (no overlapping event)
        System.out.println(myCalendar.book(50, 60));  // Expected: true (no overlapping event)
        System.out.println(myCalendar.book(10, 40));  // Expected: true (double booking allowed)
        System.out.println(myCalendar.book(5, 15));   // Expected: false (triple booking not allowed)
        System.out.println(myCalendar.book(5, 10));   // Expected: true (no triple booking)
        System.out.println(myCalendar.book(25, 55));  // Expected: true (double booking allowed)
    }
}
