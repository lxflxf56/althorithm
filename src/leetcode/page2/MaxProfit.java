package leetcode.page2;

import offer1.Tools;


public class MaxProfit {
    /*
*  Say you have an array for which the i th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
* */
    public static int maxProfit1(int[] prices) {
        int buy1=Integer.MIN_VALUE,buy2=Integer.MIN_VALUE,sell1=0,sell2=0;
        for (int i=0;i<prices.length;i++){
            buy1=Math.max(buy1,-prices[i]);
            sell1=Math.max(sell1,buy1+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell2=Math.max(sell2,buy2+prices[i]);
        }
        return sell2;
    }

    /*

Say you have an array for which the i th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit.
You may complete as many transactions as you like
(ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). */

    //判断相邻是否递增，因为连续递增可以合起来看为一次买入卖出操作，所以统计所有递增量即可
    public static int maxProfit(int[] prices) {
        int sum=0;
        for(int i=0;i<prices.length-1;i++){
            if (prices[i]<prices[i+1]){
                sum+=prices[i+1]-prices[i];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] ints = Tools.readArrInt("2 1 4 5 2 9 7");
        System.out.println(MaxProfit.maxProfit(ints));

    }
}
