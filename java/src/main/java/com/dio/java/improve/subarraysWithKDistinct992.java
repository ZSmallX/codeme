package com.dio.java.improve;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// Tag: Slide Window, sorted, Heap
public class subarraysWithKDistinct992 {
    @Test
    public void test() {
        Assert.assertEquals(7, subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        Assert.assertEquals(3, subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
        Assert.assertEquals(5, subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 1));
    }

    public int subarraysWithKDistinct1(int[] A, int K) {
        int left = 0;
        int left2 = 0;
        int right = 0;
        int count = 0;
        int n = A.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        while (right < n) {
            Integer i = A[right];
            map1.put(i, map1.getOrDefault(i, 0) + 1);
            map2.put(i, map2.getOrDefault(i, 0) + 1);

            while (map1.size() > K) {
                Integer i2 = A[left];
                if (map1.get(i2).intValue() == 1) {
                    map1.remove(i2);
                } else {
                    map1.put(i2, map1.get(i2) - 1);
                }
                left++;
            }

            while (map2.size() >= K) {
                Integer i2 = A[left2];
                if (map2.get(i2).intValue() == 1) {
                    map2.remove(i2);
                } else {
                    map2.put(i2, map2.get(i2) - 1);
                }
                left2++;
            }
            count += left2 - left;
            right++;
        }
        return count;
    }

    // 抽象成window
    public int subarraysWithKDistinct(int[] A, int K) {
        int left = 0;
        int left2 = 0;
        int right = 0;
        int count = 0;
        int n = A.length;
        Window window1 = new Window();
        Window window2 = new Window();
        Map<Integer, Integer> map2 = new HashMap<>();
        while (right < n) {
            window1.add(A[right]);
            window2.add(A[right]);

            while (window1.distinct > K) {
                window1.remove(A[left++]);
            }

            while (window2.distinct >= K) {
                window2.remove(A[left2++]);
            }

            count += left2 - left;
            right++;
        }
        return count;
    }

    public class Window {
        Map<Integer, Integer> map = new HashMap<>();
        int distinct = 0;

        public void add(int v) {
            map.put(v, map.getOrDefault(v, 0) + 1);
            if (map.get(v).intValue() == 1) {
                distinct++;
            }
        }

        public void remove(int v) {
            int count = map.getOrDefault(v, 0) - 1;
            if (count <= 0) {
                map.remove(v);
                distinct--;
            } else {
                map.put(v, count);
            }
        }

        public int getDistinct() {
            return distinct;
        }
    }
}
