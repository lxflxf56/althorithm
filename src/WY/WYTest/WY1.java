package WY.WYTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class WY1 {

    int n;
    ArrayList<Squ> squs=new ArrayList<>();
    int max=0;
    public WY1(int n,int[] x1,int[] x2,int [] y1,int [] y2){
        this.n=n;
        for (int i=0;i<n;i++){
            squs.add(new Squ(x1[i],x2[i],y1[i],y2[i]));
        }
        compute();
    }


    public int compute(){
        squs.sort(new Comparator<Squ>() {
            @Override
            public int compare(Squ o1, Squ o2) {

                return 0;
            }
        });
        return max;
    }

    public static int[] readArrInt(String str){
        String[] orStr=str.split(" ");
        int [] result=new int[orStr.length];
        for (int i=0;i<result.length;i++){
            result[i]=Integer.parseInt(orStr[i]);
        }
        return result;
    }
    public class Squ{
        int x1,x2,y1,y2;
        public Squ(int a,int b,int c,int d){
            x1=a;
            x2=b;
            y1=c;
            y2=d;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        String str=scanner.nextLine();
        int[] x1=readArrInt(str);
        str=scanner.nextLine();
        int[] y1=readArrInt(str);
        str=scanner.nextLine();
        int[] x2=readArrInt(str);
        str=scanner.nextLine();
        int[] y2=readArrInt(str);

    }
}
