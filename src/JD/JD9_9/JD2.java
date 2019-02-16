package JD.JD9_9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class JD2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        ArrayList arrayList=new ArrayList();

        for (int i=0;i<n;i++){
            int[] arr=new int[3];
            arr[0]=scanner.nextInt();
            arr[1]=scanner.nextInt();
            arr[2]=scanner.nextInt();
            arrayList.add(arr);
        }

        arrayList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int[] a=(int[])o1;
                int[] b=(int[])o2;
                if (a[0]<b[0]){
                    return -1;
                }else if (a[0]==b[0]){
                    return 0;
                }
                return 1;
            }
        });
        int num=0;
        for (int i=0;i<n-1;i++){
            int[] a = (int[]) arrayList.get(i);
            for (int j=n-1;j>i;j--){
                int[] b=(int[]) arrayList.get(j);
                if (a[1]<b[1]&&a[2]<b[2]){
                    num++;
                    break;
                }
            }
        }

        System.out.println(num);
    }
}
