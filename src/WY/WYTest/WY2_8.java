package WY.WYTest;

import java.util.Scanner;

public class WY2_8 {
    public static int[] readArrInt(String str){
        String[] orStr=str.split(" ");
        int [] result=new int[orStr.length];
        for (int i=0;i<result.length;i++){
            result[i]=Integer.parseInt(orStr[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        int[] tmp=readArrInt(str);
        int b=(tmp[1]+tmp[3])/2;
        int a=tmp[0]+b;
        int c=tmp[3]-b;
        if (a>=0&&b>=0&&c>=0&&tmp[2]==a+b){
            System.out.println(a+" "+b+" "+c);
        }else {
            System.out.println("No");
        }
    }
}
