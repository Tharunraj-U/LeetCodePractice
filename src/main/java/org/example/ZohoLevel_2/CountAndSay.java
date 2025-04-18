package org.example.ZohoLevel_2;

class CountAndSay {

    public static void main(String[] args) {
        int n=4;
        String s="1";
        for(int i=1;i<n;i++){
            String s1="";
            int c=1;
            for(int j=0;j<s.length();j++){
                if(j+1<s.length() && s.charAt(j)== s.charAt(j+1)){
                    c++;
                }else{
                    s1=(s1+c)+s.charAt(j);
                    c=1;
                }
            }
            s=s1;
        }
        System.out.println(s);
    }
}