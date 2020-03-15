package com.dio.java.template;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ListTemplate {
    @Test
    public void test() {
        Assert.assertEquals(0, template(Arrays.asList(new String[]{"un", "iq", "ue"})));
    }

    public int template(List<String> arr) {
        return 0;
    }
}
