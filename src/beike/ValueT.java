package beike;

import java.util.Scanner;

/*

玥玥带乔乔一起逃亡，现在有许多的东西要放到乔乔的包里面，但是包的大小有限，所以我们只能够在里面放入非常重要的物品。现在给出该种物品的数量、体积、价值的数值，希望你能够算出怎样能使背包的价值最大的组合方式，并且输出这个数值，乔乔会非常感谢你。
对于30%的数据 1
1
输入
第1行有2个整数，物品种数n和背包装载体积v；
第2行到i+1行每行3个整数，为第i种物品的数量m、体积w、价值s。
输出
仅包含一个整数，即为能拿到的最大的物品价值总和。
样例说明：选第一种一个，第二种两个，结果为3x1+5x2=13。
输入示例：
2 10
3 4 3
2 2 5
输出示例：
13

* */
//多重背包
//dp[j]表示在j空间时最大的s
//dp[j-w]+s>dp[j] -> dp[j]=dp[j-w]+s

public class ValueT {
    public int value(int v,int[][] item){
        int[] dp=new int[v+1];
        for (int i=0;i<item.length;i++){
            for (int k=1;k<=item[i][0];k++){//用几件
                int min=k*item[i][1];
                for (int j=v;j>min;j--){//该重量能达到的最小dp[j]
                    if (dp[j-item[i][1]]+item[i][2]>dp[j])
                        dp[j]=dp[j-item[i][1]]+item[i][2];
                }
            }
        }
        return dp[v];
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int v=scanner.nextInt();
        int[][] item=new int[n][3];
        for (int i=0;i<n;i++){
            item[i][0]=scanner.nextInt();
            item[i][1]=scanner.nextInt();
            item[i][2]=scanner.nextInt();
        }
        ValueT valueT=new ValueT();
        int a=valueT.value(v,item);
        System.out.println(a);
    }
}
