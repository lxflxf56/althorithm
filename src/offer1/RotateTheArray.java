package offer1;//把一个数组最开始的若干个元素搬到数组的末尾，
// 我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，
// 输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
// 该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

public class RotateTheArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length==0){
            return 0;
        }
        int start=0,end=array.length-1,mid=0;
        while (start<end){
            mid=start+(end-start)/2;
            if (array[mid]>array[end]){
                start=mid+1;
            }else {
                if (array[mid]==array[end]){//如果mid与end的数值相同，则min在end的左边
                    end=end-1;
                }else {
                    end=mid;
                }
            }
        }
        return array[start];
    }


    public static void main(String[] args) {
        RotateTheArray rotateTheArray=new RotateTheArray();
        int a=rotateTheArray.minNumberInRotateArray(Tools.readArrInt("1 0 1 1 1"));
        System.out.println(a);
    }
}
