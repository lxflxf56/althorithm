package PDD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pdd2 {

    /*
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        BigDecimal a1=BigDecimal.valueOf((double)a);
        BigDecimal b1=BigDecimal.valueOf((double)b);
        BigDecimal divide = a1.divide(b1, 60,RoundingMode.HALF_UP);
        //double c=(double)a/(double)b;
        //String string = Double.toString(c);
        String string=divide.toString();
        //System.out.println(string);
        String[] split = string.split("\\.");
        StringBuilder builder=new StringBuilder(split[1]);
        int zero=builder.length();
        for (int i=builder.length()-1;i>=0;i--){
            if (builder.charAt(i)=='0'){
               zero--;
            }else {
                break;
            }
        }
        builder.delete(zero,builder.length());
        string=builder.toString();
        for (int i=0;i<string.length();i++){
            for (int j=i+1;j<string.length();j++){
                if (string.charAt(i)==string.charAt(j)){
                    if (check(string,i,j)){
                        System.out.println(i+" "+(j-i));
                        return;
                    }
                }
            }
        }
        System.out.println(string.length()+" 0");



        //System.out.println(string);
    }*/



     static void f(int a, int b){
        List t1 = new ArrayList();  //商
        List t2 = new ArrayList();  //余数

        int p = - 1;//循环节的起始位置
        while(true){
            t1.add(a/b);
            int x = a % b;
            if(x == 0) break;

            p = t2.indexOf(x);

            if(p >= 0) break;
            else
                t2.add(x);

            a = x*10;
        }
        //System.out.println(t1.size());
        //System.out.print(t1.get(0)+".");
        /*
        for(int i = 1; i < t1.size();i++){

            if(i == p + 1)System.out.print("[");
            System.out.print(t1.get(i));
        }
        if(p >= 0)
            System.out.println("]");*/
        System.out.println(t1);
         System.out.println(t2);

    }
    public static void main(String[] args) {
        f(5,4);
    }
    public static boolean check(String s,int k,int l){
        int zero=0;

        for (int i=0;i<l-k&&l+i<s.length();i++){
            if (s.charAt(i+k)!=s.charAt(l+i)){
                return false;
            }
            if (s.charAt(i+k)=='0'){
                zero++;
            }
        }
        if (zero==l-k){
            return false;
        }

        return true;
    }

}
