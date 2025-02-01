package org.example.Heap;


import java.util.*;

public class HuffmanCoder {
    HashMap<Character,String>  encoder=new HashMap<>();
    HashMap<String,Character> decode=new HashMap<>();

    public String encoder(String s) {
        String ans="";
        for(char c:s.toCharArray()){
            ans+=encoder.get(c);
        }
        return ans;
    }

    private  class  Node implements  Comparable<Node> {

      Character data;
      int cost;
      Node left;
      Node right;

      public  Node(Character data,int cost){
          this.cost=cost;
          this.data=data;
          left=null;
          right=null;

      }

        @Override
        public int compareTo(Node node) {
            return this.data -node.data;
        }
    }
    public  HuffmanCoder(String feeder)throws  Exception{
        HashMap<Character,Integer> fmap=new HashMap<>();
        for(char a:feeder.toCharArray()){
            fmap.put(a,fmap.getOrDefault(a,0)+1) ;
        }
        PriorityQueue<Node> minHeap=new PriorityQueue<>();
        for(Map.Entry<Character,Integer>  obj: fmap.entrySet()){
            Node node=new Node(obj.getKey(),obj.getValue());
            minHeap.add(node);
        }
        while (minHeap.size() != 1){
            Node first=minHeap.remove();
            Node second=minHeap.remove();
            Node newNode=new Node('\0',first.cost+second.cost);
            newNode.left=first;
            newNode.right=second ;
            minHeap.add(newNode);
        }
        Node fullTree=minHeap.remove();

        initEncoderDecoder(fullTree,"");
    }

    private void initEncoderDecoder(Node fullTree, String s) {
        if(fullTree ==null){
            return;
        }
        if(fullTree.left == null && fullTree.right == null){
            encoder.put(fullTree.data,s);
            decode.put(s,fullTree.data);
        }
        initEncoderDecoder(fullTree.left,s+"0");
        initEncoderDecoder(fullTree.right,s+"1");
    }

    public String decode(String s){
        String ans="",key="";
        for(char c:s.toCharArray()){
            key+=c;
            if(decode.containsKey(key)){
                ans+=decode.get(key);
                key="";
            }
        }
        System.out.println(decode);
        return ans;
    }

}
