package org.example.DailyProblems;

class SolutionRemove {
    private static final int BASE = 101; // Prime base for hashing

    public double computeHash(String s) {
        double hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i) * Math.pow(BASE, i);
        }
        return hash;
    }

    public double updateHash(double oldHash, char oldChar, char newChar, int partLen) {
        return (oldHash - oldChar * Math.pow(BASE, partLen - 1)) / BASE + newChar * Math.pow(BASE, partLen - 1);
    }

    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        double partHash = computeHash(part);
        int partLen = part.length();

        while (true) {
            boolean found = false;
            if (sb.length() < partLen) break;

            double currentHash = computeHash(sb.substring(0, partLen));

            for (int i = 0; i <= sb.length() - partLen; i++) {
                if (i > 0) {
                    currentHash = updateHash(currentHash, sb.charAt(i - 1), sb.charAt(i + partLen - 1), partLen);
                }
                if (currentHash == partHash && sb.substring(i, i + partLen).equals(part)) {
                    sb.delete(i, i + partLen);
                    found = true;
                    break; // Restart search after modification
                }
            }
            if (!found) break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SolutionRemove solution = new SolutionRemove();
        System.out.println(solution.removeOccurrences("abacabac", "abc")); // Expected: "bac"
        System.out.println(solution.removeOccurrences("abacabc", "abc"));  // Expected: "ab"
        System.out.println(solution.removeOccurrences("abacabac", "abc")); // Expected: "bac"
        System.out.println(solution.removeOccurrences("abacabac", "abc")); // Expected: "bac"
    }
}
