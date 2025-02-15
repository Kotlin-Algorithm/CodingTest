import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16401 {
    static int binarySearch(int start, int end, int target, int[] sticks) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (getCount(sticks, mid) >= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            System.out.println("mid : " + mid + " count : " + getCount(sticks, mid));
        }
        return end;
    }

    static int getCount(int[] sticks, int length) {
        int count = 0;
        for (int stick : sticks) {
            count += stick / length;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sticks = new int[m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            sticks[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, sticks[i]);
        }


        System.out.println(binarySearch(1, max, n, sticks));
    }
}
