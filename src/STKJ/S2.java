package STKJ;

import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        for (int i=0;i<n;i++){
            int N=scanner.nextInt();
            int K=scanner.nextInt();
            scanner.nextLine();
            char[][] pic=new char[N][K];
            for (int j=0;j<N;j++){
                String[] split = scanner.nextLine().split(" ");
                for (int k=0;k<K;k++){
                    pic[j][k]=split[k].charAt(0);
                }
            }
            System.out.println(check(pic));
        }

    }
    public static boolean check(char[][] pic){
        int n=pic.length;
        int k=pic[0].length;
        boolean[][] C=new boolean[n][k];
        boolean[][] M=new boolean[n][k];
        boolean[][] Y=new boolean[n][k];
        for (int i=0;i<n;i++){
            for (int j=0;j<k;j++){
                if ('B'==pic[i][j]){
                    C[i][j]=true;
                    M[i][j]=true;
                }else if ('R'==pic[i][j]){
                    M[i][j]=true;
                    Y[i][j]=true;
                }else if ('G'==pic[i][j]){
                    Y[i][j]=true;
                    C[i][j]=true;
                }else if ('b'==pic[i][j]){
                    M[i][j]=true;
                    C[i][j]=true;
                }else if ('C'==pic[i][j]){
                    C[i][j]=true;
                    Y[i][j]=true;
                }else if ('M'==pic[i][j]){
                    M[i][j]=true;
                }else if ('Y'==pic[i][j]){
                    Y[i][j]=true;
                }
            }
        }
        return checkColor(C)&&checkColor(M)&&checkColor(Y);
    }

    public static boolean checkColor(boolean[][] color){
        boolean[][] clone=color.clone();
        int sum=0;
        for (int i=0;i<color.length;i++){
            for (int j=0;j<color[0].length;j++){
                if (color[i][j]){
                    sum++;
                }
            }
        }
        if (sum%2==0){
            return true;
        }else {
            return false;
        }
    }

}
