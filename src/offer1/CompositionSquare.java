package offer1;/*描述
给出平面上一些点的坐标，统计由这些点可以组成多少个正方形。注意：正方形的边不一定平行于坐标轴。
输入
输入包括多组测试数据。每组的第一行是一个整数n (1 <= n <= 1000)，表示平面上点的数目，接下来n行，每行包括两个整数，
分别给出一个点在平面上的x坐标和y坐标。输入保证：平面上点的位置是两两不同的，而且坐标的绝对值都不大于20000。最后一组输入数据中n = 0，
这组数据表示输入的结束，不用进行处理。
输出
对每组输入数据，输出一行，表示这些点能够组成的正方形的数目。

样例输入
4
1 0
0 1
1 1
0 0
样例输出
1
a(x1,y1),b(x2,y2)
即ab向量为(x2-x1,y2-y1)
因为bc与ab为直角
bc(y2-y1,x2-x1)或-(y2-y1,x2-y1)


*/


import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CompositionSquare {
    int sum;
    int num;

    public HashMap<Integer, Point> hashMap;
    public CompositionSquare(){
        num=0;
        sum=0;
        hashMap=new HashMap<Integer, Point>();
    }
    public void addPoint(int[] point){
        hashMap.put(num,new Point(point[0],point[1]));
        num++;
    }




    public boolean havePoint(Point point){
        Iterator iter = hashMap.values().iterator();
        while (iter.hasNext()) {
            Point tmp = (Point)iter.next();
            if (point.equals1(tmp)){
                return true;
            }
        }
        return false;
    }


    public int compute(){
        Set<Integer> keySet=hashMap.keySet();
        Object[] keys=keySet.toArray();
        for (int i=0;i<keys.length-1;i++){
           for (int j=i+1;j<keys.length;j++){
               Point a=hashMap.get(keys[i]);
               Point b=hashMap.get(keys[j]);
               int uy=a.x-b.x;
               int ux=a.y-b.y;
               Point tmp=new Point(a.x+ux,a.y-uy);
               if(havePoint(tmp)){
                   tmp=new Point(b.x+ux,b.y-uy);
                   if (havePoint(tmp)){
                       sum++;
                   }
               }
               tmp=new Point(a.x-ux,a.y+uy);
               if(havePoint(tmp)){
                   tmp=new Point(b.x-ux,b.y+uy);
                   if (havePoint(tmp)){
                       sum++;
                   }
               }


           }
        }
        return sum/4;
    }


    public static void main(String[] args) {
        CompositionSquare square=new CompositionSquare();

        int n=9;
        int[][] p= Tools.readLineInt(n,2);
        for (int i=0;i<p.length;i++){
            square.addPoint(p[i]);
        }
        System.out.println(square.compute());
        Point tp=new Point(0,0);
        boolean t=square.havePoint(tp);
        System.out.println(t);
    }


}

