package beike.beikeNT;

import java.util.Arrays;
import java.util.Scanner;

public class b1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        //int[] arr=new int[s.length()];
        int[] arr=new int[14];
        for (int i=0;i<s.length();i++){
            if ('K'==s.charAt(i)){
                arr[13]++;
            }else if ('Q'==s.charAt(i)){
                arr[12]++;
            }else if ('J'==s.charAt(i)){
                arr[11]++;
            }else if ('T'==s.charAt(i)){
                arr[10]++;
            }else if ('A'==s.charAt(i)){
                arr[1]++;
            }else {
                int tmp=Integer.parseInt(s.charAt(i)+"");
                arr[tmp]++;
            }

        }
        int num=0;

        int i4=0;
        int i3=0;


        //
        boolean is=true;
        while (is){
            is=false;
            int count=0;
            for (int i=1;i<14;i++){
                count++;
                if (arr[i]==0){
                    if (count>=5){
                        dec(arr,i,count);
                        num++;
                        is=true;
                    }
                    count=0;
                }
            }
            if (count>=5){
                dec(arr,13,count);
                num++;
                is=true;
            }
        }
        //
        for (int i=1;i<14;i++){
            if (arr[i]==4){
                arr[i]-=4;
                i4++;
                num++;
            }
        }
        //
        for (int i=1;i<14;i++){
            if (arr[i]==3){
                arr[i]-=3;
                i3++;
                num++;
            }
        }
        for (int i=1;i<14;i++){
            if (arr[i]==2){
                arr[i]-=2;
                num++;
            }
        }
        //
        int sum=0;
        for (int i=1;i<14;i++){
            sum+=arr[i];
        }
        sum=sum-i3-i4*2;
        if (sum>0){
            num=sum+num;
        }
        System.out.println(num);
    }

    public static void dec(int[] arr,int j,int count){
        for (int i=0;i<count;i++){
            arr[j-i]--;
        }
    }
}
