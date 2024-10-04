package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionCanArrange {

            public static boolean canArrange(int k, int... arr) {
                int[] freq = new int[k];

                for (int num : arr) {
                    freq[((num % k) + k) % k]++;
                }

                if (freq[0] % 2 != 0) return false;

                for (int i = 1; i <= k / 2; i++) {
                    if (freq[i] != freq[k - i]) return false;
                }

                return true;
            }


    public static void main(String[] args) {
        canArrange(7,1,2,3,4,5,6);
    }
}
