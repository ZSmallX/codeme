package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import dio.oj.scaffolding.OjUtils;

public class maxAreaOfIsland695 {
    @Test
    public void test() {
        int[][] input = OjUtils.toIntMatrix("[[0,0,1,0,0,0,0,1,0,0,0,0,0],\n" +
                " [0,0,0,0,0,0,0,1,1,1,0,0,0],\n" +
                " [0,1,1,0,1,0,0,0,0,0,0,0,0],\n" +
                " [0,1,0,0,1,1,0,0,1,0,1,0,0],\n" +
                " [0,1,0,0,1,1,0,0,1,1,1,0,0],\n" +
                " [0,0,0,0,0,0,0,0,0,0,1,0,0],\n" +
                " [0,0,0,0,0,0,0,1,1,1,0,0,0],\n" +
                " [0,0,0,0,0,0,0,1,1,0,0,0,0]]\n");
        Assert.assertEquals(6, maxAreaOfIsland(input));
    }

    @Test
    public void test1() {
        int[][] input = OjUtils.toIntMatrix("[[0,0,0,0,0,0,0,0,0,0,0,0,0]]");
        Assert.assertEquals(0, maxAreaOfIsland(input));
    }

    @Test
    public void test2() {
        int[][] input = OjUtils.toIntMatrix("[[1]]");
        Assert.assertEquals(1, maxAreaOfIsland(input));
    }

    int m;
    int n;

    // dfs（递归） 考虑边界情况， 其他解法： BFS（队列） 、DFS（栈）
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxCount = 0;
        boolean[][] visitedLand = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int flag = grid[i][j];
                if (!visitedLand[i][j] && flag == 1) {
                    maxCount = Math.max(dfs(grid, i, j, visitedLand), maxCount);
                }
            }
        }
        return maxCount;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visitedLand) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visitedLand[i][j]) {
            return 0;
        }

        int count = 1;
        visitedLand[i][j] = true;
        count += dfs(grid, i - 1, j, visitedLand);
        count += dfs(grid, i + 1, j, visitedLand);
        count += dfs(grid, i, j - 1, visitedLand);
        count += dfs(grid, i, j + 1, visitedLand);
        return count;
    }
}
