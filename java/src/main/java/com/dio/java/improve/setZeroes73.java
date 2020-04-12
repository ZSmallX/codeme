package com.dio.java.improve;

import org.junit.Assert;
import org.junit.Test;

import oj.scaffold.OjUtils;

public class setZeroes73 {
    @Test
    public void test() {
        int[][] matrix1 = OjUtils.toIntMatrix("[\n" +
                "  [1,1,1],\n" +
                "  [1,0,1],\n" +
                "  [1,1,1]\n" +
                "]");
        int[][] result1 = OjUtils.toIntMatrix("[\n" +
                "  [1,0,1],\n" +
                "  [0,0,0],\n" +
                "  [1,0,1]\n" +
                "]");
        setZeroes(matrix1);
        Assert.assertEquals(matrix1.length, result1.length);
        for (int i = 0; i < result1.length; i++) {
            Assert.assertArrayEquals(result1[i], matrix1[i]);
        }
    }

    @Test
    public void test2() {
        int[][] matrix1 = OjUtils.toIntMatrix("[\n" +
                "  [0,1,2,0],\n" +
                "  [3,4,5,2],\n" +
                "  [1,3,1,5]\n" +
                "]");
        int[][] result1 = OjUtils.toIntMatrix("[\n" +
                "  [0,0,0,0],\n" +
                "  [0,4,5,0],\n" +
                "  [0,3,1,0]\n" +
                "]");
        setZeroes(matrix1);
        Assert.assertEquals(matrix1.length, result1.length);
        for (int i = 0; i < result1.length; i++) {
            Assert.assertArrayEquals(result1[i], matrix1[i]);
        }
    }

    /**
     * 首行处理
     */
    @Test
    public void test3() {
        int[][] matrix1 = OjUtils.toIntMatrix("[[1,1,1],[0,1,2]]");
        int[][] result1 = OjUtils.toIntMatrix("[[0,1,1],[0,0,0]]");
        setZeroes(matrix1);
        Assert.assertEquals(matrix1.length, result1.length);
        for (int i = 0; i < result1.length; i++) {
            Assert.assertArrayEquals(result1[i], matrix1[i]);
        }
    }

    /**
     * 首行的处理
     */
    @Test
    public void test4() {
        int[][] matrix1 = OjUtils.toIntMatrix("[[1,0,3]]");
        int[][] result1 = OjUtils.toIntMatrix("[[0,0,0]]");
        setZeroes(matrix1);
        Assert.assertEquals(matrix1.length, result1.length);
        for (int i = 0; i < result1.length; i++) {
            Assert.assertArrayEquals(result1[i], matrix1[i]);
        }
    }

    // 1.空间O(mn):标记每个点的状态，再刷新值
    // 2.空间O(m+n):标记行和列的状态，再刷新值
    // 3.空间O(1):在行和列的头部标记状态，再根据行列刷新值(首行首列需要额外处理)
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        boolean needSetFirstRow = false;
        boolean needSetFirstCol = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                needSetFirstCol = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                needSetFirstRow = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

//        for (int i = 1; i < matrix.length; i++) {
//            if (matrix[i][0] == 0) {
//                for (int j = 1; j < matrix[i].length; j++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//
//        for (int j = 1; j < matrix[0].length; j++) {
//            if (matrix[0][j] == 0) {
//                for (int i = 1; i < matrix.length; i++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }

        if (needSetFirstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (needSetFirstRow) {
            //            Arrays.fill(matrix[0], 0);
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        boolean[] needSetRows = new boolean[matrix.length];
        boolean[] needSetCols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    needSetRows[i] = true;
                    needSetCols[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (needSetRows[i] || needSetCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 等效于以上的循环
//        for (int i = 0; i < matrix.length; i++) {
//            if (needSetRows[i]) {
//                for (int j = 0; j < matrix[i].length; j++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//
//        for (int j = 0; j < matrix[0].length; j++) {
//            if (needSetCols[j]) {
//                for (int i = 0; i < matrix.length; i++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
    }
}
