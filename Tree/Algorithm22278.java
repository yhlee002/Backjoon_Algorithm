package Tree;

import java.util.*;

// 두 최단 경로
public class Algorithm22278 {
    static List<Integer> nList = new ArrayList<>();
    static List<Integer> mList = new ArrayList<>();
    static List<List<List<Edge>>> list = new ArrayList<>();
    static List<Integer>[] path;

    static class Edge implements Comparable<Edge> {
        int vertex;
        int cost;

        public Edge (int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    void solution(int idx) {
        int n = nList.get(idx);
        int m = mList.get(idx);
//        boolean[] checked = new boolean[n + 1];
        path = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) path[i] = new ArrayList<>();

        PriorityQueue<Edge> q = new PriorityQueue<Edge>();
        q.offer(new Edge(1, 0));
        path[1].add(0);
//        checked[1] = true;
        while (!q.isEmpty()) {
            Edge edge = q.poll();
            int curr = edge.vertex;
            int currCost = edge.cost;
            List<Edge> currentList = list.get(idx).get(curr);
            for (Edge e : currentList) {
//                if (checked[e.vertex])
                q.offer(new Edge(e.vertex, currCost + e.cost));
                path[e.vertex].add(currCost + e.cost);
            }
        }
    }

    public static void main(String[] args) {
        Algorithm22278 main = new Algorithm22278();
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int k = 0; k < tc; k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            nList.add(n);
            mList.add(m);

            list.add(new ArrayList<>());
            for (int i = 0; i <= n; i++) list.get(k).add(new ArrayList<>());
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int cost = sc.nextInt();
                list.get(k).get(a).add(new Edge(b, cost));
            }
        }

        for (int i = 0; i < tc; i++) {
            main.solution(i);
            for (int j = 2; j <= nList.get(i); j++) {
                PriorityQueue<Integer> q = new PriorityQueue();
                for (int cost : path[j]) q.offer(cost);

                if (q.size() < 2) System.out.print(-1 + " ");
                else {
                    int sum = 0;
                    for (int l = 0; l < 2; l++) sum += q.poll();
                    System.out.print(sum);
                }
            }
            System.out.println();
        }
    }
}