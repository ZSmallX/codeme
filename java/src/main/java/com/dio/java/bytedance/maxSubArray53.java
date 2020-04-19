package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

public class maxSubArray53 {
    @Test
    public void test() {
        int[] input1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Assert.assertEquals(6, maxSubArray(input1));
    }

    // 贪心 动态规划
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int curr = max;
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(curr + nums[i], nums[i]);
            max = Math.max(max, curr);
        }
        return max;
    }
}
