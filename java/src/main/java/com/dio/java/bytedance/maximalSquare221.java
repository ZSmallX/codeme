package com.dio.java.bytedance;

public class maximalSquare221 {
    // FIXME: 2020/4/19 char[][] creator
//    @Test
//    public void test() {
//        int[][] input = OjUtils.toIntMatrix("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]");
//        Assert.assertEquals(4, maximalSquare(input));
//    }

    // 动态规划
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int maxStep = 0;
        int prev = 0;
        int[] dp = new int[matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[i - 1].length; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxStep = Math.max(maxStep, dp[j]);
                } else { // 避免使用跨层保留的脏值
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxStep * maxStep;
    }

    public int maximalSquare1(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int maxStep = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[i - 1].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxStep = Math.max(maxStep, dp[i][j]);
                }
            }
        }
        return maxStep * maxStep;
    }
}
