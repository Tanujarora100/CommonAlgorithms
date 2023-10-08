package DP.stringdp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
Author-Tanuj Arora
 */
public class WordBreak {
    private int[] cache;

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> stringSet = new HashSet<>(wordDict);
        this.cache = new int[s.length()];
        Arrays.fill(this.cache, -1);
        return Solve(0, s, stringSet);
    }

    private boolean Solve(int index, String s, HashSet<String> stringSet) {
        if (index >= s.length()) {
            return true;
        }

        if (cache[index] != -1) {
            return cache[index] == 1;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String temp = s.substring(index, i);
            if (stringSet.contains(temp) && Solve(i, s, stringSet)) {
                cache[index] = 1;
                return true;
            }
        }

        cache[index] = 0;
        return false;
    }
}
