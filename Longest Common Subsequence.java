package DP.LCS;

import java.util.Arrays;

public class LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] it : dp)
            Arrays.fill(it, -1);
        int i = 0;
        int j = 0;
        return findLCS(text1, text2, i, j, dp, n, m);
    }

    public int findLCS(String text1, String text2, int i, int j, int[][] dp, int n, int m) {
        if (i == text1.length() || j == text2.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        //matching case
        if (text1.charAt(i) == text2.charAt(j))
            dp[i][j] = 1 + findLCS(text1, text2, i + 1, j + 1, dp, n, m);
        else {
            //not matching case
            dp[i][j] = Math.max(findLCS(text1, text2, i + 1, j, dp, n, m),
                    findLCS(text1, text2, i, j + 1, dp, n, m));
        }
        return dp[i][j];
    }


    public int longestCommonSubsequenceTabulation(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
