package Tree;

import java.util.*;

public class Algorithm1197_prim {
  static int n;
  static int e;
  static boolean[] checked;
  static ArrayList<ArrayList<Edge>> list;
  static class Edge implements Comparable<Edge> {
    int vertex;
    int cost;

    public Edge(int vertex, int cost) {
      this.vertex = vertex;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
      return this.cost - e.cost;
    }
  }

  int prim() {
    int sum = 0;
    PriorityQueue<Edge> q = new PriorityQueue();
    q.offer(new Edge(1, 0));
    while (!q.isEmpty()) {
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
    n = sc.nextInt();
    e = sc.nextInt();
    checked = new boolean[n + 1];
    list = new ArrayList<>();
    for (int i = 0; i <= e; i++) list.add(new ArrayList<>());
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      list.get(a).add(new Edge(b, c));
      list.get(b).add(new Edge(a, c));
    }

    System.out.println(main.prim());
  }
}