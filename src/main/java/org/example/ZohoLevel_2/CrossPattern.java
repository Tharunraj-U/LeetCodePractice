package org.example.ZohoLevel_2;

class CrossPattern{
    static void crossPattern(String s){

      for(int i=0;i<s.length();i++){
          for(int j=0;j<s.length();j++){
              if(i==j ||  j == s.length()-1-i){
                  System.out.print(s.charAt(j));
              }else{
                  System.out.print(' ');
              }
          }
          System.out.println();
          
      }

    }

    public static void main(String[] args) {
        crossPattern("tharunRajU");
    }
}