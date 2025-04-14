package org.example.Graph;

import java.util.*;

class AlienDictionary {
    public void dfs(List<List<Integer>> list, int curr, Stack<Integer> stack, BitSet vis){
     
      vis.set(curr);
      for(int nei:list.get(curr)){
          if(!vis.get(nei)){
              dfs(list,nei,stack,vis);
          }
      }
       stack.push(curr);
    }
    public boolean isCycle(List<List<Integer>> list,BitSet vis,int curr,boolean[] edge){
        vis.set(curr);
        edge[curr]=true;
        for(int nei:list.get(curr)){
            if(!vis.get(nei)){
                if(isCycle(list,vis,nei,edge))return true;
            }else if(edge[nei]){
                return true;
            }
        }
        edge[curr]=false;
        return false;
    }
    public String topoSort(List<int[]> arr,Set<Character> set){
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add(new ArrayList<>());
        }
        for(int a[]:arr){
            list.get(a[0]).add(a[1]);
        }
        BitSet vis=new BitSet();
        for(int i=0;i<26;i++){
            if(!vis.get(i) && set.contains((char)('a'+i))){
            if(isCycle(list,new BitSet(),i,new boolean[26])){
            return "";
            }
        }
        }
       
        Stack<Integer> stack=new Stack<>();
        vis=new BitSet();
        for(int i=0;i<26;i++){
            if(!vis.get(i) && set.contains((char)('a'+i))){
               dfs(list,i,stack,vis);
            }
        }
        String ans="";
        while(!stack.isEmpty()){
            ans+=((char)('a'+stack.pop()));
        }
        return ans;
        
    } 
    public String findOrder(String[] words) {
        List<int[]> list=new  ArrayList<>();
        Set<Character> set=new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                set.add(c);
            }
        }

        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];
            int ptr1=0,ptr2=0;
            boolean found=false;
            while(ptr1 < s1.length() && ptr2 < s2.length()){
                if(s1.charAt(ptr1) != s2.charAt(ptr2)){
                     list.add(new int[]{s1.charAt(ptr1)-'a',s2.charAt(ptr2)-'a'});
                     found =true;
                     break;
                }
                
                ptr1++;
                ptr2++;
            }
            if(!found && s1.length() > s2.length()){
                return "";
            }
        }
        
       String s1=topoSort(list,set);
      
        return s1;
      
    }
}