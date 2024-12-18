class FinalPrices {
    public int[] finalPrices(int[] prices) {
        int nge[]=new int[prices.length];
        Stack<Integer> stack=new Stack();
        int n=prices.length,i=n-1;
        nge[n-1]=prices[n-1];
         stack.push(i);
        for(i=n-2;i > -1 ; i--){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nge[i]=prices[i];
            }else{
                nge[i]=prices[i]-prices[stack.peek()];
            }
             stack.push(i);
        }
        return nge;
    }
}