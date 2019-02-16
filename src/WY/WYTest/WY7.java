package WY.WYTest;

/*
小Q和牛博士合唱一首歌曲,这首歌曲由n个音调组成,每个音调由一个正整数表示。
对于每个音调要么由小Q演唱要么由牛博士演唱,对于一系列音调演唱的难度等于所有相邻音调变化幅度之和, 例如一个音调序列是8, 8, 13, 12, 那么它的难度等于|8 - 8| + |13 - 8| + |12 - 13| = 6(其中||表示绝对值)。
现在要对把这n个音调分配给小Q或牛博士,让他们演唱的难度之和最小,请你算算最小的难度和是多少。
如样例所示: 小Q选择演唱{5, 6}难度为1, 牛博士选择演唱{1, 2, 1}难度为2,难度之和为3,这一个是最小难度和的方案了。
*/
//未解决，放弃
public class WY7 {
    int[] array;
    int[][] dp;
    public WY7(int[] arr){
        array=arr;
        dp=new int[arr.length][arr.length];
    }

    public int compute(){
        dp[0][0] = 0 - Math.abs(array[1] - array[0]);
        int[] acc = new int[array.length];
        for (int i=1;i<array.length;i++){
            acc[i]=acc[i - 1] + Math.abs(array[i] - array[i - 1]);
            dp[i][i - 1] = acc[i - 1];//该初始化表示前面没有换人
            /*
            for (int j=0;j<i;j++){
                dp[i][j] = dp[i-1][j] + Math.abs(array[i] - array[i-1]);//接着唱，加上差值
                if (j==i-1){//换人唱
                    for (int k=0;k<i-1;k++){
                        int tmp=dp[i-1][k]+Math.abs(array[i]-array[k]);
                        dp[i][i-1]=Math.min(dp[i][i-1],tmp);//a从k个音符开始换着唱，到该音符再返回，加上这个i音符与k音符的绝对值，求最小值
                    }
                }
            }*/
            for (int j = 0; j < i - 1; ++j) {
                dp[i][j] = dp[i - 1][j] + Math.abs(array[i]-array[i-1]);
                dp[i][i - 1] = Math.min(dp[i][i - 1], dp[i - 1][j] + Math.abs(array[i] - array[j]));
            }
        }
        int min=dp[array.length-1][0];
        for (int i=1;i<array.length-1;i++){//求最后一行的最小值
            min=Math.min(dp[array.length-1][i],min);
        }
        return min;

    }

    public static void main(String[] args) {
        int[] x={1,5,6,2,1};
        WY7 wy7=new WY7(x);
        System.out.println(wy7.compute());
    }




}
