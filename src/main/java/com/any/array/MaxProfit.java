package com.any.array;

/**
 *  买卖股票的最佳时机 II
 *  给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2zsx1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxProfit {

    public static void main(String[] args) {

        int [] arr = new int[]{7,1,5,3,6,4};

        int profit = maxProfit(arr);
        System.out.println("profit = " + profit);

    }


    /**
     * 股票要挣钱，就要低买高卖。由于我们已经能够提前知道每一天股票的价格，那么只要判断出来后一天的价钱比前一天的高，
     * 那么我们就执行这次买卖操作，并记录获得的收益。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0){
            return 0;
        }

        int account = 0;
        for(int i = 0; i < prices.length -1; i++){
            if(prices[i] < prices[i+1]){
                int temp = prices[i+1] - prices[i];
                account += temp;
            }
        }
        return account;

    }


}
