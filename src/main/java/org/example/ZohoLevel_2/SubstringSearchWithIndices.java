package org.example.ZohoLevel_2;

public class SubstringSearchWithIndices {
    public static void main(String[] args) {
        // The given string
        String str = "WELCOMETOZOHOCORPORATION";
        
        // Determine the dimensions of the 2D array
        int rows = (int)Math.ceil(Math.sqrt(str.length())), cols = rows;  // A 5x5 grid for this example
        char[][] matrix = new char[rows][cols];

        // Fill the 2D array with characters from the string
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < str.length()) {
                    matrix[i][j] = str.charAt(index++);
                } else {
                    matrix[i][j] = ' ';  // Fill empty spaces if needed
                }
            }
        }

        // Print the matrix for visualization
        System.out.println("Matrix Representation:");
        printMatrix(matrix);

        // Search for the substring "too" from left to right
        searchLeftToRight(matrix, "TOO");

        // Search for the substring "too" from top to bottom
        searchTopToBottom(matrix, "TOO");
    }

    // Function to print the matrix
    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    // Search for the substring left to right in each row
    public static void searchLeftToRight(char[][] matrix, String substring) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int subLen = substring.length();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - subLen; j++) {
                String current = new String(matrix[i], j, subLen);
                if (current.equals(substring)) {
                    System.out.println("Found '" + substring + "' from left to right.");
                    System.out.println("Start index: <" + i + "," + j + "> End index: <" + i + "," + (j + subLen - 1) + ">");
                }
            }
        }
    }

    // Search for the substring top to bottom in each column
    public static void searchTopToBottom(char[][] matrix, String substring) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int subLen = substring.length();

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i <= rows - subLen; i++) {
                StringBuilder column = new StringBuilder();
                for (int k = 0; k < subLen; k++) {
                    column.append(matrix[i + k][j]);
                }
                if (column.toString().equals(substring)) {
                    System.out.println("Found '" + substring + "' from top to bottom.");
                    System.out.println("Start index: <" + i + "," + j + "> End index: <" + (i + subLen - 1) + "," + j + ">");
                }
            }
        }
    }
}
