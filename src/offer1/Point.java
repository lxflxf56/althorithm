package offer1;

public class Point {
    public int x,y;
    public Point(int t1,int t2){
        x=t1;
        y=t2;
    }


    public boolean equals1(Point obj) {
        if (this.x==obj.x){
            if (this.y==obj.y){
                return true;
            }
        }
        return false;

    }
}
