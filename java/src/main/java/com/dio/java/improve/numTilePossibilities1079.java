package com.dio.java.improve;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class numTilePossibilities1079 {
    Set<String> result = new HashSet<>();
    int count = 0;

    @Test
    public void test() {
        Assert.assertEquals(8, numTilePossibilities("AAB"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(188, numTilePossibilities("AAABBC"));
    }

    @Test
    public void test6() {
        Assert.assertEquals(6, numTilePossibilities("AAAAAA"));
    }

    @Test
    public void test5() {
        Assert.assertEquals(188, numTilePossibilities("ABABAC"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, numTilePossibilities(""));
    }

    @Test
    public void test4() {
        Assert.assertEquals(1, numTilePossibilities("A"));
    }

    // 全排列 非排序 helper1暴力
    // 优化 helper2 去重 剪枝
    public int numTilePossibilities1(String tiles) {
        if (tiles == null || tiles.length() == 0) return 0;
        char[] chars = tiles.toCharArray();
        boolean[] visited = new boolean[chars.length];
        StringBuilder sb = new StringBuilder("");
        helper1(chars, sb, visited);
        return result.size();
    }

    // 全排列 + 排序 最优解
    public int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.length() == 0) return 0;
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        helper(chars, visited, 0);
        return count;
    }

    // 排序
    private void helper(char[] chars, boolean[] visited, int index) {
        if (index == chars.length) return;
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                // 对于已排序的序列，如果下一个交换访问的节点和上一个访问节点一样，则跳过
                if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                    continue;
                }
                count++;
                visited[i] = true;
                helper(chars, visited, index + 1);
                visited[i] = false;
            }
        }
    }

    // 剪枝 "AAAAAA"
    private void helper2(char[] chars, StringBuilder sb, boolean[] visited) {
        if (sb.length() == chars.length) return;
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i] && !isShowBefore(chars[i], sb)) {
                visited[i] = true;
                sb.append(chars[i]);
//                System.out.println("sb: " + sb.toString());
                result.add(sb.toString());
                helper2(chars, sb, visited);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    private boolean isShowBefore(char c, StringBuilder sb) {
        try {
            sb.append(c);
            return result.contains(sb.toString());
        } finally {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void helper1(char[] chars, StringBuilder sb, boolean[] visited) {
        if (sb.length() == chars.length) return;
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(chars[i]);
                System.out.println("sb: " + sb.toString());
                result.add(sb.toString());
                helper1(chars, sb, visited);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
