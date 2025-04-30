package org.example.ZohoLevel_2;

class LookAndSayPattern
 {
    static String lookAndSay(int n) {
      StringBuilder s=new StringBuilder("1");
      for(int i=1;i<n;i++){
          StringBuilder sb=new StringBuilder();
          int c=1;
          for(int j=s.length()-1;j > 0 ;j--){
              if( i-1 >= 0 && s.charAt(j) != s.charAt(j-1)){
                  sb.insert(0,c+""+s.charAt(j));
                  c=1;
              }else c++;
         }
         sb.insert(0,c+""+s.charAt(0));
         s=sb;

      };
      return s.toString();
    }
}
