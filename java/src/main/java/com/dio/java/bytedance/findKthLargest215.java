package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

public class findKthLargest215 {
    @Test
    public void test() {
        int[] input1 = new int[]{3, 2, 1, 5, 6, 4};
        Assert.assertEquals(5, findKthLargest(input1, 2));
    }

    @Test
    public void test1() {
        int[] input1 = new int[]{3, 2};
        Assert.assertEquals(2, findKthLargest(input1, 2));
    }

    @Test
    public void test2() {
        int[] input1 = new int[]{3};
        Assert.assertEquals(3, findKthLargest(input1, 1));
    }

    // 使用默认的小顶堆，维持个数=k，最终堆顶元素即是答案。 朴素法是排序。
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return -1;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(/* new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        } */);
        for (int i = 0, len = nums.length; i < len; i++) {
            heap.offer(nums[i]);
            while (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}
