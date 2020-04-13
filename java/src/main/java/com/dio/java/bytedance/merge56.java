package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import oj.scaffold.OjUtils;

public class merge56 {
    @Test
    public void test() {
        int[][] input = OjUtils.toIntMatrix("[[1,3],[2,6],[8,10],[15,18]]");
        int[][] excepted = OjUtils.toIntMatrix("[[1,6],[8,10],[15,18]]");
        Assert.assertArrayEquals(excepted, merge(input));
    }

    @Test
    public void test1() {
        int[][] input = OjUtils.toIntMatrix("[[1, 4],[4,5]]");
        int[][] excepted = OjUtils.toIntMatrix("[[1, 5]]");
        Assert.assertArrayEquals(excepted, merge(input));
    }

    @Test
    public void test2() {
        int[][] input = OjUtils.toIntMatrix("[[1, 4],[1,5]]");
        int[][] excepted = OjUtils.toIntMatrix("[[1, 5]]");
        Assert.assertArrayEquals(excepted, merge(input));
    }

    @Test
    public void test3() {
        int[][] input = OjUtils.toIntMatrix("[[0, 0]]");
        int[][] excepted = OjUtils.toIntMatrix("[[0, 0]]");
        Assert.assertArrayEquals(excepted, merge(input));
    }

    // 排序 再合并 O(nlogn + n)
    public int[][] merge1(int[][] intervals) {
        if (intervals == null) {
            return null;
        }

        Arrays.sort(intervals, new Comparator() {
            @Override
            public int compare(Object i1, Object i2) {
                return ((int[]) i1)[0] - ((int[]) i2)[0];
            }
        });
        List<int[]> list = new ArrayList();
        int[] last = null;
        for (int i = 0, len = intervals.length; i < len; i++) {
            int[] curr = intervals[i];
            if (last != null && curr[0] <= last[1]) {
                int[] merge = new int[]{
                        Math.min(curr[0], last[0]),
                        Math.max(curr[1], last[1])
                };
                list.remove(list.size() - 1);
                list.add(merge);
                last = merge;
            } else {
                list.add(curr);
                last = curr;
            }

        }
        return list.toArray(new int[0][]);
    }

    // 排序 再合并 O(nlogn + n) 优化comparator的使用和for循环（i,i-1）的技巧
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int[] last = intervals[0];
        for (int i = 1, len = intervals.length; i < len; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= last[1]) {
                int[] merge = new int[]{
                        Math.min(curr[0], last[0]),
                        Math.max(curr[1], last[1])
                };
                list.remove(list.size() - 1);
                list.add(merge);
                last = merge;
            } else {
                list.add(curr);
                last = curr;
            }

        }
        return list.toArray(new int[0][]);
    }
}
