import java.util.*;

public class Programmers_배달 {

    class Solution {
        static int[] distance;
        static ArrayList<Node>[] graph;

        public void dijkstra(int start) {
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
            distance[start] = 0;
            pq.offer(new Node(start, 0));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (distance[cur.v] < cur.e) continue;

                for (Node next : graph[cur.v]) {
                    int cost = distance[cur.v] + next.e;

                    if (cost < distance[next.v]) {
                        distance[next.v] = cost;
                        pq.offer(new Node(next.v, cost));
                    }
                }
            }
        }

        public int solution(int N, int[][] road, int K) {
            distance = new int[N+1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            graph = new ArrayList[N+1];
            for (int i = 0 ; i < N+1; i++) graph[i] = new ArrayList<>();

            for (int[] edge : road) {
                graph[edge[0]].add(new Node(edge[1], edge[2]));
                graph[edge[1]].add(new Node(edge[0], edge[2]));
            }

            dijkstra(1);

            int answer = 0;
            for (int cost : distance) {
                if (cost <= K) answer++;
            }

            return answer;
        }


    }

    class Node {
        int v, e;

        Node(int v, int e) {
            this.v = v;
            this.e = e;
        }
    }
}
