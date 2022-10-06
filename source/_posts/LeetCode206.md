---
title: LeetCode 206. 反转链表
date: 2022-10-06 16:24:19
tags:
---

> 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。


<!--more--> 

> 输入：head = [1,2,3,4,5]   
> 输出：[5,4,3,2,1]
> ![](../images/leetcode206/rev1ex1.jpg)
>
 

~~~
/**
 * 如题，链表翻转，可以定义一个前置节点，默认是default = null
 */
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
        ListNode temp = cur.next;
        cur.next = prev;
        prev = cur;
        cur = temp;
    }
    return prev;
}
~~~