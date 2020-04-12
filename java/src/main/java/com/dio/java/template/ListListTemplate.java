package com.dio.java.template;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import oj.scaffold.OjUtils;

public class ListListTemplate {
    @Test
    public void test() {
        int[] input1 = new int[]{-1, 0, 1, 2, -1, -4};
        String outputText = "[\n" +
                "  [-1, 0, 1],\n" +
                "  [-1, -1, 2]\n" +
                "]";
        Assert.assertThat(OjUtils.toListList(outputText, OjUtils.INTEGER_CREATOR),
                new OjUtils.ListListMatcher(threeSum(input1)));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return OjUtils.toListList("[\n" +
                "  [-1, 0, 1],\n" +
                "  [-1, -1, 2]\n" +
                "]", OjUtils.INTEGER_CREATOR);
    }
}
