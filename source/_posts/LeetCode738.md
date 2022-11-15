---
title: LeetCode 738. 单调递增的数字
date: 2022-11-15 14:12:56
tags:
categories:
- LeetCode
- 贪心算法
---

当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。

给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。

<!--more-->
示例 1:

* 输入: n = 10
* 输出: 9

示例 2:

* 输入: n = 1234
* 输出: 1234

示例 3:

* 输入: n = 332
* 输出: 299


提示:
* 0 <= n <= 10^9

```

/**
 * 738. 单调递增的数字
 */
public class LeetCode738 {

    /**
     * 单调递增
     * 判断数字的单调最大，一般来说还是转成字符串容易处理
     * 字符串从右边开始遍历，假如 s[i-1]>s[i]当前不是递增，那么就将当前的值赋9，s[i-1]-1(注意避免负数)
     * 最后需要有一个for循环做9的赋值，需要是考虑到 100 这种情况
     */
    public int monotoneIncreasingDigits(int n) {
        String[] s = (n + "").split("");
        int start = s.length;
        for (int i = s.length - 1; i > 0; i--) {
            if (Integer.parseInt(s[i - 1]) > Integer.parseInt(s[i])) {
                s[i - 1] = String.valueOf(Integer.parseInt(s[i - 1]) - 1);
                start = i;
            }
        }
        for (int i = start; i < s.length; i++) {
            s[i] = "9";
        }
        return Integer.parseInt(String.join("", s));
    }

}
```
