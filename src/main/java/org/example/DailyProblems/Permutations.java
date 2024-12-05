package org.example.DailyProblems;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static  List<List<Integer>> get(int[] arr){
        List<List<Integer>> list=new ArrayList<>();
        helper(list,new ArrayList<>(),arr);
        return list;
    }
    public  static  void helper(List<List<Integer>> list,List<Integer> subList,int n[]){
        if(subList.size()==n.length){
            list.add( new ArrayList<>(subList));
            return;
        }
        for(int i=0;i<n.length;i++){
               if(!subList.contains(n[i])){
                   subList.add(n[i]);
                   helper(list,subList,n);
                   subList.remove(subList.size()-1);
               }
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        List<List<Integer>> list=get(arr);
    }
}
