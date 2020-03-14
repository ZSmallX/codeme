package com.dio.java.basic;

import org.junit.Assert;
import org.junit.Test;

public class reverseString344 {
    @Test
    public void test3() {
        char[] s = "hello".toCharArray();
        char[] s2 = "olleh".toCharArray();
        reverseString(s);
        Assert.assertArrayEquals(s2, s);
    }


    // 时空复杂度 O(n/2) O(1)
    public void reverseString0(char[] s) {
        if (s == null || s.length == 0) return;
        int start = 0;
        int end = s.length - 1;
        char temp;
        while (start < end) {
            temp = s[end];
            s[end--] = s[start];
            s[start++] = temp;
//            start++;
//            end--;
        }
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        helper(s, 0, s.length - 1);
    }

    private void helper(char[] s, int start, int end) {
        if (start >= end) return;
        char temp = s[start];
        s[start++] = s[end];
        s[end--] = temp;
        helper(s, start, end);
    }
}
