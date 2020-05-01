package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import oj.scaffold.OjUtils;

public class minimumTotal120 {
    @Test
    public void test1() {
        String outputText = "[[2],[3,4],[6,5,7],[4,1,8,3]]";
        Assert.assertEquals(11,
                minimumTotal(OjUtils.toListList(outputText, OjUtils.INTEGER_CREATOR)));
    }

    @Test
    public void test2() {
        String outputText = "[[2]]";
        Assert.assertEquals(2,
                minimumTotal(OjUtils.toListList(outputText, OjUtils.INTEGER_CREATOR)));
    }

    // 自顶向下 动态规划 O(n) O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }

        int[] dp = new int[triangle.size() + 1];
        for (int j = triangle.size() - 1; j >= 0; j--) {
            List<Integer> line = triangle.get(j);
            for (int i = 0; i < line.size(); i++) {
                int val = line.get(i);
                dp[i] = val + Math.min(dp[i], dp[i + 1]);
                // System.out.println("i "+ i);
                // System.out.println("v "+ dp[i]);
            }
        }

        return dp[0];
    }
}
