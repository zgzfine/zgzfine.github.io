---
title: LeetCode 19. 删除链表的倒数第 N 个结点
date: 2022-10-03 00:13:37
tags: LeetCode
categories: 
- LeetCode
- 链表
---

> 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

<!--more-->

> 输入：head = [1,2,3,4,5], n = 2  
> 输出：[1,2,3,5]
>  
> 输入：head = [1], n = 1  
> 输出：[]


~~~
/**
 * 头结点使用虚拟节点处理
 * 使用快慢指针
 * 快指针先走N部
 * 接着快慢指针一起走
 * x = N + M ;
 * 最终慢指针的下一个节点就是需要删除的节点（慢指针走了 M 步）
 */
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummp = new ListNode(0, head);
    ListNode fastNode = dummp;
    ListNode showNode = dummp;
    while (fastNode.next != null) {
        fastNode = fastNode.next;
        if (n-- <= 0) {
            //快指针已经走了N步，此时慢指针开始走
            showNode = showNode.next;
        }
    }
    if (showNode.next != null) {
        showNode.next = showNode.next.next;
    }
    return dummp.next;
}
~~~