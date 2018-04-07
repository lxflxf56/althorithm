package WY;

import java.util.Scanner;

public class WY2 {
    public WY2(){

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        StringBuilder stringBuilder=new StringBuilder(str);
        String tmp=stringBuilder.reverse().toString();
        int a=Integer.parseInt(tmp);
        int b=Integer.parseInt(str);
        System.out.print(a+b);
    }
}
