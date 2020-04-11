package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

public class reverseWords151 {
    @Test
    public void test() {
        Assert.assertEquals("sky blue a", reverseWords("a blue sky"));
        Assert.assertEquals("a", reverseWords(" a "));
        Assert.assertEquals("! case test good a", reverseWords("a good  test   case    !     "));
        Assert.assertEquals("", reverseWords("   "));
    }

    // 字符串处理 边界条件
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() > 0) {
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
