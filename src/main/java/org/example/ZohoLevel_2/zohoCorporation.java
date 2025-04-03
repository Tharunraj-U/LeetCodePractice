package org.example.ZohoLevel_2;

public class zohoCorporation {
    public  static void  printMatrix(char[][] mat){
        for(char[] row:mat){
            for(char c: row) System.out.print(c+" ");
            System.out.println();
        }
    }
    public static boolean searchLeftToRight(char[][] mat,String str){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<=mat.length-str.length();j++){
                String subString=new String(mat[i],j,str.length());
                if(subString.equals(str)){
                    System.out.println(str+" "+"Start At ["+i+","+j+"]  "+"End At ["+i+","+(j+str.length()-1)+"]");
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean searchTopToBottom(char[][] mat,String str){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<=mat.length-str.length();j++){
                StringBuilder sb=new StringBuilder();
                for(int k=j;k<=j+str.length()-1;k++){
                    sb.append(mat[k][i]);
                }
                if(sb.toString().equals(str)){
                    System.out.println(str+" "+"Start At ["+j+","+i+"]  "+"End At ["+(j+sb.length()-1)+","+i+"]");
                    return true;
                }
            }
        }
        return false;
    }
    public  static  void main(String[] args) {
        String str = "WELCOMETOZOHOCORPORATION";
        int size = (int) Math.ceil(Math.sqrt(str.length()));
        char mat[][] = new char[size][size];
        int index = 0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(index < str.length()){
                    mat[i][j]= str.charAt(index++);
                }else{
                    mat[i][j]=' ';
                }
            }
        }
        printMatrix(mat);


        if(searchLeftToRight(mat,"ION")){
           searchTopToBottom(mat,"TOO");
        }
    }
}
