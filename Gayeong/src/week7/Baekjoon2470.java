import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon2470 {
    static int N;
    static int[] solutions;

    static String twoPointer() {
        Arrays.sort(solutions);
        int left = 0, right = N - 1;
        int minAbsSum = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (left < right) {
            int sum = solutions[left] + solutions[right];

            if (Math.abs(sum) < minAbsSum) {
                minAbsSum = Math.abs(sum);
                result[0] = solutions[left];
                result[1] = solutions[right];
            }

            if (sum < 0) left++;
            else right--;
        }

        return result[0] + " " + result[1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointer());
    }
}
