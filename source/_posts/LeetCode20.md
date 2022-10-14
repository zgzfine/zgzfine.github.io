---
title: LeetCode 20. 有效的括号
date: 2022-10-14 17:06:04
tags:
categories:

- LeetCode
- 栈与队列

---

> 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

<!--more-->

有效字符串需满足：

* 左括号必须用相同类型的右括号闭合。
* 左括号必须以正确的顺序闭合。
* 每个右括号都有一个对应的相同类型的左括号。

示例 1：
输入：s = "()"  
输出：true

示例2：
输入：s = "()[]{}"  
输出：true

示例3：
输入：s = "(]"  
输出：false

```
/**
 * 题目意思就是判断是否有"正确的括号"
 * 1、由于括号都是有成对的出现，所以字符串必须是双数
 * <p>
 * 第一种情况：已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false
 * <p>
 * 第二种情况：遍历字符串匹配的过程中，发现栈里没有要匹配的字符。所以return false
 * <p>
 * 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号return false
 */
public boolean isValid(String s) {
    if (s.length() % 2 != 0) {
        return false;//如果不为0，就不是
    }
    //由于栈的 LIFO 特性，适合这道题
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        //如果是 （ { [ 这三种，需要相应入栈翻括号
        if (c == '(') {
            stack.push(')');
        } else if (c == '[') {
            stack.push(']');
        } else if (c == '{') {
            stack.push('}');
        } else if (stack.isEmpty() || c != stack.peek()) {
            return false;
        } else
            stack.pop();
    }
    return stack.isEmpty();
}

```
