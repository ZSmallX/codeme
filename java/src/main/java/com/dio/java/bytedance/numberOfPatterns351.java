package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

public class numberOfPatterns351 {
    int count = 0;

    @Test
    public void test() {
        Assert.assertEquals(9, numberOfPatterns(1, 1));
    }

    @Test
    public void test1() {
        Assert.assertEquals(65, numberOfPatterns(1, 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(385, numberOfPatterns(1, 3));
    }

    // 回溯 关键在于合法性的条件判断
    public int numberOfPatterns(int m, int n) {
        boolean[] visited = new boolean[9];
        for (int pick = m; pick <= n; pick++) {
            for (int i = 0; i < 9; i++) {
                dfs(i, visited, pick);
            }
            // System.out.println("count: " + count);
        }
        return count;
    }

    private void dfs(int last, boolean[] visited, int pick) {
        if (--pick == 0) {
            count++;
            return;
        }

        visited[last] = true;
        for (int i = 0; i < 9; i++) {
            if (!visited[i] && validPick(last, i, visited)) {
                dfs(i, visited, pick);
            }
        }
        visited[last] = false;
    }

    private boolean validPick(int pre, int index, boolean[] visited) {
        if ((index + pre != 8) &&
                ((index + pre) % 2 == 1 || (index % 3 != pre % 3 && index / 3 != pre / 3))) {
            return true;
        }
        return visited[(index + pre) / 2];
    }
}
