package com.dio.java.improve;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Tag: String, Slide window
public class lengthOfLongestSubstringTwoDistinct159 {
    @Test
    public void test() {
        Assert.assertEquals(3, lengthOfLongestSubstringTwoDistinct("eceba"));
        Assert.assertEquals(5, lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        Assert.assertEquals(7, lengthOfLongestSubstringTwoDistinct("ababacccccc"));
        Assert.assertEquals(10, lengthOfLongestSubstringTwoDistinct("abccbbcccaaacaca"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        while (right < n) {
            map.put(s.charAt(right), right++);

            if (map.size() == 3) {
                int last = Collections.min(map.values());
                map.remove(s.charAt(last));
                left = last + 1;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
