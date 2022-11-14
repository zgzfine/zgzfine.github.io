---
title: LeetCode 763. 划分字母区间
date: 2022-11-14 16:40:39
tags:
categories:
- LeetCode
- 字符串
---

字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。

示例：

> 输入：S = "ababcbacadefegdehijhklij"
> 输出：[9,7,8]
> 解释：
> 划分结果为 "ababcbaca", "defegde", "hijhklij"。
> 每个字母最多出现在一个片段中。
> 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。


提示：

* S的长度在[1, 500]之间。
* S只包含小写字母 'a' 到 'z' 。

```
/**
 * 763. 划分字母区间
 */
public class LeetCode763 {

    /**
     * 题目需要找到合适的分组片段，那么就要统计每个字母出现的最远下标是多少
     * 在遍历字符串的过程中不断更新最远下标，一旦遍历到最远下标，做字符串的切割
     * 字符串的切割分组
     */
    public List<Integer> partitionLabels(String s) {
        int[] used = new int[26];//由于小写字母，所以一共只有26长度，其实也可以用map，只是数组效率要高一点
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            used[c - 'a'] = i;
        }
        List<Integer> rt = new ArrayList<>();
        int max = 0;//这里必须为0，因为下标起始从0开始，假如第一个元素的最大位置就是0
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            char c = s.charAt(i);
            int index = used[c - 'a'];
            max = Math.max(index, max);//优先更新目前区间最大
            if (i == max) {//如果遍历到目前的下标，那么结果集需要收集一下
                rt.add(count);
                max = 0;//需要重置一下
                count = 0;
            }
        }
        return rt;
    }

}

```
