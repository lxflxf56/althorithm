package offer3;

public class LeftRotateStringT {
    public String LeftRotateString(String str,int n) {
        if (str.length()<n){
            return "";
        }
        StringBuilder builder=new StringBuilder(str);
        String tmp=builder.substring(0,n);
        builder.delete(0,n);
        return builder.toString()+tmp;
    }

    public static void main(String[] args) {
        StringBuilder builder=new StringBuilder("123456");
        System.out.println(builder.substring(0,3));
    }
}
