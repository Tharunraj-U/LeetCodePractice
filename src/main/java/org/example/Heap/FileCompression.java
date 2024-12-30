package org.example.Heap;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FileCompression {
    private  class  Node implements Comparable<Node>{
        int cost;
        Character ch;
        Node left;
        Node right;

        public Node(Character key, Integer value) {
            this.cost=value;
            this.ch=key;
        }

        @Override
        public int compareTo(Node node) {
            return cost-node.cost;
        }
    }
    private  void compressFile(String file) {
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file))){
            String string="";
            StringBuilder stringBuilder=new StringBuilder();
            while ((string=bufferedReader.readLine()) != null){
                stringBuilder.append(string).append("\n");

            }

            Map<Character,Integer> map=new HashMap<>();
            for(char a:stringBuilder.toString().toCharArray()){
                map.put(a,map.getOrDefault(a,0)+1);
            }
            System.out.println(map);
            PriorityQueue<Node> minHeap=new PriorityQueue<>();
            for(Map.Entry<Character,Integer> obj:map.entrySet()){
                minHeap.add(new Node(obj.getKey(),obj.getValue()));
            }
            while (minHeap.size() != 1){
                Node left=minHeap.remove();
                Node right=minHeap.remove();
                Node node=new Node('\0',left.cost+right.cost);
                minHeap.add(node);
            }
            Node node=minHeap.remove();
            System.out.println(node.cost);
            HashMap<Character,String> encoder=new HashMap<>();
            getCodes(node,"",encoder);
            System.out.println(encoder+"hello");
            String newFile="C://Users//DELL//Desktop//Tharun.bin";

            String s1=getEncodedString(stringBuilder.toString(),encoder);
            System.out.println(s1);
            try(ObjectOutputStream newfile1=new ObjectOutputStream(new FileOutputStream(newFile))){
                newfile1.writeObject(encoder);
                newfile1.writeObject(s1);
            }
            catch (Exception e){
                System.out.println(e);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    private String getEncodedString(String string, HashMap<Character, String> encoder) {
        String ans="";
        System.out.println(encoder);
        System.out.println(string);
        for(char a:string.toCharArray()){
            System.out.println(encoder.get(a));
            ans+=encoder.get(a);
        }
        return ans;
    }

    private void getCodes(Node node, String s, HashMap<Character, String> encoder) {
        if(node == null)return;
        if(node.left == null && node.right == null){
            encoder.put(node.ch,s);
            System.out.println(node.ch+" "+s);
            return;
        }
        getCodes(node.left,s+"0", encoder);
        getCodes(node.right,s+"1", encoder);
    }

    public static void main(String[] args) {
       new FileCompression().compressFile("C://Users//DELL//Desktop//Tharun.txt");
    }


}
