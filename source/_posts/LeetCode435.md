---
title: LeetCode 435. 无重叠区间
date: 2022-11-14 13:42:17
tags:
categories:
- LeetCode
- 贪心算法
---

给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。


<!--more-->
示例 1:

> 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]  
> 输出: 1
> 解释: 移除 [1,3] 后，剩下的区间没有重叠。

示例 2:

> 输入: intervals = [ [1,2], [1,2], [1,2] ]
> 输出: 2
> 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。

示例 3:

> 输入: intervals = [ [1,2], [2,3] ]
> 输出: 0
> 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。


提示:

* 1 <= intervals.length <= 10^5
* intervals[i].length == 2
* -5 * 10^4<= starti< endi<= 5 * 10^4

```
/**
 * 这道题跟452有异曲同工之妙
 * 同样需要快排
 * 也可以像452一样，统计需要多少跟箭，然后用数组总量减去箭的数量就是重叠的数量
 */
public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length <= 1) {
        return 0;
    }
    Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
    int rt = 1;
    for (int i = 1; i < intervals.length; i++) {
        //统计重叠区间就跟统计箭是一个道理，这里按题目的意思，等于也算是同一个区间
        if (intervals[i][0] >= intervals[i - 1][1]) {
            rt++;
        } else {
            intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
        }
    }
    return intervals.length - rt;//相减的结果就是重叠的数量
}
```

