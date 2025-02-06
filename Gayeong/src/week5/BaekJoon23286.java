import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon23286 {
    static int t;
    static int n, m;
    static ArrayList<Node>[] graph;
    static int[] distance;
    static int[][] distanceMap;

    static class Node {
        int v, e;

        Node(int v, int e) {
            this.v = v;
            this.e = e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        sc.nextLine();

        distance = new int[n+1];
        distanceMap = new int[n+1][n+1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        int u, v, h;
        for (int i = 0; i < m; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            h = sc.nextInt();

            graph[u].add(new Node(v, h));
        }

        for (int i = 1; i <= n; i++)
            dijkstra(i);

        int start, end;
        for (int i = 0; i < t; i++) {
            start = sc.nextInt();
            end = sc.nextInt();

            System.out.println(distanceMap[start][end]);
        }
    }

    static void dijkstra(int start) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if (distance[cur.v] < cur.e) continue;

            for (Node next : graph[cur.v]) {
                int max = Math.max(cur.e, next.e);

                if (max < distance[next.v]) {
                    distance[next.v] = max;
                    pq.offer(new Node(next.v, distance[next.v]));
                }

            }
        }

        for (int i = 1; i <= n; i++) {
            distanceMap[start][i] = distance[i] != Integer.MAX_VALUE ? distance[i] : -1;
        }
    }
}
