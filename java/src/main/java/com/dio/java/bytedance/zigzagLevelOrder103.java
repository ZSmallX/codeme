package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import oj.scaffold.OjUtils;
import oj.scaffold.TreeNode;

public class zigzagLevelOrder103 {
    @Test
    public void test() {
        Assert.assertThat(OjUtils.toListList("[[3],[20,9],[15,7]]", OjUtils.INTEGER_CREATOR),
                new OjUtils.ListListMatcher(
                        zigzagLevelOrder(OjUtils.newTreeFromArrays(new Integer[]{3, 9, 20, null, null, 15, 7}))));
    }

    @Test
    public void test1() {
        Assert.assertThat(OjUtils.toListList("[]", OjUtils.INTEGER_CREATOR),
                new OjUtils.ListListMatcher(
                        zigzagLevelOrder(OjUtils.newTreeFromArrays(new Integer[]{}))));
    }

    @Test
    public void test2() {
        Assert.assertThat(OjUtils.toListList("[[3],[20]]", OjUtils.INTEGER_CREATOR),
                new OjUtils.ListListMatcher(
                        zigzagLevelOrder(OjUtils.newTreeFromArrays(new Integer[]{3, null, 20}))));
    }

    @Test
    public void test3() {
        Assert.assertThat(OjUtils.toListList("[[3],[9]]", OjUtils.INTEGER_CREATOR),
                new OjUtils.ListListMatcher(
                        zigzagLevelOrder(OjUtils.newTreeFromArrays(new Integer[]{3, 9}))));
    }

    @Test
    public void test4() {
        Assert.assertThat(OjUtils.toListList("[[3]]", OjUtils.INTEGER_CREATOR),
                new OjUtils.ListListMatcher(
                        zigzagLevelOrder(OjUtils.newTreeFromArrays(new Integer[]{3}))));
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        LinkedList<Integer> levelList = new LinkedList<>();
        boolean isLeftOrder = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node != null) {
                if (isLeftOrder) {
                    levelList.addLast(node.val);
                } else {
                    levelList.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            } else {
                result.add(levelList);
                levelList = new LinkedList<>();
                if (!queue.isEmpty()) {
                    queue.addLast(null);
                }
                isLeftOrder = !isLeftOrder;
            }
        }
        return result;
    }
}
