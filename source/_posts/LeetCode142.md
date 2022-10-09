---
title: LeetCode 142. 环形链表 II
date: 2022-10-04 00:23:23
tags:
---


> 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。  
> 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。  
> 不允许修改 链表。

<!--more--> 

> 输入：head = [3,2,0,-4], pos = 1   
> 输出：返回索引为 1 的链表节点   
> 解释：链表中有一个环，其尾部连接到第二个节点。  
> 
> 输入：head = [1,2], pos = 0   
> 输出：返回索引为 0 的链表节点   
> 解释：链表中有一个环，其尾部连接到第一个节点。  
> 
> 

~~~
/**
 * 使用快慢指针能判断是否有环(相遇就是有环，但是相遇的不是第一个相遇的节点)
 * 假设从头结点到环形入口节点 的节点数为x。 环形入口节点到 fast指针与slow指针相遇节点 节点数为y。 从相遇节点 再到环形入口节点节点数为 z
 * 那么相遇时： slow指针走过的节点数为: x + y， fast指针走过的节点数：x + y + n (y + z)，n为fast指针在环内走了n圈才遇到slow指针， （y+z）为 一圈内节点的个数A。
 * <p>
 * 因为fast指针是一步走两个节点，slow指针一步走一个节点， 所以 fast指针走过的节点数 = slow指针走过的节点数 * 2：
 * <p>
 * (x + y) * 2 = x + y + n (y + z)
 * <p>
 * 两边消掉一个（x+y）: x + y = n (y + z)
 * <p>
 * 当 n为1的时候，公式就化解为 x = z
 */
public ListNode detectCycle(ListNode head) {
    ListNode fastNode = head;
    ListNode showNode = head;
    while (fastNode != null && fastNode.next != null) {
        fastNode = fastNode.next.next;
        showNode = showNode.next;
        if (fastNode == showNode) {
            ListNode a = head;
            ListNode b = fastNode;
            while (a != b) {
                a = a.next;
                b = b.next;
            }
            return a;
        }
    }
    return null;
}

~~~
