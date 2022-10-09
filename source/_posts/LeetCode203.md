---
title: LeetCode 203. 移除链表元素
date: 2022-10-06 16:18:39
tags:
---

> 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
> ![](../images/leetcode203/removelinked-list.jpg)


<!--more--> 

> 输入：head = [1,2,6,3,4,5,6], val = 6  
> 输出：[1,2,3,4,5]
> 
> 输入：head = [], val = 1   
> 输出：[]
> 
> 输入：head = [7,7,7,7], val = 7   
> 输出：[]
> 
~~~
/**
 * 当节点的next==null就是到链表尾巴
 *
 * @param head
 * @param val
 * @return
 */
public ListNode removeElements(ListNode head, int val) {
    //初始化一个指向头结点的临时节点
    ListNode temp = new ListNode(0, head);
    ListNode pre = temp;
    while (pre.next != null) {
        if (pre.next.val == val) {
            //当前节点的下一个节点赋值给前一个节点的next
            pre.next = pre.next.next;
        } else {
            pre = pre.next;
        }
    }
    return temp.next;
}
~~~
