package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import oj.scaffold.ListNode;
import oj.scaffold.OjUtils;

public class mergeKLists23 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4, 5, 6},
                OjUtils.travelListNode(mergeKLists(
                        new ListNode[]{
                                OjUtils.newListNodeFromArrays(new Integer[]{1, 4, 5}),
                                OjUtils.newListNodeFromArrays(new Integer[]{1, 3, 4}),
                                OjUtils.newListNodeFromArrays(new Integer[]{2, 6})

                        }), 8));
    }

    // O(nlogk)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        for (ListNode l : lists) {
            if (l != null) {
                heap.offer(l);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            if (min.next != null) {
                heap.offer(min.next);
            }
            ListNode node = new ListNode(min.val);
            curr = curr.next = node;
        }
        return dummy.next;
    }

    // O(kn)
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode merged = lists[0];
        for (int i = 1; i < lists.length; i++) {
            merged = mergeTwoLists(merged, lists[i]);
        }
        return merged;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode last = dummy;
        while (p1 != null && p2 != null) {
            int val = p1.val;
            if (p1.val > p2.val) {
                val = p2.val;
                p2 = p2.next;
            } else {
                p1 = p1.next;
            }
            ListNode node = new ListNode(val);
            last = last.next = node;
        }
        if (p1 != null) {
            last.next = p1;
        }
        if (p2 != null) {
            last.next = p2;
        }

        return dummy.next;
    }
}
