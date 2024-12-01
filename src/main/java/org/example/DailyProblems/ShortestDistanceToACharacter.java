package org.example.DailyProblems;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c){
                list.add(i);
            }
        }
        int ans[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            if(c1== c){
                ans[i]=0;
            }else{
                int nearIndex=bin(list,i);
                System.out.print(nearIndex+" "+i);
                ans[i]=Math.abs(i-nearIndex);
            }

        }
        return ans;
    }
    public int bin(List<Integer> list, int val){
        int l=0;
        int r=list.size()-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(list.get(mid) == val){
                return list.get(mid);
            }
            if(list.get(mid) < val){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        int nearest = list.get(l);
        if (l > 0) { // Check if there's a closer left neighbor
            nearest = Math.abs(list.get(l - 1) - val) < Math.abs(list.get(l) - val) ? list.get(l - 1) : list.get(l);
        }
        return nearest;
    }
}
