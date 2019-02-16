package beike;

import java.util.Arrays;
import java.util.Scanner;

/*
*


    题目描述

　　小明喜欢在火车旅行的时候用手机听音乐，他有N首歌在手机里，在整个火车途中，他可以听P首歌，所以他想产生一个播放表产生P首歌曲，这个播放表的规则是：
　　(1)每首歌都要至少被播放一次
　　(2)在两首一样的歌中间，至少有M首其他的歌
小明在想有多少种不同的播放表可以产生，那么给你N,M,P，你来算一下，输出结果取1000000007的余数

    输入

　　输入N,M,P
　　N范围在1到100
　　M范围在0到N
　　P范围在N到100

    输出

　　输出结果mod 1000000007的余数
输入示例：
1 0 3
输出示例：
1

* */
//记录到了第i个位置，已经用了j种颜色的方案数，我们不需要考虑第i个位置要放哪种歌，而是考虑能放几种不同种类的歌。记忆化搜索即可。
public class MusicT {
    public static final int mod=1000000007;
    private int n,m,p;
    public  int music(int n,int m,int p){
        int[][] arr=new int[n+2][n+2];
        this.n=n;
        this.p=p;
        this.m=m;
        for (int i=0;i<arr.length;i++){
            Arrays.fill(arr[i],-1);
        }
        return dfs(arr,0,0);
    }
    public  int dfs(int [][] dp,int i,int j){
        if (dp[i][j]!=-1)
            return dp[i][j];
        if (i==p) {
            if (j==n){dp[i][j]=1;return 1;}
            else{dp[i][j]=0;return 0;}
        }
        dp[i][j]=0;
        if (j>m)
            dp[i][j]=dfs(dp,i+1,j)*(j-m);
        if (j<n)
            dp[i][j]+=dfs(dp,i+1,j+1)*(n-j);
        if (dp[i][j]>=mod)
            dp[i][j]%=mod;
        return dp[i][j];
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int P=scanner.nextInt();
        MusicT musicT=new MusicT();
        int a=musicT.music(N,M,P);
        System.out.println(a);
    }
}
