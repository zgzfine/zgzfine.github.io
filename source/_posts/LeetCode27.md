---
title: LeetCode 27. 移除元素
date: 2022-10-03 00:51:08
tags:
---

> 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。  
> 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。  
> 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。  

<!--more-->

说明:

为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

> // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝  
> int len = removeElement(nums, val);  
>
> // 在函数里修改输入数组对于调用者是可见的。  
> // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。  
> for (int i = 0; i < len; i++) {  
> print(nums[i]);  
> }  

~~~
/**
 * 可以使用双指针，匹配 l 针当前值是否等于 val ，相等就将 r 指针的值赋给 l，r指针往左移动一个，l 指针往右移动一格
 * 如果r指针的值等于 val，r指针左移动
 * 直到 l，r 指针相遇，程序结束，输出l-1指针的值，就是现在数组的长度(l多走了一格)
 */
public int removeElement(int[] nums, int val) {
    //定义左右指针
    int l = 0;
    int r = nums.length - 1;
    while (l < r) {
        //左边指针
        while (nums[l] == val && l < r) {
            //右指针移动到不是val的位置
            while (nums[r] == val && l < r) {
                r--;
            }
            //左右指针值交换
//                swap(nums[l], nums[r]);
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        l++;
    }
    return l - 1;
}
~~~

~~~
/**
 * 快慢指针，快指针会跳过值等于val的元素，不等于val值的元素会赋给慢指针的位置，当快指针到达数组底部，慢指针的位置就是数组的长度
 *
 * @param nums
 * @param val
 * @return
 */
public int fastShowPoint(int[] nums, int val) {
    int show = 0;
    for (int fast = 0; fast < nums.length; fast++) {
        if (nums[fast] != val) {
            //当快指针的值不等于val，则赋给慢指针
            nums[show] = nums[fast];
            show++;//分开两步，思路清晰
        }
    }
    return show;
}
~~~