package org.example.DailyProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class GeeksforGeeks {
        static ArrayList<Integer> subarraySum(int[] arr, int target) {
            // Arrays.sort(arr);
            int sum=0,i=0,j=0;
            while(i<arr.length){

                if(sum < target){
                    sum+=arr[i++];
                }else if(sum > target){
                    sum-=arr[j++];
                } else return new ArrayList<>(Arrays.asList(j+1,i));
                if(sum == target) return new ArrayList<>(Arrays.asList(j+1,i));
            }

            if(sum == target) return new ArrayList<>(Arrays.asList(j+1,i));
            while( j<arr.length && sum >=target){
                sum-=arr[j++];
                if(sum == target) return new ArrayList<>(Arrays.asList(j+1,i));

            }
            return new ArrayList<>(Arrays.asList(-1));
        }
    }

