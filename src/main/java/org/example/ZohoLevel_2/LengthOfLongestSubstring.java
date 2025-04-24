package org.example.ZohoLevel_2;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String str) {
        int max=0;
        int left=0;
        int map[]=new int[1000];
        for(int right=0;right < str.length();right++){
         while(map[str.charAt(right)] ==1){
            map[str.charAt(left)]--;
            left++;
          }
          max=Math.max(max,right-left+1);
          map[str.charAt(right)]++;
        }
        return max;
    }
}