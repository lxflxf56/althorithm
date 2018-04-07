package offer2;

public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int tmp=array[0];
        int count=0;
        for (int i=1;i<array.length;i++){
            if (tmp==array[i]){
                count++;
            }else {
                count--;
            }
            if (count<0){
                count=0;
                tmp=array[i];
            }
        }

        count=0;
        for (int i=0;i<array.length;i++){
            if (tmp==array[i]){
                count++;
            }
        }
        if (count>array.length/2){
            return tmp;
        }else {
            return 0;
        }

    }
}
