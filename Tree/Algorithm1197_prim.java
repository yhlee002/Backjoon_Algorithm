package Tree;

import java.util.*;

// 최대 수입 스케쥴
public class Algorithm1197_prim {
  static class Edge implements Comparable<Edge> {
    int vertex;
    int cost;

    public Edge(int vertex, int cost) {
      this.vertex = vertex;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
      return e.cost - this.cost;
    }
  }

  int prim(int n, int e, boolean[] checked, List<List<Edge>> list) {
    int sum = 0;
    PriorityQueue<Edge> q = new PriorityQueue();
    q.offer(new Edge(1, 0));
    while (q.isEmpty()) {
      Edge r = q.poll();
      if (!checked[r.vertex]) {
        checked[r.vertex] = true;
        sum += r.cost;
        for (Edge c : list.get(r.vertex)) {
          q.offer(c);
        }
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    Algorithm1197_prim main = new Algorithm1197_prim();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int e = sc.nextInt();
    boolean[] checked = new boolean[n + 1];
    List<List<Edge>> list = new ArrayList<>();
    for (int i = 0; i <= e; i++) list.add(new ArrayList<>());
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      list.get(a).add(new Edge(b, c));
      list.get(b).add(new Edge(a, c));
    }

    System.out.println(main.prim(n, e, checked, list));
  }
}