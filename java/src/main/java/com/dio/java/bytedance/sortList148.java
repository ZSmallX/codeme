package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import oj.scaffold.ListNode;
import oj.scaffold.OjUtils;

public class sortList148 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4},
                OjUtils.travelListNode(sortList(OjUtils.newListNodeFromArrays(new Integer[]{4, 2, 1, 3})), 4));
    }

    // O(nlogn) O(n)
    // TODO: 2020/4/18 链表归并排序 O(nlogn) O(1)
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l2.val - l1.val;
            }
        });
        ListNode curr = head;
        while (curr != null) {
            heap.offer(curr);
            curr = curr.next;
        }

        ListNode last = null;
        while (!heap.isEmpty()) {
            ListNode max = heap.poll();
            max.next = last;
            last = max;
        }
        return last;
    }
}
