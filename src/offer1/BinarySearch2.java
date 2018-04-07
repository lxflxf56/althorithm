package offer1;

//二维数组二分
public class BinarySearch2 {
    public boolean Find(int target, int [][] array) {
        int n=array.length;
        int m=array[0].length;
        for (int i=0;i<n;i++){
            if (find1(target,array[i])){
                return true;
            }
        }
        return false;
    }
    public boolean find1(int target,int[] array){
        int min=0,max=array.length-1;
        int mid;
        while(min<=max){
            mid=(min+max)/2;
            if (target==array[mid]){
                return true;
            }
            if (target>array[mid]){
                min=mid+1;
            }else {
                max=mid-1;
            }
        }
        return false;
    }
}
