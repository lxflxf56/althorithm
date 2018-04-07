package offer1;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class JumpStairs {
    int sum=0;
    int n;
    public int JumpFloor(int target) {
        n=target;
        sum=0;
        jump(0,0);
        return sum;
    }

    public void jump(int now,int high){
        if (now+high==n){
            sum++;
            return;
        }
        if (now+high>n){
            return;
        }
        jump(now+high,1);
        jump(now+high,2);
    }

    public int JumpFloorII(int target) {
        n=target;
        sum=0;
        jump2(0,0);
        return sum;
    }
    public void jump2(int now,int high){
        if (now+high==n){
            sum++;
            return;
        }

        for (int i=1;i<=n;i++){
            if (now+high>n){
                break;
            }
            jump2(now+high,i);
        }


    }


    public static void main(String[] args) {
        JumpStairs jumpStairs=new JumpStairs();
        System.out.println(jumpStairs.JumpFloor(3));
        System.out.println(jumpStairs.JumpFloorII(3));
    }

}
