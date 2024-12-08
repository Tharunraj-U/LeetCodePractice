package org.example.DailyProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a, b)-> a[0]-b[0]);
        List<List<Integer>> list=new ArrayList<>();
        int start=arr[0][0];
        int end=arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(arr[i][0] <= end){
                end=Math.max(arr[i][1],end);
            }else{
                List<Integer> subList=new ArrayList<>();
                subList.add(start);
                subList.add(end);
                list.add(subList);
                start=arr[i][0];
                end=arr[i][1];
            }
        }
        List<Integer> subList=new ArrayList<>();
        subList.add(start);
        subList.add(end);
        list.add(subList);
        int ans[][]=new int[list.size()][2];
        int i=0;
        for(List<Integer>  a:list){

            ans[i][0]=a.get(0);
            ans[i++][1]=a.get(1);
        }
        return ans;
    }
}
