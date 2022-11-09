
/**
 * 376. 摆动序列
 */
public class LeetCode376 {

    /**
     * 这道题内容很多，说了半天，实际上它想要表达的意思是，获取这个弯曲曲线的峰值个数
     * 什么是峰值，可以理解最高峰，以及最低谷，再这个最高分以及最低谷的中间节点都可以删除
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int preDiff = 0;//前一个节点的差值
        int curDiff = 0;//当前节点的差值
        int result = 1;//右侧的点就是一个峰值，所以默认1
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];//计算当前是上升还是下降
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {//当前的趋势跟上一次的趋势不一致的时候，就是峰值
                result++;//峰值加1
                preDiff = curDiff;
            }
        }
        return result;
    }
}