package com.dio.java.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import dio.oj.scaffolding.TreeNode;

import static dio.oj.scaffolding.OjUtils.newTreeFromArrays;

// Tag: Tree, traversal
public class inorderTraversal94 {
    @Test
    public void test() {
        TreeNode root1 = newTreeFromArrays(-10, -3, 0, 5, 9, 15, 7);
        Integer[] result = new Integer[]{5, -3, 9, -10, 15, 0, 7};
        Assert.assertArrayEquals(result, inorderTraversal(root1).toArray(new Integer[0]));
    }

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
}
