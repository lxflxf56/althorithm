package WY;

import java.util.Scanner;

/*
*
* 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
牛博士给小易出了一个难题:
对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
*/
public class Wy5 {
    int a1,a2,a4;
    public void setArray(int [] array){
        a1=0;a2=0;a4=0;
        for (int i=0;i<array.length;i++){
            if (array[i]%4==0){
                a4++;
                continue;
            }else if (array[i]%2==0){
                a2++;
                continue;
            }else {
                a1++;
            }
        }
    }
    public void compute(){
        a4=a4-a1;
        if (a4<0){
            System.out.println("No");
        }else {
            System.out.println("Yes");
        }
    }

    public static int[] readArrInt(String str){
        String[] orStr=str.split(" ");
        int [] result=new int[orStr.length];
        for (int i=0;i<result.length;i++){
            result[i]=Integer.parseInt(orStr[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        Wy5 wy5=new Wy5();
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        for (int i=0;i<n;i++){
            int m=scanner.nextInt();
            scanner.nextLine();
            String str=scanner.nextLine();
            int[] tmp=readArrInt(str);
            wy5.setArray(tmp);
            wy5.compute();
        }
    }
}
