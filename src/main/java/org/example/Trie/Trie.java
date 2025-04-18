package org.example.Trie;

class Trie {
    class Node{
          Node list[]=new Node[26];
          boolean isEnded=false;
           public void put(char c,Node node){
               list[c-'a']=node;
            }
           public  boolean isEnded(){
               return isEnded;
           }
            public  void makeItEnded(){
                   isEnded=true;
           }
           public boolean contains(char c){
               return list[c-'a'] != null;
           }
           public Node get(char c){
               return list[c-'a'];
           }
    }
    Node root=null;
    public Trie() {
        root=new Node();
    }
    public void insert(String word) {
        Node newNode=root;
        for(char c:word.toCharArray()){
            if(!newNode.contains(c)){
                newNode.put(c,new Node());
            }
            newNode=newNode.get(c);
            
        }
        newNode.makeItEnded();
    }


    public boolean search(String word) {
         Node newNode=root;
        for(char c:word.toCharArray()){
            if(!newNode.contains(c)){
                 return false;
            }else{
                newNode=newNode.get(c);
            }
        }
        return newNode.isEnded();
    }

   
    public boolean isPrefix(String word) {
         Node newNode=root;
        for(char c:word.toCharArray()){
            if(!newNode.contains(c)){
                 return false;
            }else{
                newNode=newNode.get(c);
            }
        }
        return true;
    }
}