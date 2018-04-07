package offer2;

import java.util.ArrayList;
import java.util.Collections;

//输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
public class StringPermutation {
    StringBuilder builder;
    ArrayList<String> arrayList;
    public ArrayList<String> Permutation(String str) {
        arrayList=new ArrayList<>();
            if ("".equals(str)){
                return arrayList;
            }
            builder =new StringBuilder(str);

            addString(0);
            Collections.sort(arrayList);
            return arrayList;

    }
    public void swap(int index1,int index2){
        char a=builder.charAt(index1),b=builder.charAt(index2);
        builder.setCharAt(index1,b);
        builder.setCharAt(index2,a);
    }

    public boolean isSwap(int index1,int index2){
        char a=builder.charAt(index1),b=builder.charAt(index2);
        if (index1==index2){
            return true;
        }
        if (a==b){
            return false;
        }
        for (int i=index2+1;i<builder.length();i++){
            if (b==builder.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public void addString(int index){
        if (index>builder.length()-1){
            arrayList.add(builder.toString());
            return;
        }
        for (int i=index;i<builder.length();i++){
            if (isSwap(index,i)){
                swap(index,i);
                addString(index+1);
                swap(index,i);
            }
        }

    }
    public static void main(String[] args) {
        StringPermutation permutation=new StringPermutation();
        ArrayList<String> arrayList=permutation.Permutation("abc");
        for (String tmp:arrayList){
            System.out.println(tmp);
        }
    }
}
