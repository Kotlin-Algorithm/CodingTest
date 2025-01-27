import java.util.*;

public class ShortestReachInAGraph {
    static int q;
    static int n, m;
    static int s;
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);

        q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            sc.nextLine();

            graph = new ArrayList[n+1];
            visited = new int[n+1];

            for (int j = 1; j < n+1; j++) graph[j] = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

            s = sc.nextInt();
            bfs();

            for (int idx = 1; idx < n+1; idx++) {
                if (idx == s) continue;
                if (visited[idx] == 0) System.out.print(-1 + " ");
                else System.out.print(visited[idx] + " ");
            }
            System.out.println();
        }


    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph[u]) {
                if (visited[v] == 0) {
                    queue.add(v);
                    if (u == s) visited[v] += 6;
                    else visited[v] += visited[u] + 6;
                }
            }
        }

    }
}
