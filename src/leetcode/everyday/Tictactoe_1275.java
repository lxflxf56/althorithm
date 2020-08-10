package leetcode.everyday;

/**
 * @program: althorithm
 * @description: https://leetcode-cn.com/problems/find-winner-on-a-tic-tac-toe-game/
 * @author: Xiaofeng
 * @create: 2020-08-10
 */
public class Tictactoe_1275 {
    public String tictactoe(int[][] moves) {
        int[][] integers = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        int count = 0;
        int now = 1;
        for (int i = 0; i < moves.length; i++) {
            integers[moves[i][0]][moves[i][1]] = now;
            now=-now;
            count++;
        }
        int x1=0;
        int x2=0;
        for (int i=0;i<3;i++){
            int h=0;
            int s=0;
            for (int j=0;j<3;j++){
                h=h+integers[i][j];//横
                s=s+integers[j][i];//竖
            }
            if (h==3||s==3){
                return "A";
            }
            if (h==-3||s==-3){
                return "B";
            }
            x1=x1+integers[i][i];
            x2=x2+integers[2-i][i];
        }
        if (x1==3||x2==3){
            return "A";
        }
        if (x1==-3||x2==-3){
            return "B";
        }
        if (count==9){
            return "Draw";
        }
        return "Pending";
    }

    public static void main(String[] args){
        int[][] ints=new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}};
        System.out.println(new Tictactoe_1275().tictactoe(ints));
    }
}
