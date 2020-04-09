package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class simplifyPath71 {
    @Test
    public void test() {
        Assert.assertEquals("/home", simplifyPath("/home/"));
        Assert.assertEquals("/", simplifyPath("/../"));
        Assert.assertEquals("/home/foo", simplifyPath("/home//foo/"));
        Assert.assertEquals("/c", simplifyPath("/a/./b/../../c/"));
        Assert.assertEquals("/a/b/c", simplifyPath("/a//b////c/d//././/.."));
        Assert.assertEquals("/", simplifyPath("//"));
        Assert.assertEquals("/", simplifyPath("///.."));
        Assert.assertEquals("/...", simplifyPath("/..."));
    }

    // "/..." 失败
    public String simplifyPath1(String path) {
        if (path == null) return null;
        if (path.length() == 0 || path.length() == 1) return path;
        LinkedList<Character> queue = new LinkedList<>();
        path = path + "/";
        char[] chars = path.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '/') {
                while (!queue.isEmpty()) {
                    char top = queue.peekLast();
                    if (top == '/') {
                        queue.pollLast();
                        break;
                    }
                    if (top == '.') {
                        queue.pollLast();
                        if (queue.peekLast() == '.') {
                            queue.pollLast();
                            queue.pollLast();
                            while (!queue.isEmpty()) {
                                if (queue.peekLast() != '/') {
                                    queue.pollLast();
                                } else {
                                    queue.pollLast();
                                    break;
                                }
                            }
                            break;
                        } else if (queue.peekLast() == '/') {
                            queue.pollLast();
                            break;
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            queue.offer(chars[i]);
        }

        if (queue.isEmpty() || (queue.size() == 1 && queue.pollLast() == '/')) {
            return "/";
        }

        if (queue.peekLast() == '/') {
            queue.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.pollFirst());
        }
        return sb.toString();
    }

    public String simplifyPath(String path) {
        if (path == null) return null;
        if (path.length() == 0 || path.length() == 1) return path;
        LinkedList<String> queue = new LinkedList<>();
        String[] segments = path.split("/");
        for (int i = 0; i < segments.length; i++) {
            String segment = segments[i];
            if (segment.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
                continue;
            }
            if (!segment.equals(".") && segment.length() != 0) {
                queue.offer(segment);
            }
        }

        if (queue.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append("/");
            sb.append(queue.pollFirst());
        }
        return sb.toString();
    }
}
