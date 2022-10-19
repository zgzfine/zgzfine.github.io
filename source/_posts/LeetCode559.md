---
title: LeetCode 559. N 叉树的最大深度
date: 2022-10-19 12:00:42
tags:
- DFS
- BFS
categories:
- LeetCode
- 二叉树
---

> 给定一个 N 叉树，找到其最大深度。  
> 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。  

<!--more-->
N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。

示例 1：
![](../images/leetcode559/narytreeexample.png)


输入：root = [1,null,3,2,4,null,5,6]  
输出：3

示例 2：
![](../images/leetcode559/sample_4_964.png)


输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]  
输出：5  


提示：
树的深度不会超过1000 。  
树的节点数目位于 [0,10^4] 之间。  

```
 /**
 * DFS一般都是递归
 * 确立入参出参，结束条件，函数编写
 */
public int dfs(Node root, int depth) {
    if (root == null) {
        return depth;
    }
    depth++;//当前深度
    int curDp = depth;
    for (int i = 0; i < root.children.size(); i++) {
        Node node = root.children.get(i);
        int dfs = dfs(node, depth);//孩子节点的深度
        curDp = Math.max(curDp, dfs);//将最大值赋给cutDp
    }
    return curDp;
}

public int bfs(Node root) {
    if (root == null) {
        return 0;
    }
    Queue<Node> qe = new LinkedList<>();
    qe.offer(root);
    int depth = 0;
    while (!qe.isEmpty()) {
        int size = qe.size();
        depth++;
        while (size-- > 0) {
            Node node = qe.poll();
            //下面的操作是将子集入队列
            if (node.children != null && node.children.size() > 0) {
                for (int i = 0; i < node.children.size(); i++) {
                    if (node.children.get(i) != null) {
                        qe.offer(node.children.get(i));//加入队列
                    }
                }
            }
        }
    }
    return depth;
}

```
