package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

public class trap42 {
    @Test
    public void test() {
        int[] input1 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Assert.assertEquals(6, trap(input1));
    }

    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int count = 0;
        int h = 1;
        while (left < right) {
            while (left < right && height[left] < h) {
                count += h - height[left] - 1;
                left++;
            }

            while (left < right && height[right] < h) {
                count += h - height[right] - 1;
                right--;
            }
            h++;
        }

        return count;
    }
}
