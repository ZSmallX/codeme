package com.dio.java.basic;

import org.junit.Assert;
import org.junit.Test;

// TAG: String
public class isPalindrome125 {
    @Test
    public void test() {
        Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(isPalindrome("race a car"));
        Assert.assertFalse(isPalindrome("0P"));
        Assert.assertTrue(isPalindrome(",."));
    }

    // 去除无效字符，反转
    public boolean isPalindrome0(String s) {
        if (s == null || s.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetterOrDigit(chars[i]) /* Character.isLetter(c) || Character.isDigit(c) */) {
                sb.append(c);
            }
        }
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }

    // 双指针
    public boolean isPalindrome1(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (left != chars.length && !Character.isLetter(chars[left]) && !Character.isDigit(chars[left])) {
                left++;
            }
            while (right != -1 && !Character.isLetter(chars[right]) && !Character.isDigit(chars[right])) {
                right--;
            }
            if (left >= right) {
                return true;
            }
            if (chars[left] != chars[right]
                    && Character.toLowerCase(chars[left]) != chars[right]
                    && Character.toUpperCase(chars[left]) != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 双指针 优化
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }
            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
