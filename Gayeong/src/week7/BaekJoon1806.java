import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1806 {
    static int N, S;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        System.out.println(twoPointer());
    }

    static int twoPointer() {
        int left = 0, right = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;

        while (right < N) {
            sum += numbers[right];

            while (sum >= S) {
                length = Math.min(length, right - left + 1);
                sum -= numbers[left++];
            }
            right++;
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
