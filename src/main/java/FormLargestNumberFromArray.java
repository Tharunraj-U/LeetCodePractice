import java.util.Arrays;

class FormLargestNumberFromArray {
    String findLargest(int[] arr) {
         String arr1[]=new String[arr.length];
         int i=0;
         
         for(int a:arr)arr1[i++]=String.valueOf(a);
         // bubble sort 
         // eg [3,39]
         //  s1=339  s2=393
          // s=swap(i,j);
         Arrays.sort(arr1,(a, b)-> (b+a).compareTo(a+b));
         if(arr1[0].equals("0"))return "0";
       
          StringBuilder  ans=new StringBuilder();
           for(String a:arr1){
               ans.append(a);
           }
        return ans.toString();
    }
}