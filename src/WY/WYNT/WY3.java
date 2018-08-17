package WY.WYNT;

import java.util.Scanner;

public class WY3 {
    public static void compute(StringBuilder s,int num,int m){
        String now=s.toString();
        int count=1;
        int z=0;
        while (true){
            if (z==m){
                System.out.println(-1);
                return;
            }
            StringBuilder builder=new StringBuilder(now);
            int k=findLast(builder);
            if (count==num){
                System.out.println(builder.toString());
                return;
            }
            for (int i=k;i<builder.length()-1;i++){
                if (count==num){
                    System.out.println(builder.toString());
                    return;
                }
                builder.setCharAt(i,'z');
                builder.setCharAt(i+1,'a');
                count++;
            }
            builder=new StringBuilder(now);
            builder.deleteCharAt(builder.length()-1);
            builder.insert(0,'z');
            now=builder.toString();
            count++;
            z++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int k=scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<n;i++){
            builder.append("a");
        }
        for (int i=0;i<m;i++){
            builder.append("z");
        }
        compute(builder,k,m);


    }
    public static int findLast(StringBuilder s){
        int k=-1;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='a'){
                k=i;
            }
        }
        return k;
    }

}
