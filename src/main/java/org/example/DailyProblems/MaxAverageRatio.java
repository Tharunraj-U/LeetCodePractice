package org.example.DailyProblems;

import java.util.Map;
import java.util.*;

class MaxAverageRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
Queue<Map.Entry<Double,Integer>> heap=new PriorityQueue<>((a, b)-> b.getKey().compareTo(a.getKey()));    int j=0;
        for(int a[]:classes){
                double oldAvg=(double)a[0]/a[1];
                double newAvg=(double)(a[0]+1)/(a[1]+1);
                heap.add((new AbstractMap.SimpleEntry<>(newAvg-oldAvg,j)));
                j++;
            }
        for(int i=1;i<=extraStudents;i++){
           int index=heap.poll().getValue();
            classes[index][0]+=1;
            classes[index][1]+=1;
            double oldAvg=(double) classes[index][0]/ classes[index][1];
            double newAvg=(double)( classes[index][0]+1)/(classes[index][1]+1);
            heap.add((new AbstractMap.SimpleEntry<>(newAvg-oldAvg,index)));
        }
        double avg=0;
        for(int a[]: classes){
           
            avg+=((double)a[0]/a[1]);
            
        }
        return avg/classes.length;
    }
}