package org.example.DailyProblems;

public class Count {
    public static void main(String[] args) {
        String  n="6645166";
        int c=0;
        for(int a:n.toCharArray()){
            if(a=='6')c++;
        }
        System.out.print(c);
    }
}
