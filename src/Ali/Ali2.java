package Ali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
*

阿里巴巴客服管理员管理着n个客服小组，他需要为每一组安排客服24小时值班。为简单起见，假设每组只有2个客服，一天只需要1个客服上班，并且一些客服由于某些原因不能在同一天上班。

我们已经对客服进行了编号，第i（i>=1&&i<=n）个组的客服编号为2*i-1和2*i。并且知道了m种如下约束关系：客服编号a和客服编号b不能一起上班。

管理员需要聪明的你帮忙判断今天是否存在可行的方案，既满足m条约束关系，又能让每个组都有1个客服上班。

输入：n(代表有n个组）

m(m条约束关系），接下来会有m行
a,b(代表a，b两位客服标号不能同时上班)

输出：判断有没有可行方案：如果不可行输出no；如果可行输出yes



举例：

输入：
4
3
1,4
2,3
7,3

输出：yes

* */
public class Ali2 {
    ArrayList<int[]> arrayList=new ArrayList<>();
    boolean[] flag;
    boolean[] set;
    boolean end=false;

    Ali2(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        int m= scanner.nextInt();
        scanner.nextLine();

        for (int i=0;i<m;i++){
            int[] ints = readArrFloat(scanner.nextLine());
            arrayList.add(ints);
        }
        flag=new boolean[n*2];
        set=new boolean[n];
        System.out.println("Yes");
    }

    public void setb(int i){
        if (end||i==arrayList.size()){//结束
            if (check(flag)&&!end){
                end=true;
                System.out.println("Yes");
            }
            return;
        }
        int[] ints = arrayList.get(i);
        /*
        if (!set[ints[0]/2]&&!set[ints[1]/2]){
            set[ints[0]/2]=true;
            set[ints[1]/2]=true;

            set[ints[0]/2]=false;
            set[ints[1]/2]=false;
        }*/
        /*
        if (!set[ints[0]/2]){
            set[]
        }*/



    }


    public static void main(String args[]){
        //System.out.println();
        //Ali2 ali2=new Ali2();




    }

    public static boolean check(boolean[] flag){
        for (int i=0;i<flag.length;i=i+2){
            if (flag[i]==true&&flag[i+1]==true){
                return false;
            }
        }
        return true;
    }

    public static int[] readArrFloat(String str){
        String[] orStr=str.split(",");
        int [] result=new int[orStr.length];
        for (int i=0;i<result.length;i++){
            result[i]=Integer.parseInt(orStr[i]);
        }
        return result;
    }
}
