package org.example.Heap;

import java.io.*;
import java.util.*;

class HuffmanNode {
    char ch;
    int freq;
    HuffmanNode left, right;
}

class HuffmanCompression {
    // Compare Huffman nodes based on their frequency
    static class NodeComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode x, HuffmanNode y) {
            return x.freq - y.freq;
        }
    }

    // Generate the Huffman codes
    public static void generateCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
        if (root == null)
            return;

        // Leaf node
        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.ch, code);
        }

        generateCodes(root.left, code + "0", huffmanCodes);
        generateCodes(root.right, code + "1", huffmanCodes);
    }

    // Compress a file using Huffman Encoding
    public static void compressFile(String inputFile, String outputFile) throws IOException {
        // Read the input file
        StringBuilder inputText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inputText.append(line).append("\n");
            }
        }

        // Calculate frequency of characters
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputText.toString().toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Build the Huffman Tree
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new NodeComparator());
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            HuffmanNode node = new HuffmanNode();
            node.ch = entry.getKey();
            node.freq = entry.getValue();
            pq.add(node);
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode newNode = new HuffmanNode();
            newNode.freq = left.freq + right.freq;
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }

        HuffmanNode root = pq.poll();

        // Generate Huffman Codes
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        // Encode the input text
        StringBuilder encodedText = new StringBuilder();
        for (char c : inputText.toString().toCharArray()) {
            encodedText.append(huffmanCodes.get(c));
        }

        // Write encoded data and Huffman tree to output file
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            outputStream.writeObject(huffmanCodes); // Save Huffman codes
            outputStream.writeObject(encodedText.toString()); // Save encoded text
        }
    }

    public static void main(String[] args) {
        try {
            String inputFile = "C://Users//DELL//Desktop//Tharun.txt";
            String outputFile = "C://Users//DELL//Desktop//compressed.bin";

            compressFile(inputFile, outputFile);
            System.out.println("File compressed successfully!");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
