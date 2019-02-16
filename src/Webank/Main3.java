package Webank;

import java.util.Scanner;

public class Main3 {
    //public
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] point=new int[n][2];
        for (int i=0;i<n;i++){
            point[i][0]=scanner.nextInt();
            point[i][1]=scanner.nextInt();
        }
        int[][] dis=new int[n][n];//距离
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                dis[i][j]=(point[i][0]-point[j][0])*(point[i][0]-point[j][0])+(point[i][1]-point[j][1])*(point[i][1]-point[j][1]);
            }
        }
        boolean[] isStop=new boolean[n];

    }
}
