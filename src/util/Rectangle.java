package util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Rectangle {
    public int x1,x2,y1,y2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (x1 != rectangle.x1) return false;
        if (x2 != rectangle.x2) return false;
        if (y1 != rectangle.y1) return false;
        return y2 == rectangle.y2;
    }

    @Override
    public int hashCode() {
        int result = x1;
        result = 31 * result + x2;
        result = 31 * result + y1;
        result = 31 * result + y2;
        return result;
    }

    public Rectangle(int x1, int x2, int y1, int y2){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;

        this.y2=y2;
    }

    public static boolean isImpact1(Rectangle a1,Rectangle a2){//a2的左下角是否在a1里
        if (a1.x1<=a2.x1&&a1.x2<=a2.x2){
            if (a1.y1>=a2.x1&&a1.y2>=a2.x2){
                return true;
            }
        }
        return false;
    }

    public static boolean isImpact(Rectangle a1, Rectangle a2){//a1碰撞a2
        boolean x=false,y=false;
        if (a2.x1<=a1.x1&&a1.x1<=a2.x2){
            x=true;
        }else if (a2.x1<=a1.x2&&a1.x2<=a2.x2){
            x=true;
        }

        if (a2.y1<=a1.y1&&a1.y1<=a2.y2){
            y=true;
        }else if (a2.y1<=a1.y2&&a1.y2<=a2.y2){
            y=true;
        }

        return x&&y;


    }


    public static boolean isIn(Rectangle a1,Rectangle a2){//a1完全包含a2
        if (a1.x1<=a2.x1&&a1.x2<=a2.x2){
            if (a1.y1>=a2.y1&&a1.y2>=a2.y2){
                return true;
            }
        }
        return false;
    }

    public static int coverArea(ArrayList<Rectangle> arrayList){
        Set<Rectangle> set=new HashSet();
        return 0;
    }


    public static ArrayList<Rectangle> addArray(int[] a1,int[] a2,int[] b1,int[] b2){
        ArrayList<Rectangle> arrayList=new ArrayList<>();
        for (int i=0;i<a1.length;i++){
            Rectangle rectangle=new Rectangle(a1[i],a2[i],b1[i],b2[i]);
            arrayList.add(rectangle);
        }
        return arrayList;
    }

    public static ArrayList<Rectangle> sortListX1(ArrayList<Rectangle> arrayList){//优先级为x1>x2>y1>y2
        arrayList.sort(new Comparator<Rectangle>() {
            @Override
            public int compare(Rectangle o1, Rectangle o2) {
                if (o1.x1>o2.x1){
                    return 1;
                }
                else if (o1.x1==o2.x1){
                    if (o1.x2>o2.x2){
                        return 1;
                    }
                    else if (o1.x2==o2.x2){
                        if (o1.y1>o2.y1) {
                            return 1;
                        }
                        else if (o1.y1==o2.y1){
                            if (o1.y2>o2.y2){
                                return 1;
                            }else if (o1.y2==o2.y2){
                                return 0;
                            }else {
                                return -1;
                            }
                        }else {
                            return -1;
                        }
                    }else {
                        return -1;
                    }
                }else {
                    return -1;
                }

            }
        });
        return arrayList;
    }

    public Rectangle(){}
}
