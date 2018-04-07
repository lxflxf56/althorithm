package WY;

import java.util.Scanner;

public class WY2_5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        StringBuilder builder1=new StringBuilder(a+"");
        StringBuilder builder2=new StringBuilder(b+"");
        String str=builder1.reverse().toString();
        a=Integer.parseInt(str);
        str=builder2.reverse().toString();
        b=Integer.parseInt(str);
        int c=a+b;
        builder1=new StringBuilder(c+"");
        builder1.reverse();
        c=Integer.parseInt(builder1.toString());
        System.out.println(c);
        //System.out.println(a+b);

    }
}
