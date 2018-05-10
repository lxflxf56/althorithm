package offer4;

import java.util.Comparator;
import java.util.PriorityQueue;
/*
* 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
* 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
* */
public class GetMedianT {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });


    int count=0;
    public void Insert(Integer num) {
        if (count%2==0){
            maxHeap.offer(num);
            int tmp=maxHeap.poll();
            minHeap.offer(tmp);
        }else {
            minHeap.offer(num);
            int tmp=minHeap.poll();
            maxHeap.offer(tmp);
        }
        count++;
    }

    public Double GetMedian() {
        double tmp;
        if (count%2==0){
            tmp=(minHeap.peek()+maxHeap.peek())/2.0;
        }else {
            tmp=minHeap.peek();
        }
        return tmp;
    }

    public static void main(String args[]){
        GetMedianT medianT=new GetMedianT();
        medianT.Insert(3);
        System.out.println(medianT.GetMedian());
    }
}
