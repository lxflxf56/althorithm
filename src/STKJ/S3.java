package STKJ;

import java.util.Scanner;

public class S3 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        if (n<=0){
            System.out.println(0);
            return;
        }
        double svg=0;
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
            svg+=nums[i];
        }
        svg=svg/(double) n;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            if (nums[i]<svg){
                nums[i]+=k;
            }else {
                nums[i]-=k;
            }
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        System.out.println(max-min);
    }
}
