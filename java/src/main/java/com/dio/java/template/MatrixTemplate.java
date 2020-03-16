package com.dio.java.template;

import org.junit.Assert;
import org.junit.Test;

import dio.oj.scaffolding.OjUtils;

public class MatrixTemplate {
    @Test
    public void test() {
        int[][] input = OjUtils.toIntMatrix("[\n" +
                "  [1,   4,  7, 11, 15],\n" +
                "  [2,   5,  8, 12, 19],\n" +
                "  [3,   6,  9, 16, 22],\n" +
                "  [10, 13, 14, 17, 24],\n" +
                "  [18, 21, 23, 26, 30]\n" +
                "]\n");
        Assert.assertTrue(template(input, 5));

    }

    public boolean template(int[][] matrix, int target) {
        return true;
    }
}
