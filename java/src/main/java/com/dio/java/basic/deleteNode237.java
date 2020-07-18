package com.dio.java.basic;

import org.junit.Test;

import oj.scaffold.ListNode;

public class deleteNode237 {
    @Test
    public void test() {
        deleteNode(null); // PlaceHolder
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
