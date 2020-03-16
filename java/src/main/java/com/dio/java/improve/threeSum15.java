package com.dio.java.improve;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dio.oj.scaffolding.OjUtils;

public class threeSum15 {
    @Test
    public void test() {
        int[] input1 = new int[]{-1, 0, 1, 2, -1, -4};
        String outputText = "[\n" +
                "  [-1, 0, 1],\n" +
                "  [-1, -1, 2]\n" +
                "]";
        Assert.assertThat(OjUtils.toIntListList(outputText), new OjUtils.ListListMatcher(threeSum(input1)));
    }

    // 排序 + 双指针，解决重复
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return result;
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> current = new ArrayList<>();
                    current.add(nums[i]);
                    current.add(nums[left]);
                    current.add(nums[right]);
                    result.add(current);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    // 暴力法
    public List<List<Integer>> threeSum0(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> current = new ArrayList<>();
                        current.add(nums[i]);
                        current.add(nums[j]);
                        current.add(nums[k]);
                        if (!isContains(result, nums[i], nums[j], nums[k])) {
                            result.add(current);
                        }
                    }
                }
            }
        }
        return result;
    }

    // TODO: 2020/3/15 consider a nicer implementation!
    private boolean isContains(List<List<Integer>> result, int num, int num1, int num2) {
        List<Integer> current = new ArrayList<>();
        current.add(num);
        current.add(num1);
        current.add(num2);
        List<Integer> current2 = new ArrayList<>();
        current2.add(num);
        current2.add(num2);
        current2.add(num1);
        List<Integer> current3 = new ArrayList<>();
        current3.add(num1);
        current3.add(num2);
        current3.add(num);
        List<Integer> current4 = new ArrayList<>();
        current4.add(num1);
        current4.add(num);
        current4.add(num2);
        List<Integer> current5 = new ArrayList<>();
        current5.add(num2);
        current5.add(num1);
        current5.add(num);
        List<Integer> current6 = new ArrayList<>();
        current6.add(num2);
        current6.add(num);
        current6.add(num1);
        return result.contains(current)
                || result.contains(current2)
                || result.contains(current3)
                || result.contains(current4)
                || result.contains(current5)
                || result.contains(current6);
    }
}
