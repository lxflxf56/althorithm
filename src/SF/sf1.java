package SF;

import java.util.Scanner;

public class sf1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        int[] a=readArrInt(scanner.nextLine()," ");
        int[] b=readArrInt(scanner.nextLine()," ");
        int sum=0;
        int[] recordA=new int[n];
        int[] recordB=new int[n];
        for (int i=0;i<n;i++){
            recordA[a[i]]=i;
            recordB[b[i]]=i;
        }
        for (int i=n-1;i>=0;i--){
            /*
            int nowB=b[i];
            int nowAStation=record[b[i]];
            for (int j=0;j<nowAStation;j++){
                int nowA=a[i];
                if (recordB[nowA]<i){

                }
            }*/
            int nowAStation=recordA[b[i]];
            for (int j=i-1;j>=0;j--){
                int nowB=b[j];
                /*
                for (int k=0;k<nowAStation;k++){
                    recordA[nowB]
                }*/
                if (recordA[nowB]>nowAStation){
                    sum++;
                }

            }
        }
        System.out.println(sum);

    }
    public static int[] readArrInt(String str,String sp){
        String[] orStr=str.split(sp);
        int [] result=new int[orStr.length];
        for (int i=0;i<result.length;i++){
            result[i]=Integer.parseInt(orStr[i]);
        }
        return result;
    }
}
