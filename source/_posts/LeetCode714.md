---
title: LeetCode 714. 买卖股票的最佳时机含手续费
date: 2022-11-15 15:33:34
tags:
categories:
- LeetCode
- 贪心算法
---

给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；整数fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。


<!--more-->
示例 1：

> 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
> 输出：8
> 解释：能够达到的最大利润:  
> 在此处买入prices[0] = 1
> 在此处卖出 prices[3] = 8
> 在此处买入 prices[4] = 4
> 在此处卖出 prices[5] = 9
> 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8
示例 2：

> 输入：prices = [1,3,7,5,10,3], fee = 3
> 输出：6


提示：

* 1 <= prices.length <= 5 * 10^4
* 1 <= prices[i] < 5 * 10^4
* 0 <= fee < 5 * 10^4

PS:在买卖股票，可以每次区间上升获得收益的时候统计一次收益，再计算下区间点，这就相当于持有股票不作买卖
```
public class LeetCode714 {

    /**
     * 股票没有卖出之前，不能买入，多次买卖需要计算手续费
     * 所以需要在最低点的时候买入，在最高点的时候卖出，只要盈利，就可以继续重复统计（在一个区间盈利就可以了）
     */
    public int maxProfit(int[] prices, int fee) {
        int minPrice = prices[0];
        int maxCount = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] > minPrice + fee) {//只要盈利就需要统计收入
                maxCount = maxCount + prices[i] - minPrice - fee;
                //收获利润的这一天并不是收获利润区间里的最后一天（不是真正的卖出，相当于持有股票），所以后面要继续收获利润,这个是关键
                minPrice = prices[i]-fee;//为什么要减去fee，而不是加上fee，就是因为前面已经减了一个fee，在一个区间里，只需要减去一次fee
            }
        }
        return maxCount;
    }
}


```