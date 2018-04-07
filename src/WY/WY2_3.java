package WY;

import java.util.ArrayList;
import java.util.Scanner;
/*
*
*小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，
即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
例如：
N = 4，M = 24：
4->6->8->12->18->24
于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板

动态规划
dp[steps]为可不可达，不可达为max，可达记次数
从第一步开始算是否可达，并记录更新dp，获得最后d[steps-1]
时间复杂度为O(N*logN)

* */
public class WY2_3 {
    boolean end=true;
    int n,m;

    public void setM(int n,int m) {
        this.m = m;
        this.n = n;
        compoute(n,0);
    }

    // 思想：动态规划
    public static int leastJumpTime(int n, int m) {
        if (m == n) {
            return 0;
        }
        int steps = m - n + 1;// 算上了起点和终点
        int[] dp = new int[steps];// 规划的量：到达 每个位置需要的最小步数
        dp[0] = 0; // 起点
        for (int i = 1; i < steps; i++) {
            dp[i] = Integer.MAX_VALUE; // 初始化 表示后续位置都不能到达
        }
        for (int i = 0; i < steps; i++) {
            // 0对应n石板 ；steps - 1 = m-n对应m石板
            if (dp[i] == Integer.MAX_VALUE) { // 该位置不能像前走
                continue;
            }
            ArrayList<Integer> list = getAppNums(i + n); // i+n才是石板号
            for (int j = 0; j < list.size(); j++) {
                int x = list.get(j);
                if (i + n + x <= m) {
                    dp[i + x] = Math.min(dp[i + x], dp[i] + 1);
                }
            }
        }
        if (dp[steps - 1] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[steps - 1];
        }
    }

    // 求因数 时间复杂度较低
    public static ArrayList<Integer> getAppNums(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }
        return list;
    }

    public  void compoute(int n, int num){//递归超时
        if (n==m){
            end=false;
            System.out.println(num);
            return;
        }
        for (int i=2;i<n&end;i++){
            if (n%i==0){
                compoute(n+n/i,num+1);
            }
        }
    }
    public static void main(String[] args) {
        WY2_3 wy2_3=new WY2_3();
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        //wy2_3.setM(n,m);
        System.out.println("!!");
        int tmp=WY2_3.leastJumpTime(n,m);
        System.out.println(tmp);
    }
}
