---
title: LeetCode 56. 合并区间
date: 2022-11-14 17:42:49
tags:
categories:
- LeetCode
- 贪心算法
---

以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。


<!--more-->

示例 1：

> 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
> 输出：[[1,6],[8,10],[15,18]]
> 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例2：

> 输入：intervals = [[1,4],[4,5]]
> 输出：[[1,5]]
> 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。


提示：

* 1 <= intervals.length <= 10^4
* intervals[i].length == 2
* 0 <= starti <= endi <= 10^4

```

/**
 * 56. 合并区间
 */
public class LeetCode56 {

    /**
     * 合并区间感觉还是简单点
     * 先按左边界升序
     * 然后在遍历的过程，不断收集右边界的最大值
     * 遇到不重叠的区间，重新数值重新清零
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new LinkedList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {//如果当前区间跟上区间重叠
                right = Math.max(intervals[i][1], right);//更新当前右边界为当前区间的最大值
            } else {//不重叠
                //收集当前区间 [left,intervals[i - 1][1]]
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);//给了一个长度为res.size()的宽度不限制的二维数组模板
    }
}

```
