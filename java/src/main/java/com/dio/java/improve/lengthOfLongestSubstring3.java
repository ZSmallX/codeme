package com.dio.java.improve;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Tag: String, Slide window
public class lengthOfLongestSubstring3 {
    @Test
    public void test() {
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbbb"));
        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(0, lengthOfLongestSubstring(""));
        Assert.assertEquals(1, lengthOfLongestSubstring("b"));
        Assert.assertEquals(3, lengthOfLongestSubstring("dvdf"));
        Assert.assertEquals(2, lengthOfLongestSubstring("abba"));
    }

    // 优化的暴力法，O(n2)
    public int lengthOfLongestSubstring0(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    int currLength = set.size();
                    maxLength = currLength > maxLength ? currLength : maxLength;
                    set.clear();
                    break;
                } else {
                    set.add(c);
                }
            }
        }

        int currLength = set.size();
        maxLength = currLength > maxLength ? currLength : maxLength;
        return maxLength;
    }

    // 滑动窗口
    public int lengthOfLongestSubstring1(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (left < n && right < n) {
            char c = s.charAt(right);
            // 刷新最大值的时机，应该放在不包含时，以简化逻辑。
            if (!set.contains(c)) {
                set.add(c);
                right++;
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }

    // 优化的滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // 避免左界回滚
                left = Math.max(map.get(c) + 1, left);
            }
            maxLength = Math.max(maxLength, right - left + 1);
            map.put(c, right);
        }
        return maxLength;
    }
}
