package util;

public class Point {
    public int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public static Point goLeft(Point point){
        return new Point(point.x-1,point.y);
    }

    public static  Point goRight(Point point){
        return new Point(point.x+1,point.y);
    }
    public static  Point goUp(Point point){
        return new Point(point.x,point.y-1);
    }
    public static  Point goDown(Point point){
        return new Point(point.x,point.y+1);
    }

    public static Point go(Point point,int x){
        switch (x){
            case 0:
                return goLeft(point);
            case 1:
                return goRight(point);
            case 2:
                return goUp(point);
            case 3:
                return goDown(point);
            default:
                return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public static int getMatrix(int[][] matrix, Point point){
        return matrix[point.x][point.y];
    }

    public static void setMatrix(int[][] matrix,Point point,int num){
        matrix[point.x][point.y]=num;
    }

    public static boolean check(Point point,int maxX,int maxY){
        if (point.x<0||point.y<0||point.y>maxY||maxX<point.x){
            return false;
        }
        return true;
    }
}
