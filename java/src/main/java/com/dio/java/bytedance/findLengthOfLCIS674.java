package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class findLengthOfLCIS674 {
    @Test
    public void test() {
        int[] input1 = new int[]{1, 3, 5, 4, 7};
        Assert.assertEquals(3, findLengthOfLCIS(input1));
    }

    @Test
    public void test1() {
        int[] input1 = new int[]{2, 2, 2, 2, 2};
        Assert.assertEquals(1, findLengthOfLCIS(input1));
    }

    public int findLengthOfLCIS1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (!stack.isEmpty()) {
                if (stack.peek() >= value) {
                    max = Math.max(max, stack.size());
                    stack.clear();
                }
            }
            stack.push(value);
        }
        return Math.max(max, stack.size());
    }

    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                ans = Math.max(ans, i - anchor);
                anchor = i;
            }
        }
        return Math.max(ans, nums.length - anchor);
    }
}
