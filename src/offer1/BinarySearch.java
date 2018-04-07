package offer1;

import java.util.Arrays;

//二分查找
public class BinarySearch {
    private int [] arrays;
    public  void sort(){
        Arrays.sort(arrays);
    }

    public void setArrays(int[] arrays) {
        this.arrays = arrays;
    }

    public int search2(int tag,int min,int max){

        if (min>max){
            return -1;
        }
        int mid=(min+max)/2;
        int tmp=arrays[mid];
        if (tmp==tag){
            return mid;
        }
        if (tmp<tag){
            min=mid+1;
        }else {
            max=mid-1;
        }
        tmp=search2(tag,min,max);
        return tmp;

    }

    public int search1(int tag){//循环
        int max=arrays.length-1,min=0;
        int mid;
        while (min<=max){
            mid=(max+min)/2;
            if (arrays[mid]==tag){
                return mid;
            }
            if (arrays[mid]>tag){
                max=mid-1;
            }else {
                min=mid+1;
            }
        }
        return -1;

    }

    public int getSize(){
        return arrays.length;
    }

    public static void main(String[] args) {
        BinarySearch search=new BinarySearch();
        search.setArrays(Tools.readArrInt("1 3 5 7 9 11 13"));
        System.out.print(search.search2(3,0,search.getSize()-1));

    }
}
