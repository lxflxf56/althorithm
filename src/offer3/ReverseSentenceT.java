package offer3;

public class ReverseSentenceT {
    public static String ReverseSentence(String str) {
        String result="";
        String[] strings=str.split(" ");
        if (strings.length==1){
            return strings[0];
        }else if (strings.length<1){
            return str;
        }
        result=strings[strings.length-1];
        for (int i=strings.length-2;i>=0;i--){
            result=result+" "+strings[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence(" "));
    }
}
