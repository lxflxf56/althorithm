package AQiYi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class a2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int P=scanner.nextInt();
        int[] nums=new int[N];
        for (int i=0;i<N;i++){
            nums[i]=scanner.nextInt();
        }
        scanner.nextLine();
        for (int i=0;i<M;i++){
            String[] s = scanner.nextLine().split(" ");
            int tmp=Integer.parseInt(s[1])-1;
            if (s[0].equals("A")){
                nums[tmp]++;
            }else {
                nums[tmp]--;
            }
        }


        ArrayList arrayList=new ArrayList();
        for (int i=0;i<nums.length;i++){
            arrayList.add(new int[]{nums[i],i+1});
        }
        arrayList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int[] a=(int[]) o1;
                int[] b=(int[]) o2;
                if (a[0]>b[0]){
                    return -1;
                }else if (a[0]==b[0]){
                    return 0;
                }
                return 1;
            }
        });
        for (int i=0;i<arrayList.size();i++){
            int[] tmp=(int[])arrayList.get(i);
            if (tmp[1]==P){
                System.out.println(i+1);
                return;
            }
        }
    }
}
