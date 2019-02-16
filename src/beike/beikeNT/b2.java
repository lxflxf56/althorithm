package beike.beikeNT;

import java.util.Arrays;
import java.util.Scanner;

public class b2 {

    public void Prim(int n,int[][] c){
        int res = 0;
        int[] lowcost=new int[NUM];
        int[] closest=new int[NUM];
        boolean[] s = new boolean[NUM];
        Arrays.fill(s,false);
        for (int i = 1; i <= n; i++)
        {
            lowcost[i] = c[1][i];
            closest[i] = 1;
            s[i] = false;
        }
        s[1] = true;
        for (int i = 1; i<n; i++)
        {
            int  min = Integer.MAX_VALUE;
            int	 j = 1;
            for (int k = 2; k <= n; k++)
                if ((lowcost[k]<min) && (!s[k]))
                {
                    min = lowcost[k];
                    j = k;
                }
            res += Math.max(h[closest[j]], h[j]);
            s[j] = true;
            for (int k = 2; k <= n; k++)
                if ((c[j][k]<lowcost[k]) && (!s[k]))
                {
                    lowcost[k] = c[j][k];
                    closest[k] = j;
                }
        }
        System.out.println(res);
    }




    int[] h;
    int[][] c;
    int NUM=10000;
    public b2(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        h=new int[n+1];
        for(int i=0;i<n;i++){
            h[i]=scanner.nextInt();
        }
        c=new int[n+1][n+1];
        for (int i=0;i<=n;i++){
            Arrays.fill(c[i],Integer.MAX_VALUE);
        }
        for (int i = 1; i<= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                int edge = Math.max(h[i], h[j]);
                c[i][j] = edge;
                c[j][i] = edge;
            }
        }
        Prim(n,c);
        System.out.println();
    }
    public static void main(String[] args) {
            new b2();
    }

}
