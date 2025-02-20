import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1940 {
    static int N, M;
    static int numbers[];

    static int twoPointer() {
        Arrays.sort(numbers);
        int left = 0, right = N - 1, count = 0;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == M) {
                count++;
                left++;
                right--;
            } else if (sum < M) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        System.out.println(twoPointer());
    }
}
