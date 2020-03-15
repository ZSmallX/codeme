package com.dio.java.improve;

import com.dio.java.OjUtils;

import org.junit.Assert;
import org.junit.Test;

// start at 2020/3/8 16:55
public class searchMatrix240 {
    @Test
    public void test() {
        int[][] input = OjUtils.toIntMatrix("[\n" +
                "  [1,   4,  7, 11, 15],\n" +
                "  [2,   5,  8, 12, 19],\n" +
                "  [3,   6,  9, 16, 22],\n" +
                "  [10, 13, 14, 17, 24],\n" +
                "  [18, 21, 23, 26, 30]\n" +
                "]\n");
        Assert.assertTrue(searchMatrix(input, 5));
        Assert.assertFalse(searchMatrix(input, 20));
    }

    // 根据矩阵特点裁剪矩阵 O(m + n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col <= matrix[0].length - 1) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }

        return false;
    }

    // 二刀切割法 O(nlogn)
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        return helper(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean helper(int[][] matrix, int target, int rs, int re, int cs, int ce) {
        if (cs > ce || rs > re) return false;

        if (matrix[rs][cs] == target || matrix[re][ce] == target) return true;

        if (matrix[rs][cs] > target || target > matrix[re][ce]) return false;

        int midCol = (ce + cs) / 2;
        int midRow = (re + rs) / 2;

        return helper(matrix, target, rs, midRow, cs, midCol)
                || helper(matrix, target, rs, midRow, midCol + 1, ce)
                || helper(matrix, target, midRow + 1, re, midCol + 1, ce)
                || helper(matrix, target, midRow + 1, re, cs, midCol);
    }

    // 暴力法
    public boolean searchMatrix3(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
