---
title: LeetCode 860. 柠檬水找零
date: 2022-11-12 16:22:37
tags:
categories:
- LeetCode
- 贪心算法
---

在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

注意，一开始你手头没有任何零钱。

给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回true，否则返回 false。

<!--more-->
示例 1：

* 输入：bills = [5,5,5,10,20]  
* 输出：true
* 解释：
* 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
* 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
* 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
* 由于所有客户都得到了正确的找零，所以我们输出 true。


示例 2：

* 输入：bills = [5,5,10,10,20]
* 输出：false
* 解释：
* 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
* 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
* 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
* 由于不是每位顾客都得到了正确的找零，所以答案是 false。


提示：

* 1 <= bills.length <= 10^5
* bills[i]不是5就是10或是20

```
/**
 * 860. 柠檬水找零
 */
public class LeetCode860 {

    /**
     * 柠檬水就三种策略
     * 1、遇到5元，直接收取
     * 2、遇到十元，十元栏目+1，5元栏目减1
     * 3、遇到20元，十元栏目-1以及5元减1，或者5元栏目减去3;
     * 优先使用十元，在用5元，毕竟如果先用了5元的，可能条件2无法成立
     * 顺序遍历完即可
     */
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> item = new HashMap<>();
        //初始化各个栏目数量
        item.put(5, 0);
        item.put(10, 0);
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                item.put(5, item.get(5) + 1);
            } else if (bills[i] == 10) {
                if (item.get(5) == 0) {
                    return false;
                }
                item.put(5, item.get(5) - 1);
                item.put(10, item.get(10) + 1);
            } else if (bills[i] == 20) {
                if (item.get(10) > 0 && item.get(5) > 0) {//10栏目5栏目至少有一张
                    item.put(5, item.get(5) - 1);
                    item.put(10, item.get(10) - 1);
                } else if (item.get(5) >= 3) {//5栏目的剩余数量至少为3
                    item.put(5, item.get(5) - 3);
                } else//否则不符合条件
                    return false;
            }
        }
        return true;
    }
}

```
