package com.dio.java.basic;

import org.junit.Assert;
import org.junit.Test;

public class reverse7 {
    @Test
    public void test() {
        Assert.assertEquals(-123, reverse(-321));
        Assert.assertEquals(21, reverse(120));
        Assert.assertEquals(0, reverse(0));
        Assert.assertEquals(0, reverse(Integer.MAX_VALUE));
        Assert.assertEquals(0, reverse(Integer.MIN_VALUE));
        Assert.assertEquals(2147483641, reverse(1463847412));
    }

    // 基于字符串解法1
    public int reverse0(int x) {
        try {
            String s = String.valueOf(x);
            if (x < 0) {
                StringBuilder sb = new StringBuilder(s.substring(1));
                return Integer.valueOf(s.substring(0, 1) + sb.reverse().toString());
            } else {
                StringBuilder sb = new StringBuilder(s);
                return Integer.valueOf(sb.reverse().toString());
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // 基于字符串解法2
    public int reverse1(int x) {
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(x));
            sb = sb.reverse();
            if (sb.charAt(sb.length() - 1) == '-') {
                sb.deleteCharAt(sb.length() - 1);
                sb.insert(0, '-');
            }

            return Integer.valueOf(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // 每次pop/push一个数字
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            // pop/10可能会截断，使用取余代替
            // 应该考虑为通用解法，同样适用于short/long等
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10 /* 对于int32而言，此条件恒为false */)
                    || result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10 /* 对于int32而言，此条件恒为false */)) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }
}
