package com.developerlizhi.leetcode;

import java.util.Stack;

/**
 * @author developerlizhi
 * @date 2021-04-22 11:32:36
 */
public class Solution020 {

    public static void main(String[] args) {
        //        Stack<Character> stack = new Stack<>();
        //        stack.push('a');
        //        stack.push('c');
        //        System.out.println(stack.search('a'));

        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("(}{)"));
        System.out.println(isValid("(){}}{"));
    }

    public static boolean isValid(String s) {

        // 奇数位肯定不符合条件，优先排除
        if (null == s || s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            // 如果传入的是右侧括号，则栈中必有左侧括号，如果没有，则一定不符合条件
            if (c == ')' || c == '}' || c == ']') {
                if (stack.search(symmetry(c)) == -1) {
                    return false;
                }
            }

            if (stack.empty()) {
                stack.push(c);
            } else {
                if (stack.peek() == symmetry(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.empty();
    }

    public static char symmetry(char c) {
        switch (c) {
            case '(':
                return ')';
            case ')':
                return '(';
            case '{':
                return '}';
            case '}':
                return '{';
            case '[':
                return ']';
            case ']':
                return '[';
            default:
                return 0;
        }
    }
}
