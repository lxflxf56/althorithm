package offer2;

public class FirstNotRepeatingCharT {
    StringBuilder builder;
    char replace;
    public int FirstNotRepeatingChar(String str) {

        builder=new StringBuilder(str);
        if (builder.length()<=0){
            return -1;
        }
        replace=builder.charAt(0);
        for (int i=0;i<builder.length();i++){
            if (isNot(i)){
                return i;
            }
        }
        return -1;
    }

    private boolean isNot(int index){

        char c = builder.charAt(index);
        if (index!=0&&c==replace){
            return false;
        }
        boolean is=true;
        for (int i=index+1;i<builder.length();i++){
            if (builder.charAt(i)==c){
                builder.setCharAt(i,replace);
                is=false;
            }
        }
        return is;
    }
}
