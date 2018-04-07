package offer1;

import java.util.ArrayList;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
// 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
public class reOrderArrayT {
    ArrayList<Integer> oddNumber=new ArrayList<>();
    ArrayList<Integer> evenNumber=new ArrayList<>();
    public void reOrderArray(int [] array) {
        for (int tmp : array) {
            if (tmp % 2 == 1) {
                oddNumber.add(tmp);
            } else {
                evenNumber.add(tmp);
            }
        }

        for(int i=0;i<oddNumber.size();i++){
            array[i]=oddNumber.get(i);
        }
        int i=oddNumber.size();
        for (int tmp:evenNumber){
            array[i]=tmp;
            i++;
        }
    }
}
