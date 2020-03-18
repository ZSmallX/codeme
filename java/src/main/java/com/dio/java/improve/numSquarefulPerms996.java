package com.dio.java.improve;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class numSquarefulPerms996 {
    // 全排列
    Set<List<Integer>> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();

    @Test
    public void test() {
        int[] test1 = new int[]{1, 17, 8};
        Assert.assertEquals(2, numSquarefulPerms(test1));
    }

    @Test
    public void test1() {
        int[] test1 = new int[]{2, 2, 2};
        Assert.assertEquals(1, numSquarefulPerms(test1));
    }

    @Test
    public void test2() {
        int[] test1 = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        Assert.assertEquals(1, numSquarefulPerms(test1));
    }

    @Test
    public void test3() {
        int[] test1 = new int[]{0, 0, 0, 1, 1, 1};
        Assert.assertEquals(4, numSquarefulPerms(test1));
    }

    // 全排列 + 排序 最优解？
    public int numSquarefulPerms(int[] A) {
        if (A == null || A.length == 0) return 0;
        boolean[] visited = new boolean[A.length];
        Arrays.sort(A);
        helper(A, visited, 0);
        return set.size();
    }

    private void helper(int[] A, boolean[] visited, int index) {
        if (index == A.length) {
            set.add(list);
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (!visited[i] && isSquared(list, i, A)) {
                if (i > 0 && A[i] == A[i - 1] && !visited[i - 1]) {
                    continue;
                }
                visited[i] = true;
                list.add(A[i]);
                helper(A, visited, index + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    private boolean isSquared(List<Integer> list, int i, int[] A) {
        return list.size() == 0 || isSquared(list.get(list.size() - 1) + A[i]);
    }

    private boolean isSquared0(int i) {
        int n = (int) Math.sqrt(i);
        for (int j = 0; j < n + 1; j++) {
            if (i == j * j) {
                return true;
            }
        }
        return false;
    }

    // 更优的判断平方数
    private boolean isSquared(int i) {
        int n = (int) Math.sqrt(i);
        return n * n == i || (n + 1) * (n + 1) == i;
    }
}
