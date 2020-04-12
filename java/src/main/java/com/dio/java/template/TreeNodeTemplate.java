package com.dio.java.template;

import org.junit.Assert;
import org.junit.Test;

import oj.scaffold.OjUtils;
import oj.scaffold.TreeNode;

public class TreeNodeTemplate {
    @Test
    public void test() {
        Assert.assertArrayEquals(new Integer[]{}, OjUtils.convertTreeAsArrays(
                template(OjUtils.newTreeFromArrays(1, 2, 3, 4, 5))));
    }

    public TreeNode template(TreeNode root) {
        return null;
    }
}
