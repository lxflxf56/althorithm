package offer2;


import java.util.ArrayList;
import java.util.Comparator;


/*输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
则打印出这三个数字能排成的最小数字为321323。*/

public class PrintMinNumberT {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i:numbers){
            arrayList.add(i);
        }
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1=o1+""+o2;
                String str2=o2+""+o1;
                return str1.compareTo(str2);
            }
        });
        String str="";
        for (int i:arrayList){
            str=str+i;
        }
        return str;
    }
}
