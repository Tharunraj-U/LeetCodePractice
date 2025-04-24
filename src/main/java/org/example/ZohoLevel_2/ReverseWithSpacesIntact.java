package org.example.ZohoLevel_2;

class ReverseWithSpacesIntact
{
    String reverseWithSpacesIntact(String s)
    {
        Set<Integer> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c == ' '){
                set.add(i);
            }else{
                sb.append(c+"");
            }
        }
        sb.reverse();
        StringBuilder ans=new StringBuilder();
        int i=0,j=0;
        while(i < sb.length()){
            if(set.contains(j++)){
                ans.append(" ");
            }else{
                ans.append(sb.charAt(i++)+"");
            }
        }
        return ans.toString();
    }
    
 
}