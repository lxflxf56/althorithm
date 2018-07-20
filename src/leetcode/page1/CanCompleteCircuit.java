package leetcode.page1;
/*
*  There are N gas stations along a circular route, where the amount of gas at station i isgas[i].

You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
* */
//从start出发， 如果油量足够， 可以一直向后走 end++；  油量不够的时候，
//start向后退  最终 start == end的时候，如果有解一定是当前 start所在位置
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
            int start=gas.length-1;
            int end=0;
            int num=gas[start]-cost[start];
            while (end<=start){
                if (num<0){
                    start--;
                    num=gas[start]-cost[start];
                }else {
                    num+=gas[end]-cost[end];
                    end++;
                }
            }
            if (num<0){
                return -1;
            }else {
                return start;
            }
    }
    public static void main(String args[]){
        CanCompleteCircuit canCompleteCircuit=new CanCompleteCircuit();
        int[] a =new int[]{1,2};
        int[] b=new int[]{2,1};
        canCompleteCircuit.canCompleteCircuit(a,b);
    }
}
