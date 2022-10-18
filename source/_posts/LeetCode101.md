---
title: LeetCode 101. 对称二叉树
date: 2022-10-18 17:36:25
tags:
categories:
- LeetCode
- 二叉树
---

>给你一个二叉树的根节点 root ， 检查它是否轴对称。
<!--more-->

示例 1：
![](../images/leetcode101/symtree1.jpg)

输入：root = [1,2,2,3,4,4,3]  
输出：true  

示例 2：
![](../images/leetcode101/symtree2.jpg)

输入：root = [1,2,2,null,3,null,3]  
输出：false  


提示：

树中节点数目在范围 [1, 1000] 内  
-100 <= Node.val <= 100  

> 这道题经验是简单题，我的天，实际上，还是挺绕的代码量也不少，但是明白原理之后，还好理解  

```
/**
 * 确立条件，既然是判断是否对称，因此需要两个比较的节点 ，定义 l，那么比较之后的结果是什么，当时就是返回值
 * <p>
 * 这里不要管 l，r是那棵树，那个节点，方正就是需正确比较是否对称的节点树，不然很容易绕进去
 */
public static boolean order(TreeNode l, TreeNode r) {
    if (l == null && r == null) {//l、r都是空，对称
        return true;
    } else if (l != null && r == null) {//l,不空，r空，不对称
        return false;
    } else if (l == null && r != null) {//l,空，r不空，不对称
        return false;
    } else if (l.val != r.val) {//l,r都不为空，但是值不等
        return false;
    }
    //值相等的情况下，比较左子树的左节点跟右子树的右节点
    boolean order = order(l.left, r.right);
    //比较左子树的右节点跟右子树的左节点
    boolean order1 = order(l.right, r.left);
    return order && order1;
}

/**
 * 方法二、使用迭代法
 * 使用队列实现，判断目前队列里面的size，把左子树，右子树入队，然后出队，对比一下即可
 */
public boolean isSymmetric2(TreeNode root) {
    if (root == null) {
        return true;
    }
    Queue<TreeNode> qe = new LinkedList<>();
    //由于判断左右子树是否对称，所以是左右子树入队
    qe.offer(root.left);
    qe.offer(root.right);
    while (!qe.isEmpty()) {
        TreeNode l = qe.poll();
        TreeNode r = qe.poll();
        if (l == null && r == null) {//l、r都是空，对称
            continue;//下一个循环
        } else if (l != null && r == null) {//l,不空，r空，不对称
            return false;
        } else if (l == null && r != null) {//l,空，r不空，不对称
            return false;
        } else if (l.val != r.val) {//l,r都不为空，但是值不等
            return false;
        }
        qe.offer(l.left);
        qe.offer(r.right);
        qe.offer(l.right);
        qe.offer(r.left);
    }
    return true;
}
```
