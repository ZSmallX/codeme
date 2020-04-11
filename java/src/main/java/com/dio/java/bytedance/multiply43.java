package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

public class multiply43 {
    @Test
    public void test() {
        Assert.assertEquals("6", multiply("2", "3"));
        Assert.assertEquals("56088", multiply("123", "456"));
    }

    // 数学题 竖式乘法的原理
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        int size1 = num1.length();
        int size2 = num2.length();
        int[] result = new int[size1 + size2];
        for (int i = size2 - 1; i >= 0; i--) {
            int n2 = nums2[i] - '0';
            for (int j = size1 - 1; j >= 0; j--) {
                int n1 = nums1[j] - '0';
                int sum = n1 * n2 + result[i + j + 1];
                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0) {
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
