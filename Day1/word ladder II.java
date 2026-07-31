import java.util.*;

class Solution {
    static class Pair {
        String word;
        int dist;
        Pair(String w, int d) {
            word = w;
            dist = d;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            String word = curr.word;
            int dist = curr.dist;

            if (word.equals(endWord)) return dist;

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char original = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) continue;
                    arr[i] = c;
                    String newWord = new String(arr);

                    if (set.contains(newWord)) {
                        queue.offer(new Pair(newWord, dist + 1));
                        // Remove from set to mark as visited
                        set.remove(newWord); 
                    }
                }
                arr[i] = original; // Backtrack character
            }
        }
        return 0;
    }
}
