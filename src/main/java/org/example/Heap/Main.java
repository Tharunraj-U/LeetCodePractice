package org.example.Heap;

public class Main {
    public static void main(String[] args) throws Exception {
        String s="Tharun ";
        HuffmanCoder hf=new HuffmanCoder(s);
        String cs= hf.encoder(s);

        System.out.println(hf.decode(cs));
        System.out.println(cs);

    }
}
