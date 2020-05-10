package com.dio.java.improve;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class coinChange322 {
    @Test
    public void test() {
        int[] input1 = new int[]{1, 2, 5};
        Assert.assertEquals(3, coinChange(input1, 11));
    }

    public int coinChange1(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }

        int[] mem = new int[amount + 1];

        return coinChange(coins, amount, mem);
    }

    public int coinChange(int[] coins, int remain, int[] mem) {
        if (remain < 0) {
            return -1;
        }

        if (remain == 0) {
            return 0;
        }

        if (mem[remain] != 0) {
            return mem[remain];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int count = coinChange(coins, remain - coins[i], mem);
            if (count >= 0 && count < min) {
                min = Math.min(count + 1, min);
            }
        }
        mem[remain] = (min == Integer.MAX_VALUE ? -1 : min);
        return mem[remain];
    }
}
