package AQiYi;

import java.util.Scanner;

public class a1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.length()!=6){
            System.out.println(0);
        }
        int[] nums=new int[6];
        for (int i=0;i<6;i++){
            nums[i]=Integer.parseInt(s.charAt(i)+"");
        }
        int sum1=nums[0]+nums[1]+nums[2];
        int sum2=nums[3]+nums[4]+nums[5];
        int[] change=new int[6];
        int sub=sum1-sum2;
        if (sub>0){
            for (int i=0;i<3;i++){
                change[i]=nums[i];
            }
            for (int i=3;i<6;i++){
                change[i]=9-nums[i];
            }
        }else {
            for (int i=3;i<6;i++){
                change[i]=nums[i];
            }
            for (int i=0;i<3;i++){
                change[i]=9-nums[i];
            }
        }
        int result=0;
        sub=Math.abs(sub);
        while (sub>0){
            int max=Integer.MIN_VALUE;
            int index=0;
            for (int i=0;i<6;i++){
                if (max<change[i]){
                    index=i;
                    max=change[i];
                }
            }
            sub=sub-max;
            change[index]=0;
            result++;
        }
        System.out.println(result);







    }
}
