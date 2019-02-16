package WY.WYTest;

import java.util.Scanner;

public class WY2_7 {
    int n;
    boolean end=false;
    public WY2_7(int n){
        this.n=n;
        sub(n,0);
        if (!end){
            System.out.println(-1);
        }
    }

    public void sub(int nowN,int num){
        if (end||nowN<0){
            return;
        }
        if (nowN==0){
            end=true;
            System.out.println(num);
            return;
        }
        sub(nowN-8,num+1);
        sub(nowN-6,num+1);

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        if (n%2==1){
            System.out.println(-1);
            return;
        }
        WY2_7 wy2_7=new WY2_7(n);


    }
}
