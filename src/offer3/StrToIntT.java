package offer3;
//str转int
public class StrToIntT {
    public static int StrToInt(String str)
    {
        if (str.equals("") || str.length() == 0)
            return 0;
        char[] a = str.toCharArray();
        int fu=1;
        int i=0;
        if (a[0]=='-'){
            fu=-1;
            i++;
        }else if (a[0]=='+'){
            i++;
        }
        int sum=0;
        for (;i<a.length;i++){
            if (a[i] < 48 || a[i] > 57)
                return 0;
            sum = sum * 10 + a[i] - 48;
        }
        return fu*sum;
    }


    public static void main(String[] args) {
        System.out.println(StrToInt("123"));

    }
}
