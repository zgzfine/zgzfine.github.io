---
title: LeetCode 160. 相交链表
date: 2022-10-04 00:26:42
tags:
---

> 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。   
> 图示两个链表在节点 c1 开始相交：   
> ![ing](../images/leetcode160/160_statement.png))

<!--more--> 

> 题目数据 保证 整个链式结构中不存在环。   
> 注意，函数返回结果后，链表必须 保持其原始结构 。   
> 自定义评测：   
> 评测系统 的输入如下（你设计的程序 不适用 此输入）：
> 
> * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0   
> * listA - 第一个链表   
> * listB - 第二个链表   
> * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数   
> * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数   
> * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
> 


~~~
/**
 * 根据题意，求两个链表的交点节点，如果没有交点，返回null
 * 由于链表存在交点，所以，从交点开始直到末尾，都是相同的节点
 * 鉴于以上的原因，可以求出A、B链表的长度差N,长的链表先走N步，再 A、B一起走，直到遇到相同的节点
 */
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;
    //求A的长度
    int lenA = 0;
    int lenB = 0;
    while (a != null) {
        a = a.next;
        lenA++;
    }
    //求B的长度
    while (b != null) {
        b = b.next;
        lenB++;
    }
    //还原A，B链表
    a = headA;
    b = headB;
    //A、B交换，确保 A链表是最长的
    if (lenA < lenB) {
        int temp = lenA;
        lenA = lenB;
        lenB = temp;
        ListNode node = a;
        a = b;
        b = node;
    }
    int n = lenA - lenB;
    while (n-- > 0) {
        a = a.next;
    }
    while (a != null) {
        if (a == b) {
            return a;
        }
        a = a.next;
        b = b.next;
    }
    return null;
}

/**
 * 双指针计算
 * 解析：https://leetcode.cn/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/
 */
public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
        return null;
    }
    ListNode pA = headA, pB = headB;
    while (pA != pB) {
        pA = pA == null ? headB : pA.next;
        pB = pB == null ? headA : pB.next;
    }
    return pA;
}

~~~