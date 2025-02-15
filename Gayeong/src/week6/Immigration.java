public class Immigration {
    class Solution {
        static long binarySearch(long start, long end, int target, int[] array) {

            while (start <= end) {
                long mid = (start + end) / 2;

                if (getCount(mid, array) < target) start = mid + 1;
                else end = mid - 1;
            }

            return start;
        }

        static long getCount(long time, int[] array) {
            long count = 0;

            for (int data : array) count += time / data;

            return count;
        }

        public long solution(int n, int[] times) {
            long max = 0;
            for (int time : times) max = Math.max(max, time);

            max = max * n;

            return binarySearch(1, max, n, times);
        }
    }
}