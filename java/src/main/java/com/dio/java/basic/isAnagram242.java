package com.dio.java.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// TAG: String,sort,hash table
public class isAnagram242 {
    @Test
    public void test() {
        Assert.assertTrue(isAnagram("abc", "cba"));
        Assert.assertFalse(isAnagram("rat", "cat"));
        Assert.assertTrue(isAnagram("", ""));
        //        Assert.assertEquals(true, isAnagram(null, null));
        //        Assert.assertEquals(true, isAnagram("", null));
    }

    // 暴力的Hash表法 O(n) 需要处理的异常情况偏多
    public boolean isAnagram0(String s, String t) {
        if ((s == null) && (t == null)) {
            return true;
        }
        if ((s.isEmpty()) && (t.isEmpty())) {
            return true;
        }
        HashMap<Character, Integer> sConstruction = new HashMap<>();
        HashMap<Character, Integer> tConstruction = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sConstruction.containsKey(c)) {
                sConstruction.put(c, sConstruction.get(c) + 1);
            } else {
                sConstruction.put(c, 1);
            }
        }
        // 可以使用同个表
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (tConstruction.containsKey(c)) {
                tConstruction.put(c, tConstruction.get(c) + 1);
            } else {
                tConstruction.put(c, 1);
            }
        }
        return sConstruction.equals(tConstruction);
    }

    // 排序法
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }

    // 优化的Hash表法
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Integer, Integer> map = new HashMap<>();
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // 优化的Hash表法2
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Integer, Integer> map = new HashMap<>();
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            charCount[t.charAt(i) - 'a']--;
            if (charCount[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
