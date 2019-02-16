package PDD;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ppd4 {
    public static void search(Set set,boolean[][] ch,int[] asd,int num){
        if (num<0){
            System.out.println("-");
            return;
        }
        for (int i=num;i<asd.length;i++){
            int[] tmp=asd.clone();
            for (int j=0;j<26;j++){
                if (ch[i][j]){
                    String s=crete(tmp);
                    if (set.add(s)){
                        System.out.println(s);
                        return;
                    }
                }
            }
        }
        search(set,ch,asd,num-1);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        Set<String> set=new HashSet();
        scanner.nextLine();
        boolean[][] ch=new boolean[l][26] ;//26
        for (int i=0;i<n;i++){
            String s = scanner.nextLine();
            set.add(s);
            for (int j=0;j<s.length();j++){
                char d=s.charAt(j);
                int e=d-65;
                ch[j][e]=true;
            }
        }
        StringBuilder builder=new StringBuilder();

        int[] asd=new int[l];

        for (int i=0;i<l;i++){
            for (int j=0;j<26;j++){
                if (ch[i][j]){
                    asd[i]=j;
                    break;
                }
            }
        }
        String s=crete(asd);
           if (set.add(s)){
                System.out.println(s);
                return;
           }
        search(set,ch,asd,l-1);
        //System.out.println();
    }
    public static String crete(int[] asd){
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<asd.length;i++){
            char d=(char)(asd[i]+65);
            builder.append(d);
        }
        return builder.toString();
    }
}
