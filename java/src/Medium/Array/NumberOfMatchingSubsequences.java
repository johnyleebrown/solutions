package Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 792
 * Given string S and a dictionary of words words,
 * find the number of words[i] that is a subsequence of S.
 */
public class NumberOfMatchingSubsequences {
    /**
     * Time complexity: O()
     * Space complexity: O(1)
     */
    public static int solution(String S, String[] words) {
        List<Integer[]>[] waiting = new List[128];
        for (int c = 0; c <= 'z'; c++)
            waiting[c] = new ArrayList();
        for (int i = 0; i < words.length; i++)
            waiting[words[i].charAt(0)].add(new Integer[]{i, 1});
        for (char c : S.toCharArray()) {
            List<Integer[]> advance = new ArrayList(waiting[c]);
            waiting[c].clear();
            for (Integer[] a : advance)
                waiting[a[1] < words[a[0]].length() ? words[a[0]].charAt(a[1]++) : 0].add(a);
        }
        return waiting[0].size();
    }
}
