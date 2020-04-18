package regular.bs;

/**
 * 278
 *
 * ======
 *
 * Task.
 *
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 *
 * ======
 *
 * Source: Leetcode
 */
public class FirstBadVersion {
    public static class Solution {
        public int firstBadVersion(int n) {
            int lo = 0;
            int hi = n == Integer.MAX_VALUE ? n : n + 1;
            while (hi - lo > 1) {
                int mid = lo + (hi - lo) / 2;
                if (isBadVersion(mid)) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
            return hi;
        }

        private boolean isBadVersion(int mid) {
            return false;
        }
    }
}