package offer2;
/*输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。*/

import offer1.Tools;

//
//BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
// 如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，
//前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。
public class VerifySquenceOfBSTT {
    int[] array;
    public boolean VerifySquenceOfBST(int [] sequence) {
        array=sequence;
        return isBST(0,array.length-1);
    }

    public boolean isBST(int start,int end){
        if (start>=end) return true;
        int k=end;
        int sEnd=end;
        boolean left=true;
        for (int i=start;i<end;i++){
            if (left){
                if (array[k]<array[i]){
                    left=false;
                    sEnd=i;
                }
            }else {
                if (array[k]>array[i]){
                    return false;
                }
            }
        }
        boolean result=isBST(start,sEnd-1)&&isBST(sEnd,end-1);
        return result;

    }

    public static void main(String[] args) {
        int[] tmp= Tools.readArrInt("4 8 6 12 16 14 10");
        VerifySquenceOfBSTT bstt=new VerifySquenceOfBSTT();
        System.out.println(bstt.VerifySquenceOfBST(tmp));

    }

}
