package WY;

import java.util.Scanner;

public class WY2_4 {
    public static void compute(int n){
        int sum=(int)Math.pow(3,n);
        int sub;
        if (n<3){
            sub=0;
        }else {
            sub=6;
            if (n>3){
                for (int i=0;i<n-2;i++){
                    sub=sub*3;
                }
            }
        }
        System.out.println(sum-sub);

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //int n=scanner.nextInt();
        WY2_4.compute(10);
    }
}
