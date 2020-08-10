package leetcode.everyday;

import javafx.util.Pair;

import java.util.*;

/**
 * @program: althorithm
 * @description: https://leetcode-cn.com/problems/word-ladder/
 * 广度优先队列
 * @author: Xiaofeng
 * @create: 2020-08-08
 */
public class LadderLength_127 {






    private int nowDept = Integer.MAX_VALUE;

    @Deprecated
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int i = ladderLength2(beginWord, endWord, wordList, 1);
        if (nowDept != Integer.MAX_VALUE) {
            return nowDept;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList, int dep) {
        if (beginWord.equals(endWord)) {
            nowDept = Math.min(nowDept, dep);
            return dep;
        }
        wordList.remove(beginWord);
        int min = Integer.MAX_VALUE;
        if (nowDept != Integer.MAX_VALUE && dep > nowDept) {
            return min;
        }
        for (String tmp : wordList) {
            if (check(beginWord, tmp)) {
                ArrayList<String> strings = new ArrayList<>(wordList);
                int i = ladderLength2(tmp, endWord, strings, dep + 1);
                min = Math.min(min, i);
            }

        }
        return min;
    }

    public boolean check(String a, String b) {
        int length = a.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        if (count == 1) {
            return true;
        }
        return false;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words whi
                // ch share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }



    public static void main(String[] args) {
        List<java.lang.String> strings = Arrays.asList("hot","dot","dog","lot","log","cog");
        strings = new ArrayList<>(strings);
        int i = new LadderLength_127().ladderLength2("hit", "cog", strings);
        System.out.println(i);
        int i1 = new LadderLength_127().ladderLength("hit", "cog", strings);
        System.out.println(i1);
//        i = new LadderLength_127().ladderLength2("hit", "zog", strings);
//        System.out.println(i);
    }
}
