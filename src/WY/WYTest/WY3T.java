package WY.WYTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class WY3T {
        public WY3T(){
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            ArrayList<Skill> arrayList=new ArrayList<>();
            for (int i=0;i<n;i++){
                int d=scanner.nextInt();
                int p=scanner.nextInt();
                Skill skill=new Skill(p,d);
                arrayList.add(skill);
            }
            arrayList.sort(new Comparator<Skill>() {
                @Override
                public int compare(Skill o1, Skill o2) {
                    int d1=o1.d;
                    int d2=o2.d;
                    if (d1>d2){
                        return 1;
                    }else if (d1==d2){
                        return 0;
                    }else {
                        return -1;
                    }
                }
            });

            int[] max=new int[n];
            max[0]=arrayList.get(0).p;
            for (int i=1;i<n;i++){
                if (max[i-1]>arrayList.get(i).p){
                    max[i]=max[i-1];
                }else {
                    max[i]=arrayList.get(i).p;
                }
            }





            int[] a=new int[m];
            for (int i=0;i<m;i++){
                a[i]=scanner.nextInt();

                if (a[i]<arrayList.get(0).d){
                    System.out.println(0);
                    break;
                }
                for (int j=1;j<n;j++){
                    if (a[i]<arrayList.get(j).d){
                        System.out.println(max[j-1]);
                        break;
                    }else if (j==n-1){
                        System.out.println(max[j]);
                    }
                }
            }
        }

    public static void main(String[] args) {
            WY3T wy3=new WY3T();



    }


    public class Skill{
        int p;
        int d;
        public Skill(int p,int d){
            this.p=p;
            this.d=d;
        }
    }
}
