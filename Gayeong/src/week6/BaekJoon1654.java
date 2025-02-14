import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1654 {
    static int K, N;
    static int[] lans;

    static int binarySearch(long start, long end, int target) {

        while (start <= end) {
            long mid = (start + end) / 2;

            if (getCount(mid) >= target) start = mid + 1;
            else end = mid - 1;
        }

        return (int)end;
    }

    static long getCount(long length) {

        long count = 0;
        for (int lan : lans) count += lan / length;

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lans = new int[K];

        int max = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            lans[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lans[i]);
        }

        System.out.println(binarySearch(1, max, N));

    }
}
