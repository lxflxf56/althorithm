package JD.JD9_9;

import java.util.*;

public class JD1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();

        for (int i=0;i<T;i++){
            int N=scanner.nextInt();//点数
            int M=scanner.nextInt();//边数
            boolean[][] pic=new boolean[N][N];
            for (int j=0;j<M;j++){
                int a=scanner.nextInt()-1;
                int b=scanner.nextInt()-1;
                pic[a][b]=true;
                pic[b][a]=true;
            }
            if (check(pic)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }




        }
    }
    public static boolean check(boolean[][] pic){
        int n=pic.length;
        boolean[] isCheck=new boolean[n];
        for (int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            if (!isCheck[i]){//没有添加
                isCheck[i]=true;
                set.add(i);
                for (int j=0;j<n;j++){
                    if (!pic[i][j]){
                        set.add(j);
                        isCheck[j]=true;
                    }
                }
                if (set.size()==1){
                    break;
                }
                //检查节点
                Iterator<Integer> iterator = set.iterator();

                for (; iterator.hasNext();) {
                    int next = iterator.next();
                    for(int k=0;k<n;k++){
                        if (pic[next][k]){
                            if (set.contains(k)){
                                return false;
                            }
                        }
                    }
                }

            }
        }
        return true;
    }
}
