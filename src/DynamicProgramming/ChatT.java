package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

/*
A和B是好友，他们经常在空闲时间聊天，A的空闲时间为[a1 ,b1 ],[a2 ,b2 ]..[ap ,bp ]。
B的空闲时间是[c1 +t,d1 +t]..[cq +t,dq +t],这里t为B的起床时间。
这些时间包括了边界点。B的起床时间为[l,r]的一个时刻。若一个起床时间能使两人在任一时刻聊天(区间有重合)，那么这个时间就是合适的，问有多少个合适的起床时间？

输入描述:

第一行数据四个整数：p,q,l,r（1≤p,q≤50,0≤l≤r≤1000)。接下来p行数据每一行有一对整数ai，bi(0≤aii+1>bi,ci+1>di



输出描述:

输出答案个数

示例1
输入

2 3 0 20
15 17
23 26
1 4
7 11
15 17

输出

20
* */
public class ChatT {
    public static void chat(ArrayList a,ArrayList b,int l,int r){
        int count=0;
        for (int i=l;i<=r;i++){
            if (isOK(a,b,i)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isOK(ArrayList A,ArrayList B,int t){
        for (int i=0;i<A.size();i++){
            int[] a=(int[]) A.get(i);
            for (int j=0;j<B.size();j++){
                int[] b=(int[]) B.get(j);
                if (b[0]+t<=a[1]&&b[1]+t>=a[0]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int p=scanner.nextInt();
        int q=scanner.nextInt();
        int l=scanner.nextInt();
        int r=scanner.nextInt();
        ArrayList A=new ArrayList();
        ArrayList B=new ArrayList();
        for (int i=0;i<p;i++){
            int[] tmp=new int[2];
            tmp[0]=scanner.nextInt();
            tmp[1]=scanner.nextInt();
            A.add(tmp);
        }
        for (int i=0;i<q;i++){
            int[] tmp=new int[2];
            tmp[0]=scanner.nextInt();
            tmp[1]=scanner.nextInt();
            B.add(tmp);
        }
        ChatT.chat(A,B,l,r);
    }
}
