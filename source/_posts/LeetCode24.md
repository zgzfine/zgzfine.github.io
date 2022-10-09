---
title: LeetCode 24. 两两交换链表中的节点
date: 2022-10-03 00:45:29
tags: LeetCode
categories:
- LeetCode
- 链表
---

> 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

<!--more-->

> 输入：head = [1,2,3,4]  
> 输出：[2,1,4,3]
> 
> 输入：head = []  
> 输出：[]
> 
> 输入：head = [1]  
> 输出：[1]  
> 

~~~
/**
 * 如：
 * cur>1>2>3>4>5>6
 * 1、cur>2
 * 2、2>1
 * 3、1>3
 * 第一轮结果 cur>2>1>3>4>5>6
 * cur = cur.next.next;
 * 当前cur>3>4>5>6
 */
public ListNode swapPairs(ListNode head) {
    ListNode dummp = new ListNode(0, head);
    ListNode cur = dummp;
    while (cur.next != null && cur.next.next != null) {
        ListNode one = cur.next;
        ListNode two = cur.next.next;
        ListNode three = cur.next.next.next;
        cur.next = two;
        two.next = one;
        one.next = three;
        cur = cur.next.next;

    }
    return dummp.next;
}
~~~
