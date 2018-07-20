package offer4;
/*
* 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
* 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
* 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
* 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
* */
public class HasPathT {
    char[] matrix,str;
    int rows,cols;
    boolean[] flag;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        this.matrix=matrix;
        this.str=str;
        this.rows=rows;
        this.cols=cols;
        flag=new boolean[matrix.length];

        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (find(i,j,0)){
                    return true;
                }
            }
        }
        return false;


    }

    boolean find(int i,int j,int now){
        int index=i*cols+j;
        if (i>=rows||j>=cols||i<0||j<0||matrix[index]!=str[now]||flag[index]==true){
            return false;
        }
        if (now==str.length-1){
            return true;
        }
        flag[index]=true;
        if (find(i+1,j,now+1)||find(i-1,j,now+1)||find(i,j-1,now+1)||find(i,j+1,now+1)){
            return true;
        }
        flag[index]=false;
        return false;




    }


    public static void main(String[] args) {
        HasPathT pathT=new HasPathT();
        boolean b = pathT.hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray());
        System.out.println(b);
    }

}
