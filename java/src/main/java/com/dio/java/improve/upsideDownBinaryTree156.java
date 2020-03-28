package com.dio.java.improve;

import org.junit.Assert;
import org.junit.Test;

import dio.oj.scaffolding.OjUtils;
import dio.oj.scaffolding.TreeNode;

// Tag: Tree,travel
public class upsideDownBinaryTree156 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new Integer[]{4, 5, 2, null, null, 3, 1},
                OjUtils.convertTreeAsArrays(
                        upsideDownBinaryTree(OjUtils.newTreeFromArrays(1, 2, 3, 4, 5))));
    }

    TreeNode newRoot = null;
    TreeNode newCurr = null;

    // 后序遍历 + 标记处理
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        helper(root, false);
        return newRoot;
    }

    public void helper(TreeNode curr, boolean isRight) {
        if (curr == null) {
            return;
        }
//        System.out.println(curr.val);
        helper(curr.left, false);
        helper(curr.right, true);
//        helper(curr, 0);
        if (newCurr == null) {
            newCurr = new TreeNode(curr.val);
            newRoot = newCurr;
        } else {
            if (isRight) {
                newCurr.left = new TreeNode(curr.val);
            } else {
                newCurr = newCurr.right = new TreeNode(curr.val);
            }
        }
    }
}
