package com.dio.java.template;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ListTemplate {
    @Test
    public void test() {
        Assert.assertEquals(0, listTemplate(Arrays.asList(new String[]{"un", "iq", "ue"})));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, listTemplate(Arrays.asList(new String[]{"cha", "r", "act", "ers"})));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, listTemplate(Arrays.asList(new String[]{"abcdefghijklmnopqrstuvwxyz"})));
    }


    public int listTemplate(List<String> arr) {
        return 0;
    }
}
