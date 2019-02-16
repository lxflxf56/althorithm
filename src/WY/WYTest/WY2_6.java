package WY.WYTest;

import java.util.Scanner;
//f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
//认真观察可得奇数直接加，偶数为1到n/2的奇数
/*
细节问题：
当n为偶数，就有n/2个奇数，根据等差数列求和公式 即(（首项+末项）*项数)/2,我们知道n/2个奇数和为((1+n-1)*n/2)/2,
即为(n/2) * (n/2),此时n为偶数，因此 (n/2) * (n/2) = ((n+1)/2)  *  ((n+1)/2)

当n为奇数，有(n+1)/2个奇数，此时奇数和为((n+1)/2)  *  ((n+1)/2)
因此两种情况可以用一个等式来总结
*/
public class WY2_6 {
    public static int fn(int n){
        int i=n;
        while (n>=1){
            if (n%2==1)
                return n;
            n=n/2;
        }
        return 1;
    }

    public static void compute(int n){
        int sum=0;
        for (int i=1;i<=n;i++){
            sum=sum+fn(i);
        }
        System.out.println(sum);
    }
    public static void compute2(int num){
        long sum=0;
        for(int i=num;i>0;i=i/2){
            long temp=(i+1)/2;
            sum+=temp*temp;
        }
        System.out.println(sum);
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        WY2_6.compute(n);
    }
}
