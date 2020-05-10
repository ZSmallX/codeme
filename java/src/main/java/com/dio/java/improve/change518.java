package com.dio.java.improve;

import org.junit.Assert;
import org.junit.Test;

public class change518 {
    @Test
    public void test() {
        int[] input1 = new int[]{1, 2, 5};
        Assert.assertEquals(4, change(5, input1));
    }

    public int change(int amount, int[] coins) {
        if (coins == null) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j - coins[i]] + dp[j];
            }
        }
        return dp[amount];
    }
}
