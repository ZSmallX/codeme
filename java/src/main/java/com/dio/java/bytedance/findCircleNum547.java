package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import oj.scaffold.OjUtils;

public class findCircleNum547 {
    int n;
    int count;

    @Test
    public void test() {
        int[][] input = OjUtils.toIntMatrix("[[1,1,0],\n" +
                " [1,1,0],\n" +
                " [0,0,1]]");
        Assert.assertEquals(2, findCircleNum(input));
    }

    @Test
    public void test1() {
        int[][] input = OjUtils.toIntMatrix("[[1,1,0],\n" +
                " [1,1,1],\n" +
                " [0,1,1]]");
        Assert.assertEquals(1, findCircleNum(input));
    }

    @Test
    public void test2() {
        int[][] input = OjUtils.toIntMatrix("[[1]]");
        Assert.assertEquals(1, findCircleNum(input));
    }

    @Test
    public void test3() {
        int[][] input = OjUtils.toIntMatrix("[]");
        Assert.assertEquals(0, findCircleNum(input));
    }

    public int findCircleNum(int[][] M) {
        if (M == null) {
            return 0;
        }
        n = M.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        // System.out.println("visite: " + i);
        // String s = "visite: " + i;
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, j, visited);
            }
        }
    }

    public int findCircleNum1(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        if (M.length == 1) {
            return 1;
        }
        n = M.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    if (!visited[i] && !visited[j]) {
                        count++;
                        dfs1(M, i, visited);
                        dfs1(M, j, visited);
                    } else if (!visited[i]) {
                        dfs1(M, i, visited);
                    } else if (!visited[j]) {
                        dfs1(M, j, visited);
                    }
                }
            }
        }
        return count;
    }

    private void dfs1(int[][] M, int i, boolean[] visited) {
        System.out.println("visite: " + i);
        // String s = "visite: " + i;
        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1) {
                if (!visited[j]) {
                    dfs1(M, j, visited);
                }
            }
        }
    }
}
