package offer4;
//10进制任意转换
public class Hexadecimal {

    public static String DecmialTo36(int num){
        String string = Integer.toString(num, 36);
        return string;
    }

    public static int TSTo10(String str){
        int i = Integer.parseInt(str, 36);
        return i;
    }

    public static void main(String args[]){
        String s = DecmialTo36(777);
        System.out.println(s);
        int i = TSTo10(s);
        System.out.println(i);

    }

}
