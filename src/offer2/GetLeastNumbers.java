package offer2;
/*输入n个整数，找出其中最小的K个数。
例如输入4,5,1,6,2,7,3,8这8个数字，
则最小的4个数字是1,2,3,4,。*/
import offer1.Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GetLeastNumbers {
    ArrayList<Integer> arrayList=new ArrayList<>();
    int maxIndex;
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if (input.length<k||k<0){
            return arrayList;
        }
        for (int i=0;i<input.length;i++){
            if (arrayList.size()<k){
                arrayList.add(input[i]);
            }else{
                findMaxIndex();
                listAdd(input[i]);
            }
        }
        Collections.sort(arrayList);
        return arrayList;

    }

    public void findMaxIndex(){
        int max=0;
        for (int i=1;i<arrayList.size();i++){
            if (arrayList.get(max)<arrayList.get(i)){
                max=i;
            }
        }
        maxIndex=max;
    }

    public void listAdd(int tmp){
        if (tmp<arrayList.get(maxIndex)){
            arrayList.remove(maxIndex);
            arrayList.add(tmp);
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        Arrays.sort(input);
        for (int i=0;i<k;i++){
            arrayList.add(input[i]);
        }
        return arrayList;

    }
    public static void main(String[] args) {
            GetLeastNumbers numbers=new GetLeastNumbers();
            numbers.GetLeastNumbers_Solution(Tools.readArrInt("4 5 1 6 2 7 3 8"),4);
    }
}
