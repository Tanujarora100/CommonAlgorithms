package DP.LIS;

import java.util.Arrays;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return getAns(nums, nums.length, 0, -1, dp);
    }

    int getAns(int[] arr, int n, int ind, int prev_index, int[][] dp) {
        // base condition
        if (ind == n)
            return 0;

        if (dp[ind][prev_index + 1] != -1)
            return dp[ind][prev_index + 1];
        int notTake = getAns(arr, n, ind + 1, prev_index, dp);
        int take = 0;
        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + getAns(arr, n, ind + 1, ind, dp);
        }
        return dp[ind][prev_index + 1] = Math.max(notTake, take);
    }

    public int lengthOfLISOptimized(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int longest = 0;
        for (int c : dp) {
            longest = Math.max(longest, c);
        }

        return longest;
    }

}
