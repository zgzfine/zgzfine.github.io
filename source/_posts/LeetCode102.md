---
title: LeetCode 102. 二叉树的层序遍历
date: 2022-10-18 10:01:25
tags:
categories:
- LeetCode
- 二叉树
---

> 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
> ![](../images/leetcode102/tree1.jpg)
> 
<!--more-->

示例 1：  
输入：root = [3,9,20,null,null,15,7]  
输出：[[3],[9,20],[15,7]]  

示例 2：  
输入：root = [1]  
输出：[[1]]  

示例 3：  
输入：root = []  
输出：[]  

提示：  

树中节点数目在范围 [0, 2000] 内  
-1000 <= Node.val <= 1000  

**Ps**：虽然题目说层序遍历，但是实际上也可以使用深度遍历，结果在收集结果集

```
/**
 * BFS
 * 层序遍历使用队列实现
 */
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    if (root == null) {
        return lists;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        List<Integer> item = new ArrayList<>();
        int size = queue.size();//队列参数会变化，所以size需要提取出来
        for (int i = 0; i < size; i++) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                item.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        lists.add(item);
    }
    return lists;
}

/**
 * 深度遍历 使用递归
 * 递归三要素
 * 1、确立好入参、出参
 * 2、确立好终止条件
 * 3、确立好递归调用函数
 */
public List<List<Integer>> dfs(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    dfsPass(result, root, 0);
    return result;
}

/**
 * 递归
 * @param result 确立结果
 * @param root   树当前节点
 * @param deepth 深度
 */
public static void dfsPass(List<List<Integer>> result, TreeNode root, int deepth) {
    if (root == null) {//结束条件
        return;
    }
    deepth++;//元素不为空，这里增加1
    if (result.size() < deepth) {
        List<Integer> item = new ArrayList<>();//结果集需要加1
        result.add(item);
    }
    result.get(deepth - 1).add(root.val);//添加当前元素
    dfsPass(result, root.left, deepth);//深度前面已经+1，这里无序再加
    dfsPass(result, root.right, deepth);
}

```