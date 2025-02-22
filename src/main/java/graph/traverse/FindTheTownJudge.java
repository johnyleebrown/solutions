package graph.traverse;

/**
 * 997
 */
public class FindTheTownJudge {
    public static class Solution {
        public int findJudge(int N, int[][] trust) {
            int[] degree = new int[N + 1];
            for (int[] t : trust) {
                degree[t[0]]--;
                degree[t[1]]++;
            }
            for (int i = 1; i < N + 1; i++) {
                if (degree[i] == N - 1)
                    return i;
            }
            return -1;
        }
    }
}
