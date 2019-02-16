package Zoom;

import java.util.Scanner;

public class Main {

    static int sum=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int sum=find(n);
        System.out.println(sum);

    }
    public static int find(int empty){
        if(empty<3){
            if (empty==2){//智障操作
                sum++;
                return 1;
            }
            return 0;
        }
        sum+=empty/3;
        empty=empty%3+empty/3;
        find(empty);
        return sum;
    }
}
