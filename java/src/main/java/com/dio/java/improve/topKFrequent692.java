package com.dio.java.improve;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Tag: Set, sorted
public class topKFrequent692 {
    @Test
    public void test() {
        Assert.assertEquals(
                Arrays.asList(new String[]{"i", "love"}),
                topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        ;
    }

    @Test
    public void test1() {
        Assert.assertEquals(
                Arrays.asList(new String[]{"the", "is", "sunny", "day"}),
                topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    // 统计及排序 O(nlogn)
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue() == 0 ? o1.getKey().compareTo(o2.getKey())
                        : o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    // TODO: 2020/3/31 使用堆 O(nlogk)
}
