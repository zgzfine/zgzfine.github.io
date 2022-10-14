---
title: LeetCode 225. 用队列实现栈
date: 2022-10-14 16:25:06
tags: 队列
categories:
- LeetCode
- 栈与队列
---

> 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。

<!--more-->

实现 MyStack 类：

void push(int x) 将元素 x 压入栈顶。
int pop() 移除并返回栈顶元素。
int top() 返回栈顶元素。
boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。


注意：

* 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。  
* 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。  


```
public class LeetCode225 {

    private Queue<Integer> queueA = new LinkedList<>();
    private Queue<Integer> queueB = new LinkedList<>();

    /**
     * 其实就是将B队列做一个备份队列
     */
    public LeetCode225() {

    }

    /**
     * 这里标星，需要重点思考
     * 1、每次入栈都是先进入 B 队列，然后将A队列的值放到B
     * 2、将A、B队列交互
     * * 此刻，A队列的队首相当于 栈的顶部，队尾巴相当于 栈的底部
     */
    public void push(int x) {
        queueB.offer(x);//想B队列入队
        while (!queueA.isEmpty()) {
            queueB.offer(queueA.poll());//将A队列的元素全部放到B队列
        }
        //通过交换，此刻 A队列的元素永远是栈的元素
        Queue<Integer> temp = queueA;
        queueA = queueB;
        queueB = temp;
    }

    /**
     * 删除最后入队的的元素
     */
    public int pop() {
        return queueA.poll();
    }

    /**
     * 查看栈顶元素
     */
    public int top() {
        return queueA.peek();
    }

    /**
     * 只需要判断A队列是否空
     */
    public boolean empty() {
        return queueA.isEmpty();
    }
}

```