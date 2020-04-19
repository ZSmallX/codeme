package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import oj.scaffold.OjUtils;
import oj.scaffold.TreeNode;

public class lowestCommonAncestor26 {
    @Test
    public void test() {
        Assert.assertEquals(3,
                lowestCommonAncestor(
                        OjUtils.newTreeFromArrays(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4),
                        new TreeNode(5),
                        new TreeNode(1)).val);
    }

    // DFS
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return (left == null ? right : (right == null ? left : root));
    }
}
