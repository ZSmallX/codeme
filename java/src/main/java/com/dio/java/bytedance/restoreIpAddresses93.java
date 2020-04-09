package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class restoreIpAddresses93 {
    @Test
    public void test() {
        Assert.assertEquals(Arrays.asList(new String[]{
                "255.255.11.135",
                "255.255.111.35"
        }), restoreIpAddresses("25525511135"));
    }

    @Test
    public void test1() {
        Assert.assertEquals(Arrays.asList(new String[]{
                "0.10.0.10", "0.100.1.0"
        }), restoreIpAddresses("010010"));
    }

    List<String> list = new ArrayList<>();
    int n;

    // TODO: 2020/4/10 使用List代替StringBuilder避免过多的数组操作。
    public List<String> restoreIpAddresses(String s) {
        if (s == null) return null;
        if (s.length() == 0) return list;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        n = s.length();
        helper(chars, sb, 0, 4);
        return list;
    }

    private void helper(char[] chars, StringBuilder sb, int start, int ipCount) {
        if (ipCount == 0) {
            list.add(sb.toString().substring(0, sb.length() - 1));
            return;
        }

        StringBuilder currIp = new StringBuilder();
        for (int i = 0; i < 3 && start + i < n; i++) {
            currIp.append(chars[start + i]);
            if (isCurrIpValid(currIp) && isAllValidIp(start + i + 1, ipCount - 1)) {
                sb.append(currIp);
                sb.append(".");
                helper(chars, sb, start + i + 1, ipCount - 1);
                sb.delete(sb.length() - currIp.length() - 1, sb.length());
            }
        }
    }

    private boolean isAllValidIp(int i, int ipCount) {
        return ipCount <= n - i && n - i <= ipCount * 3;
    }

    private boolean isCurrIpValid(StringBuilder currIp) {
        return (currIp.length() == 1 || currIp.indexOf("0") != 0) && Integer.parseInt(currIp.toString()) <= 255;
    }
}
