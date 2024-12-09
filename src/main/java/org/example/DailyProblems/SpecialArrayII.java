package org.example.DailyProblems;

import java.util.Arrays;

public class SpecialArrayII {
    class Solution {
        public boolean getTrue(int s,int e,int[] arr){
            String  ans="";
            while(s<=e){
                if(s==e){
                    ans+=(arr[e--]);
                }else{
                    ans+=(arr[s--]);

                }

            }
            System.out.print(ans);

            return !(ans.contains("00") || ans.contains("11"));
        }
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            int[] oAz= new int[nums.length];
            boolean ans[]= new boolean[queries.length];
            for(int i=0;i<nums.length;i++){
                if(nums[i]%2==0){
                    oAz[i]=1;
                }
            }
            System.out.println(Arrays.toString(oAz));
            int i=0;
            for(int a[]: queries){
                boolean t=getTrue(a[0],a[1],oAz);
                if(t){
                    ans[i++]=t;
                }else{
                    ans[i++]=t;
                }
            }
            return ans;
        }
    }
}
