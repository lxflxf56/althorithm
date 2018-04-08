package offer3;

import java.util.Arrays;

public class IsContinuousT {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length<5){
            return false;
        }
        Arrays.sort(numbers);
        int num0=0;
        int count=0;
        for (int i=1;i<numbers.length;i++){
            if (numbers[i-1]==0){
                num0++;
                continue;
            }else if (numbers[i-1]==numbers[i]){
                return false;
            }else {
                count=count+(numbers[i]-numbers[i-1])-1;
            }
        }
        if (count>num0){
            return false;
        }
        return true;
    }
}
