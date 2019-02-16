package STKJ;

import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] A=new int[n];
        int[] B=new int[n];
        int max=Integer.MIN_VALUE;
        int index=0;
        for (int i=0;i<n;i++){
            A[i]=scanner.nextInt();
            B[i]=scanner.nextInt();
            if (max<A[i]){
                max=A[i];
                index=i;
            }
        }
        boolean[] statu=new boolean[n];//检查是否完全走完
        max=Integer.MIN_VALUE;
        while (index!=-1){//
            int sum=0;
            boolean[] st2=new boolean[n];
            while (!st2[index]){
                st2[index]=true;
                statu[index]=true;
                sum+=A[index];
                max=Math.max(max,sum);
                if (sum<0){
                    break;
                }
                index=B[index]-1;
            }
            index=check(statu);
        }
        System.out.println(max);

    }
    public static int check(boolean[] a){
        for (int i=0;i<a.length;i++){
            if (!a[i]){
                return i;
            }
        }
        return -1;
    }
}
