package WY.WYNT;

import java.util.Scanner;

public class WY2 {

    public static void search(int num,int sum[],int start,int end){
        int middle=(start+end)/2;
        if (middle==0){
            if (0<num&&num<=sum[middle]){
                System.out.println(1);
                return;
            }
        }
        if (num>sum[middle-1]&&num<=sum[middle]){
            System.out.println(middle+1);
            return;
        }else {
            if (num<=sum[middle-1]){
                search(num,sum,start,middle);
            }else {
                search(num,sum,middle+1,end);
            }
        }

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int tmp=0;
        int[] sum=new int[n];
        for (int i=0;i<n;i++){
            tmp=tmp+scanner.nextInt();
            sum[i]=tmp;
        }
        int m=scanner.nextInt();
        for (int i=0;i<m;i++){
            search(scanner.nextInt(),sum,0,sum.length-1);
        }
    }
}
