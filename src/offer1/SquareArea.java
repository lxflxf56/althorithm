package offer1;
/*
桌面上放了N个矩形，这N个矩形可能有互相覆盖的部分，求它们组成的图形的面积。

输入
输入第一行为一个数N（1≤N≤100），表示矩形的数量。下面N行，每行四个整数，分别表示每个矩形的左下角和右上角的坐标，坐标范围为–10^8到10^8之间的整数。

输出
输出只有一行，一个整数，表示图形的面积。

样例输入

3
1 1 4 3
2 -1 3 2
4 0 5 2

样例输出
10

二维离散优化，将图形在x轴上投影的点找出，
并且分析相邻两点间的距离（即图形的宽），
以及投影这段线的图形在y轴上的投影（即图形的高），ans+=d*h即可
*/

import java.util.Arrays;

public class SquareArea {
    private int n;
    private int sum;
    private int[][] square;//(x1,y1,x2,y2)
    private int [] x;//排序后的x
    private int [] y;//flag=1时的y的点
    private int [] flag;//x1到x2在方块内时设为1
    public SquareArea(int n1){

        sum=0;
        n=n1;
    }

    public void setSquare(int[][] square) {
        this.square = square;
    }


    private int computeH(int num){

        /*
        int h=0;
        Arrays.sort(y);
        for (int i=0;i<num-1;i++){
            for (int j=0;j<n;j++){
                int y1=y[i];
                int y2=y[i+1];
                if (square[i][1]<=y1&&square[i][3]>=y2){
                    h=h+y2-y1;
                    break;
                }
            }
        }
        return h;*/
        y=new int[num];
        int tmp=0;
        for (int i=0;i<n;i++){
            if (flag[i]==1){
                y[tmp]=square[i][1];
                y[tmp+1]=square[i][3];
                tmp=tmp+2;
            }
        }
        Arrays.sort(y);
        int h=0;
        for (int i=0;i<y.length-1;i++){
            int y1=y[i],y2=y[i+1];
            for (int j=0;j<n;j++){
                if (y1!=y2&&square[j][1]<=y1&&square[j][3]>=y2){
                    h=h+y2-y1;
                    break;
                }
            }
        }
        return h;



    }

    private int haveXIn(int x1,int x2){

        flag=new int[n];
        int h=0;
        int sumY=0;
        for (int i=0;i<n;i++){
            if (square[i][0]<=x1&&square[i][2]>=x2&&x1!=x2){
                flag[i]=1;
                sumY=sumY+2;
            }
        }
        if (sumY!=0){
            h=computeH(sumY);
        }
        return h;


    }

    private void sort(){
        x=new int[n*2];
        for (int i=0;i<n;i++){
            x[i*2]=square[i][0];
            x[i*2+1]=square[i][2];
        }
        Arrays.sort(x);
    }


    public int compute(){
        sort();
        for (int i=0;i<n*2-1;i++){
            int x1=x[i];
            int x2=x[i+1];
            if (x1!=x2)
                sum=sum+(x2-x1)*haveXIn(x1,x2);
        }
        return sum;
    }





    public static void main(String[] args) {
        SquareArea area=new SquareArea(3);
        area.setSquare(Tools.readLineInt(3,4));
        System.out.print(area.compute());

    }


}
