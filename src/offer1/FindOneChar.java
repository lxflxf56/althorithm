package offer1;//找出一个字符串中第一个只出现一次的字符

import java.util.Arrays;

public class FindOneChar {

    private StringBuilder stringBuilder;
    private char[] orginChar;
    public static void main(String[] args) {
            FindOneChar findOneChar=new FindOneChar("123321asdscsdsedfsefawe");
            findOneChar.findone1();
    }

    public FindOneChar(String str){
        orginChar=str.toCharArray();
        stringBuilder=new StringBuilder(str);
    }
    public char findone1(){
        Arrays.sort(orginChar);
        char result;
        for (int i=0;i<stringBuilder.length();i++){
            result=stringBuilder.charAt(i);
            if(findSub1(result)){
                System.out.print(result);
                return result;
            }
        }
        result='c';
        return result;
    }

    private boolean findSub1(char c){//此处可改为二分查找
        int sum=0;
        for (int i=0;i<stringBuilder.length();i++){
            if (c==stringBuilder.charAt(i)){
                sum++;
                if (sum>=2){
                    return false;
                }
            }
        }
        return true;
    }

    public String findone2(){
        return "No found";
    }






}
