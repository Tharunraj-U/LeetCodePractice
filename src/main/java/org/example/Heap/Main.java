package org.example.Heap;

public class Main {
    public static void main(String[] args) throws Exception {
        String s="You stolen my soul yesterday";
        HuffmanCoder hf=new HuffmanCoder(s);
        String cs= hf.encoder(s);
        hf.decode(cs);
       // System.out.println(hf.decode(cs));
        System.out.println(cs);

    }
}
