package com.dio.java.template;

import org.junit.Assert;
import org.junit.Test;

import oj.scaffold.ListNode;
import oj.scaffold.OjUtils;

public class ListNodeTemplate {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5},
                OjUtils.travelListNode(reverseList(OjUtils.newListNodeFromArrays(new Integer[]{5, 4, 3, 2, 1})), 5));
    }

    public ListNode reverseList(ListNode head) {
        return OjUtils.newListNodeFromArrays(new Integer[]{5, 4, 3, 2, 1});
    }
}
