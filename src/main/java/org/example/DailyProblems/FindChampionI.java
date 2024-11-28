package org.example.DailyProblems;

public class FindChampionI {
    public int findChampion(int[][] grid) {
        int i=0,max=0,ans=0;
        for(int a[]: grid){
            int c=0;
            for(int val:a){
                if(val==1){
                    c++;
                }
            }

            if(max < c){
                max=c;
                ans=i;
                System.out.println(i+" "+c);
            }
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
