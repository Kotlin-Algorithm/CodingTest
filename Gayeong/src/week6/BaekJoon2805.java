import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2805 {
    static int N;
    static int M;
    static int[] trees;

    static int binarySearch(int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (getLength(mid) >= target) start = mid + 1;
            else end = mid - 1;
        }

        return end;
    }

    static long getLength(int height) {
        long sum = 0;
        for (int tree : trees) {
            if (tree <= height) continue;
            sum += tree - height;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        System.out.println(binarySearch(1, max, M));
    }
}
