package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import oj.scaffold.OjUtils;

public class maxEnvelopes354 {
    @Test
    public void test() {
        int[][] input = OjUtils.toIntMatrix("[[5,4],[6,4],[6,7],[2,3]]");
        Assert.assertEquals(3, maxEnvelopes(input));

    }

    // DP + 二分查找
    // 对w进行升序的同时，对h进行降序，将二维问题转换为一维的最长递增子序列问题。
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int[] h = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            h[i] = envelopes[i][1];
        }

        return lengthOfLIS(h);
    }

    public int lengthOfLIS(int[] h) {
        if (h.length == 0) {
            return 0;
        }
        int[] dp = new int[h.length + 1];
        dp[1] = h[0];
        int len = 1;
        for (int i = 1; i < h.length; i++) {
            if (h[i] > dp[len]) {
                dp[++len] = h[i];
            } else {
                int left = 1;
                int right = len;
                while (left <= right) {
                    int mid = (left + right) >>> 1;
                    if (h[i] > dp[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                dp[left] = h[i];
            }
        }

        return len;
    }
}
