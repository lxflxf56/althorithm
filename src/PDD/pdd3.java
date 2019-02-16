package PDD;

import java.util.Scanner;

public class pdd3 {
    public static int search(int hp,int na,int ba,int num){
        if (hp<=0){
            return num;
        }
        int a=search(hp-na,na,ba,num+1);
        int b=search(hp-ba,na,ba,num+2);
        return Math.min(a,b);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int hp = scanner.nextInt();
        int na=scanner.nextInt();
        int ba=scanner.nextInt();
        int result=search(hp,na,ba,0);
        System.out.println(result);
    }
}
