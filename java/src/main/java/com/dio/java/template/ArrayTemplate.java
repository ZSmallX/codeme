package com.dio.java.template;

import com.dio.java.OjUtils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArrayTemplate {
    @Test
    public void test() {
        int[] input1 = new int[]{-1, 0, 1, 2, -1, -4};
        String outputText = "[\n" +
                "  [-1, 0, 1],\n" +
                "  [-1, -1, 2]\n" +
                "]";
        Assert.assertThat(OjUtils.toIntListList(outputText), new OjUtils.ListListMatcher(threeSum(input1)));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return OjUtils.toIntListList("[\n" +
                "  [-1, 0, 1],\n" +
                "  [-1, -1, 2]\n" +
                "]");
    }
}
