package JD;

import java.util.Scanner;

public class JD1_3 {
    public JD1_3(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        /*
        while (in.hasNextInt()) {//注意while处理多个case
            int m=in.nextInt();
            find(m);
        }*/
        in.nextLine();
        for (int i=0;i<n;i++){
            long m=in.nextLong();
            find(m);
        }
    }

    public void find(long m){
            if (m%2==1){
                System.out.println("No");
                return;
            }
            int now=1;
            while (m%2!=1){
                now=now*2;
                m=m/2;
            }

            System.out.println(m+" "+now);
    }




    public static void main(String[] args) {
        JD1_3 jd1_2=new JD1_3();
    }
}
