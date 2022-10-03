---
title: LeetCode 54. 螺旋矩阵
date: 2022-10-04 00:16:32
tags:
---

> 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

<!--more--> 



> 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]  
> 输出：[1,2,3,6,9,8,7,4,5]
>
> 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
> 输出：[1,2,3,4,8,12,11,10,9,5,6,7]

~~~
/**
 * m行n列，所以矩阵中一共的元素为 m*n
 * 所以每输除一个元素，总值减-
 */
public List<Integer> spiralOrder(int[][] matrix) {
    //行 * 列 得出最大个数
    int mCount = matrix.length * matrix[0].length;
    List<Integer> list = new ArrayList<>(mCount);
    int i = 0;
    int j = 0;
    //行坐标的开始值为0
    int startx = 0;
    //纵坐标的开始值为0
    int starty = 0;
    int loop = 0;//从第一轮开始
    //循环的次数必须要同时少于行中点以及纵中点
    while (loop < matrix.length / 2 && loop < matrix[0].length / 2) {
        i = starty;
        j = startx;
        loop++;

        //从左上到右上
        for (; j < matrix[0].length - loop; j++) {
            list.add(matrix[i][j]);
        }
        //右上到右下
        for (; i < matrix.length - loop; i++) {
            list.add(matrix[i][j]);
        }
        //右下到左下
        for (; j > startx; j--) {
            list.add(matrix[i][j]);
        }
        //左下到左上
        for (; i > starty; i--) {
            list.add(matrix[i][j]);
        }
        starty++;
        startx++;
    }

    if (list.size() != mCount) {
        if (matrix[0].length / 2 > loop && matrix[0].length != 1) {
            //从左上到右上
            while (matrix[0].length - loop - startx > 0) {
                list.add(matrix[starty][startx++]);
            }
        } else {
            while (matrix.length - loop - starty > 0) {
                list.add(matrix[starty++][startx]);
            }
        }
    }
    return list;
}
~~~
