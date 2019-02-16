package beike;

import java.util.Scanner;

/*
小明有n(1≤2000）个美味的食物，他想卖掉它们来赚钱。这些食物放在一些箱子里，它们有些有趣的特性：
（1）这些食物被编号1~n，每一天小明可以从这排箱子的头部或者尾部取出食物去卖；
（2）这些食物放的越久，年龄越大，价值越大，食物i有一个初始的价值V(i);
（3）放了a天后，年龄为a，食物最终价值为V(i)xa。
给定每一个食物的初始价值V(i)，请求出小明卖掉它们后可以获得的最大价值，第一天出售的食物年龄为1，此后每增加一天食物的年龄就加1。

提示：
样例说明：小明出售这些食物（初始价值1,3,1,5,2）的顺序为：第一天卖掉第1个，第二天卖掉第5个，
第三天卖掉第2个，第四天卖掉第3个，第五天卖掉第4个，获得最大的价值1x1+2x3+3x3+4x1+5x5=43。

输入
第1行：一个整数n；
第i+l行：每行食物i的初始价值V(i)。
输出
1行：小明最终可以获得的最大价值。

输入示例：
    5
    1
    3
    1
    5
    2
输出示例：
    43

* */
public class Food {
    public static int maxFood(int [] value){
        int i=0,j=value.length-1;
        int a=1;
        int max=0;
        while (i<=j){
            if (value[i]>value[j]){
                max+=value[j]*a;
                j--;
            }else {
                max+=value[i]*a;
                i++;
            }
            a++;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [] v=new int[n];
        for (int i=0;i<n;i++){
            v[i]=scanner.nextInt();
        }
        int a=maxFood(v);
        System.out.println(a);
    }
}
