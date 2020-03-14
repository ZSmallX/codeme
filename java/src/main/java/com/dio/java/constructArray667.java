package com.dio.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// start at 2020/3/8 16:55
public class constructArray667 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 2, 3}, constructArray(3, 1));
        Assert.assertArrayEquals(new int[]{1, 3, 2}, constructArray(3, 2));
        Assert.assertArrayEquals(new int[]{1, 5, 2, 4, 3}, constructArray(5, 4));
        Assert.assertArrayEquals(new int[]{1, 5, 2, 4, 3}, constructArray(92, 80));
    }

    // 暴力法 O(n!)
    public int[] constructArray0(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        List<Integer> array = new ArrayList<>();
        Set<Integer> distincts = new HashSet<>();
        helper(n, k, array, distincts, visited);
        int[] result = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            result[i] = array.get(i);
        }
        return result;
    }

    private List<Integer> helper(int n, int k, List<Integer> array, Set<Integer> distincts, boolean[] visited) {
        if (array.size() == n) {
            if (distincts.size() == k) {
                return array;
            } else {
                return null;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && isValid(n, i, array, k, distincts)) {
                visited[i] = true;
                if (array.size() != 0) {
                    distincts.add(Math.abs(array.get(array.size() - 1) - i));
                }
                array.add(i);
                List<Integer> result = helper(n, k, array, distincts, visited);
                if (result != null) {
                    return array;
                } else {
                    distincts.remove(Math.abs(array.get(array.size() - 2) - i));
                    array.remove(new Integer(i));
                    visited[i] = false;
                    continue;
                }
            }
        }
        return null;
    }

    private boolean isValid(int n, int i, List<Integer> array, int k, Set<Integer> distincts) {
        if (array.size() == 0) return true;
        int abs = Math.abs(array.get(array.size() - 1) - i);
        if (array.size() == n - 1) {
            if (distincts.contains(abs)) {
                return distincts.size() == k;
            } else {
                return distincts.size() + 1 == k;
            }
        } else {
            if (distincts.contains(abs)) {
                return distincts.size() <= k;
            } else {
                return distincts.size() + 1 <= k;
            }
        }
    }

    // 构造法 构造 n-k个差值为1的数，再构造k个差值为{2,...k}的数
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        for (int i = 1; i < n - k; i++) {
            result[i - 1] = i;
        }

        int head = 1;
        int tail = k + 1;
        for (int i = n - k - 1; i < n; i++) {
            if ((i - n - k - 1) % 2 == 0) {
                result[i] = head++;
            } else {
                result[i] = tail--;
            }
            result[i] += n - k - 1;
        }
        return result;
    }
}
