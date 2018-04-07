package offer1;//我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
// 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

public class RectCoverS {
    public static int RectCover(int target) {
        if (target<=2){
            return target;
        }else
            return RectCover(target-1)+RectCover(target-2);
    }


    public static int RectCover(int target,int m){
        if (target<=m){
            return target;
        }else {
            int tmp=0;
            for (int i=1;i<=m;i++){
                tmp=tmp+RectCover(target-i,m);
            }
            return tmp;
        }
    }

    public static void main(String[] args) {
               int a= RectCover(20);
               System.out.println(a);
               int b=RectCover(20,3);
                System.out.println(b);
    }


}
