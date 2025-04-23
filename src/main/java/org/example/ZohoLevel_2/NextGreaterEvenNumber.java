package org.example.ZohoLevel_2;

class NextGreaterEvenNumber
 {
      public long nextPermutation(StringBuilder sb) {
       while(true){
        int index=-1;
         for(int i=sb.length()-1;i> 0 ;i--){
            if(sb.charAt(i)-'0' > sb.charAt(i-1)-'0'){
                index=i-1;
                break;
            }
         }
        
         if(index == -1){
             return -1;
         }
         int index1=0;
         
         for(int i=sb.length()-1;i> 0 ;i--){
            if(sb.charAt(index)-'0'<sb.charAt(i)-'0'){
                index1=i;
                break;
            }
         }

         swap(sb,index,index1);
         rev(sb,index+1,sb.length()-1);
         if((sb.charAt(sb.length()-1)-'0') % 2 ==0){
             return Long.parseLong(sb.toString());
         }

       }
        
      
    }
    public void swap(StringBuilder sb,int i,int j){
        char temp=sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,temp);
    }
    void rev(StringBuilder sb,int i,int j){
        while(i<j){
        char temp=sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,temp);
        j--;
        i++;
        }
    }
    public long getNextEven(String x) {
        return nextPermutation(new StringBuilder(x));
    }
}