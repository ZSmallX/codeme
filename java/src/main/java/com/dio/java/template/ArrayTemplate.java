package com.dio.java.template;

import org.junit.Assert;
import org.junit.Test;

public class ArrayTemplate {
    @Test
    public void test() {
        int[] input1 = new int[]{-1, 0, 1, 2, -1, -4};
        Assert.assertEquals(0, threeSum(input1));
    }

    public int threeSum(int[] nums) {
        return 0;
    }
}
