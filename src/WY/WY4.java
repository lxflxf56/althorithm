package WY;

import java.util.Scanner;

/*
*
魔法王国一共有n个城市,编号为0~n-1号,n个城市之间的道路连接起来恰好构成一棵树。
小易现在在0号城市,每次行动小易会从当前所在的城市走到与其相邻的一个城市,小易最多能行动L次。
如果小易到达过某个城市就视为小易游历过这个城市了,小易现在要制定好的旅游计划使他能游历最多的城市,
请你帮他计算一下他最多能游历过多少个城市(注意0号城市已经游历了,游历过的城市不重复计算)。
 分类讨论：

    若 L ≤ maxLen ，显而易见得结果；
    若 L > maxLen ，意味着可以往回走，要知道越短的树链往回走的代价越低。如果从末端往回走，
    消耗的代价非常高，最坏情况是较短的树链都连接在最远的树根上，整条最长链都要回走；如果已经知道最终步数会有剩余，
    则可以先消耗富余的步数走短链，最后才走最长链；
    继续对 rest = L - maxLen 进行讨论：
        若树链上存在某个节点拥有另一条子链，其长度 x 必定小于或等于该祖先到原链末端的长度，考察树链上每个节点到叶子的一条最短子链：
            当 x > rest/2 可以在中途预先用掉 rest 步而不影响要走的 maxLen 最长链，可达城市增加 rest/2 个；
            当 x ≤ rest/2 可以在中途预先用掉 2x 步而不影响要走的 maxLen 最长链，可达城市增加 x 个；
        若所有的 x 总和 sum(x) ≤ rest/2 说明富余的步数足够把最短链到次最长链都走一遍，可达城市为全部 n 个。
        本小节讨论可知 rest/2 决定了能多走的城市数量，总共能走 min(n, 1 + rest/2 + maxLen) 个城市。

输入包括两行,第一行包括两个正整数n(2 ≤ n ≤ 50)和L(1 ≤ L ≤ 100),表示城市个数和小易能行动的次数。
第二行包括n-1个整数parent[i](0 ≤ parent[i] ≤ i), 对于每个合法的i(0 ≤ i ≤ n - 2),在(i+1)号城市和parent[i]间有一条道路连接。
* */
public class WY4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), L = scan.nextInt();
        int parent[] = new int[n];
        int depth[] = new int[n];
        int maxDepth = 0;
        for (int i = 1; i < n; i++) {
            parent[i] = scan.nextInt();
            depth[i] = depth[parent[i]] + 1;
            if (depth[i] > maxDepth)
                maxDepth = depth[i];
        }
        scan.close();
        int count = 0;
        if (maxDepth >= L)
            count = L;
        else
            count = (L - maxDepth) / 2 + maxDepth;
        if(count >= n - 1)
            count = n - 1;
        System.out.println(count + 1);
    }
}
