package Algorism.Greedy.Dijkstra;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 숨바꼭질 3
 * 0-1 BFS 풀이
 * https://www.acmicpc.net/problem/13549
 */
public class Algorithm13549_01bfs {
    private boolean[] visited = new boolean[100001];

    int bfs(int node, int end) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(node, 0));

        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node n = q.poll();
            visited[n.key] = true;

            if (n.key == end) {
                answer = Math.min(answer, n.cost);
                break;
            } else {
                if (n.key * 2 <= 100000 && !visited[n.key * 2]) {
                    q.offer(new Node(n.key * 2, n.cost));
                }

                if (n.key + 1 <= 100000 && !visited[n.key + 1]) {
                    q.offer(new Node(n.key + 1, n.cost + 1));
                }

                if (n.key - 1 >= 0 && !visited[n.key - 1]) {
                    q.offer(new Node(n.key - 1, n.cost + 1));
                }
            }
        }

        return answer;
    }

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = bfs(a, b);

        System.out.println(result);
    }

    public static void main(String[] args) {
        Algorithm13549_01bfs self = new Algorithm13549_01bfs();
        self.solution();
    }

    private static class Node {
        int key;
        int cost;

        public Node(int key, int cost) {
            this.key = key;
            this.cost = cost;
        }
    }
}
