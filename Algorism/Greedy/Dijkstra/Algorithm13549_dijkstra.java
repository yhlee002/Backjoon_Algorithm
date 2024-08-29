package Algorism.Greedy.Dijkstra;

import java.util.*;
/**
 * 숨바꼭질 3
 * 다익스트라 풀이(PriorityQueue + DP)
 * Cf. visited로 방문 노드를 구분하지 않아도 정답으로 나옴
 * https://www.acmicpc.net/problem/13549
 */
public class Algorithm13549_dijkstra {
    private int MAX_VALUE = 100_000; // 0 <= a <= 100_000, 0 <= b <= 100_000
    private int INF = 100_000; // a와 b가 각각 0과 100,000일 경우 최대 거리는 100,000

    public void solution() {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // 각 인덱스를 키로 갖는 노드들에 도달하는데 걸린 최소 시간
        int[] distance = new int[MAX_VALUE + 1];
        Arrays.fill(distance, INF);
        // 방문한 노드와 그렇지 않은 노드 구분
        boolean[] visited = new boolean[100001];

        // 현재 위치(a에서 시작해 이동)에서 갈 수 있는 노드들로의 거리 계산 후 큐에 저장
        // -> 다음으로 이동할 위치는 가장 우선순위가 높은 비용의(여기서는 최소힙이라 가장 비용이 적은) 노드
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        q.offer(new Node(a, 0));
        distance[a] = 0;
        visited[a] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.key] = true;

            int pos;
            pos = node.key + 1;
            if (isValid(pos) && !visited[pos] && distance[pos] > node.cost + 1) {
                distance[pos] = node.cost + 1;
                q.offer(new Node(pos, distance[pos]));
            }

            pos = node.key - 1;
            if (isValid(pos) && !visited[pos] && distance[pos] > node.cost + 1) { // node.cost > node.cost + 1 일 가능성은 없으니 생략
                distance[pos] = node.cost + 1;
                q.offer(new Node(pos, distance[pos]));
            }

            pos = node.key * 2;
            if (isValid(pos) && !visited[pos] && distance[pos] > node.cost) {
                distance[pos] = node.cost;
                q.offer(new Node(pos, distance[pos]));
            }
        }

        System.out.println(distance[b]);
    }

    private boolean isValid(int value) {
        return 0 <= value && value <= 100_000;
    }

    public static void main(String[] args) {
        Algorithm13549_dijkstra self = new Algorithm13549_dijkstra();
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
