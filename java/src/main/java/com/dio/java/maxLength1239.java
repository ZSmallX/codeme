package com.dio.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// start at 2020/3/8 16:55
public class maxLength1239 {
    @Test
    public void test() {
        Assert.assertEquals(4, maxLength(Arrays.asList(new String[]{"un", "iq", "ue"})));
    }

    @Test
    public void test2() {
        Assert.assertEquals(6, maxLength(Arrays.asList(new String[]{"cha", "r", "act", "ers"})));
    }

    @Test
    public void test3() {
        Assert.assertEquals(26, maxLength(Arrays.asList(new String[]{"abcdefghijklmnopqrstuvwxyz"})));
    }

    int maxLength = 0;
    int visited = 0;

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) return 0;

        helper(arr, 0);
        return maxLength;
    }

    private void helper(List<String> arr, int index) {
        for (int i = index; i < arr.size(); i++) {
            if (!isLetterDuplicated(arr.get(i))) {
                addVisited(arr.get(i));
                helper(arr, i + 1);
                removeVisited(arr.get(i));
            }
        }
    }

    private void removeVisited(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            visited &= ~(1 << cs[i] - 'a');
        }
    }

    private void addVisited(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            visited |= 1 << cs[i] - 'a';
        }
        calMaxLength();
    }

    private void calMaxLength() {
        maxLength = Math.max(maxLength, Integer.bitCount(visited));
    }

    private boolean isLetterDuplicated(String s) {
        char[] cs = s.toCharArray();
        boolean[] originVisiteds = new boolean[26];
        int sVisited = 0;
        for (int i = 0; i < cs.length; i++) {
            if (((visited & 1 << cs[i] - 'a') != 0)
                    || ((sVisited & 1 << cs[i] - 'a') != 0)) {
                return true;
            }
            sVisited |= 1 << cs[i] - 'a';
        }
        return false;
    }
}
