package org.example.DailyProblems;

import java.util.Stack;

class SolutionDecodeString {
    static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0'); // Compute the full number (e.g., "23" instead of just "2" and "3")
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0; // Reset for next number
            } else if (c == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                while (repeatTimes-- > 0) {
                    decodedString.append(currentString);
                }
                currentString = decodedString; // Update the current working string
            } else {
                currentString.append(c);
            }
        }
        
        return currentString.toString();
    }
}