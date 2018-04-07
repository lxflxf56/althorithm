package WY;

import java.util.Scanner;

public class WY3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        StringBuilder builder=new StringBuilder(s);
        double sum=1;
        int c=builder.charAt(0);
        for (int i=1;i<builder.length();i++){
            if(builder.charAt(i)!=c){
                sum++;
            }
            c=builder.charAt(i);
        }
        double d=builder.length()/sum;
        System.out.println(String.format("%1$.2f", d));

    }
}
