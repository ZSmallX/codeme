package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class checkInclusion567 {
    @Test
    public void test() {
        Assert.assertTrue(checkInclusion("ab", "eidbaooo"));
        Assert.assertFalse(checkInclusion("ab", "eidboaoo"));
        Assert.assertTrue(checkInclusion("a", "eidboaoo"));
        Assert.assertFalse(checkInclusion("eidboaood", "eidboaoo"));
    }

    // 滑窗 窗口条件：恒为s1的length，子问题为判断是否为异位词
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }

        int n = s1.length();
        int N = s2.length();
        char[] cs1 = s1.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < cs1.length; i++) {
            map1.put(cs1[i], map1.getOrDefault(cs1[i], 0) + 1);
        }
        int left = 0;
        int right = 0;
        int count = 0;
        Map<Character, Integer> map2 = new HashMap<>();
        while (right < N) {
            char c = s2.charAt(right++);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
            count++;
            if (count > n) {
                int lCount = map2.get(s2.charAt(left));
                if (lCount == 1) {
                    map2.remove(s2.charAt(left));
                } else {
                    map2.put(s2.charAt(left), lCount - 1);
                }
                count--;
                left++;
            }

            if (map1.equals(map2)) {
                return true;
            }
        }
        return false;
    }

    // TODO: 2020/4/9 滑窗可优化
}
