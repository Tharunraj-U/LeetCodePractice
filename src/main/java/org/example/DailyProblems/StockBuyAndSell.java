package org.example.DailyProblems;

public class StockBuyAndSell {
    public int maximumProfit(int ...p) {
        int P=0,M=Integer.MAX_VALUE;
        for(int a:p){
            M=Math.min(a,M);
            P=Math.max(P,a-M);
        }
        return P;
    }
    public static void main(String[] args) {
        System.out.println(new StockBuyAndSell().maximumProfit(765432,5754,4,554637457,643,7676,76,767));
    }
}
