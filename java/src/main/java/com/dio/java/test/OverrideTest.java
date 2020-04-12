package com.dio.java.test;

import java.util.ArrayList;

public class OverrideTest {
    static class C extends BaseTestClass {
//        Object a(int i) {
//            return null;
//        }

        @Override
        ArrayList a(int i) {
            return null;
        }

        ArrayList a(long i) {
            return null;
        }

        ArrayList a(short i) {
            return null;
        }

        ArrayList a(int i, int b) {
            return null;
        }
    }
}
