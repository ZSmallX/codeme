package com.dio.java;

import org.junit.Assert;
import org.junit.Test;

public class OjUtilsTest {
    @Test
    public void testToIntMatrix() {
        Assert.assertEquals(null, OjUtils.toIntMatrix(""));
    }
}
