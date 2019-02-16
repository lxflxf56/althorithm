package PDD;

import java.util.Scanner;

public class pdd1 {
    public static void change(char[][] mat){
        for (int i=mat.length-1;i>=0;i--){
            for (int j=0;j<mat[0].length;j++){
                if (mat[i][j]=='o'){
                    dowm(mat,i,j);
                }
            }
        }
    }
    public static void dowm(char[][] mat,int i,int j){
        for (;(i<mat.length-1)&&(mat[i+1][j]=='.');i++){
            mat[i][j]='.';
            mat[i+1][j]='o';
        }
        if (i==mat.length-1){
            mat[i][j]='.';
        }

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] mat=new char[n][m];
        scanner.nextLine();
        for (int i=0;i<n;i++){
            String s=scanner.nextLine();
            for (int j=0;j<m;j++){
                mat[i][j]=s.charAt(j);
            }
        }
        change(mat);
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }




    }
}
