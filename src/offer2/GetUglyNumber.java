package offer2;
/*
* 把只包含因子2、3和5的数称作丑数（Ugly Number）。
* 例如6、8都是丑数，但14不是，因为它包含因子7。
* 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
* */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index<=0)
            return 0;
        int[] number=new int[index];
        number[0]=1;
        int a2=0,a3=0,a5=0;
        for (int i=1;i<index;i++){
            int a=number[a2]*2;
            int b=number[a3]*3;
            int c=number[a5]*5;
            number[i]=findMin(a,b,c);
            if (number[i]==number[a2]*2)
                a2++;
            if (number[i]==number[a3]*3)
                a3++;
            if (number[i]==number[a5]*5)
                a5++;
        }
        return (int)number[index-1];
    }

    public int findMin(int a,int b,int c){
        int min;
        if (a<b){
            min=a;
        }else{
            min=b;
        }
        if (min<c){
            return min;
        }else
            return c;
    }


    public static void main(String[] args) {
        GetUglyNumber number=new GetUglyNumber();
        number.GetUglyNumber_Solution(8);
    }
}
