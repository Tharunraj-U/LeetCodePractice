package org.example.ZohoLevel_2;
import  java.util.*;
class BitonicGeneratorSort
 {
    public static ArrayList<Integer> bitonicGenerator(int arr[]) {
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if((i & 1) == 0){
              list1.add(arr[i]);  
            }else{
                list2.add(arr[i]);
            }
        }
        Collections.sort(list1,(a,b)-> a-b);
        Collections.sort(list2,(a,b)-> b-a);
        for(int val:list2){
            list1.add(val);
        }
        return  list1;
    }
}