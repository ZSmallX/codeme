package com.dio.java.improve;

import org.junit.Assert;
import org.junit.Test;

public class lengthOfLIS673 {
    @Test
    public void test() {
        int[] input1 = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        Assert.assertEquals(4, lengthOfLIS(input1));
    }

    // DP O(n2)
    public int lengthOfLIS1(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            maxAns = Math.max(maxAns, dp[i]);
        }

        // int maxAns = 0;
        // for (int i = 0; i < dp.length; i++) {
        //     maxAns = Math.max(max, dp[i]);
        // }
        return maxAns;
    }

    // DP + 贪心
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                int left = 1;
                int right = len;
                while (left <= right) {
                    int mid = (left + right) >>> 1;
                    if (dp[mid] < nums[i]) {
                        left = mid + 1;
                    } else { // 相等的情况，应该取mid - 1
                        right = mid - 1;
                    }
                }
                // 标准的二分法实现，返回的下标从1开始，且为第一个比target大的数，故返回值已经为i+1
                dp[left] = nums[i];
            }
        }

        return len;
    }
}
