package WY.WYTest;

import java.util.Scanner;

public class WY1_2 {
    int n;
    int n2;
    int sum;
    public WY1_2(int n){
        this.n=n;
        n2=(int)Math.sqrt(n);
        System.out.println(compute());
    }

    public int compute(){
        sum=0;
        for (int i=0;i<=n2/+1;i++){
           forA(i);
        }
        return sum;
    }
    public void forA(int i){
        /*
        for (int j=n2;j>=i;j--){
            if (i==0||j==0){
                if (i*i+j*j==n){
                    sum=sum+4;
                    return;
                }
            }else if (i*i+j*j==n){
                sum=sum+8;
                return;
            }
        }*/
        for (int j=n2;j>=i;j--){
            if (i*i+j*j==n){
                if (i==0){
                    sum=sum+4;
                }else if (i==j){
                    sum=sum+4;
                }else {
                    sum=sum+8;
                }
                return;
            }
        }

    }




    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        WY1_2 wy12=new WY1_2(n);
    }
}
