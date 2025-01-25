import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon14248 {
    static boolean[] visited;
    static int[] moves;
    static int n;
    static int start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new boolean[n+1];
        moves = new int[n+1];
        sc.nextLine();
        String[] input = sc.nextLine().split(" ");
        for (int i = 1; i <= n; i++) {
            moves[i] = Integer.parseInt(input[i-1]);
        }
        start = sc.nextInt();
        bfs();

        int count = 0;
        for (boolean isBool : visited) {
            if (isBool) count++;
        }

        System.out.println(count);

    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int point = queue.poll();
            int move = moves[point];
            int newPoint1 = point + move;
            int newPoint2 = point - move;

            if (newPoint1 > 0 && newPoint1 <= n && !visited[newPoint1]) {
                queue.add(newPoint1);
                visited[newPoint1] = true;
            }

            if (newPoint2 > 0 && newPoint2 <= n && !visited[newPoint2]) {
                queue.add(newPoint2);
                visited[newPoint2] = true;
            }
        }
    }
}
