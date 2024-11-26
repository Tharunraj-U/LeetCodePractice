package org.example;

public class FIndChamapII {
        public int findChampion(int n, int[][] edges) {
            int[] indege=new int[n];
            for(int []a:edges){
                indege[a[1]]++;
            }
            int ans=0,n0=0;
            for(int i=0;i<indege.length;i++){
                if(indege[i]==0){
                    n0++;
                    ans=i;
                }
            }
            return n0==1 ? ans : -1;
        }

}
