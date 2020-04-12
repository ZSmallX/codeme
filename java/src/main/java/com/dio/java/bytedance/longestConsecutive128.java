package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestConsecutive128 {
    @Test
    public void test() {
        int[] input1 = new int[]{100, 4, 200, 1, 3, 2};
        Assert.assertEquals(4, longestConsecutive(input1));
    }

    // 烂方法
    public int longestConsecutive1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            int value = nums[i];
            if (map.containsKey(value)) {
                // map.put(value, map.get(value) + 1);
            } else {
                map.put(value, map.getOrDefault(value - 1, 0) + map.getOrDefault(value + 1, 0) + 1);
            }
            refresh(value, map, map.get(value));
        }
        int max = 0;
        for (Integer i : map.values()) {
            max = Math.max(max, i);
        }
        return max;
    }

    private void refresh(int value, Map<Integer, Integer> map, int count) {
        while (map.containsKey(--value)) {
            map.put(value, count);
        }

        while (map.containsKey(++value)) {
            map.put(value, count);
        }
    }

    // 排序 遍历
    public int longestConsecutive2(int[] nums) {
        Arrays.sort(nums);
        int ancor = 0;
        int duplicate = 0;
        int max = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                duplicate++;
                continue;
            }
            if (i > 0 && nums[i] - nums[i - 1] > 1) {
                max = Math.max(max, i - ancor - duplicate);
                ancor = i;
                duplicate = 0;
            }
        }
        return Math.max(max, nums.length - ancor - duplicate);
    }

    // 排序 遍历 优化 O(nlogn)
    public int longestConsecutive3(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Arrays.sort(nums);
        int max = 0;
        int curr = 1;
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] != 1) {
                max = Math.max(max, curr);
                curr = 1;
            } else {
                curr++;
            }
        }
        return Math.max(max, curr);
    }

    // 基于HashSet O(n)
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        int curr = 1;
        for (int i : set) {
            if (!set.contains(i - 1)) { // 避免重复计算
                while (set.contains(++i)) {
                    curr++;
                }
                max = Math.max(max, curr);
                curr = 1;
            }
        }

        return max;
    }
}
