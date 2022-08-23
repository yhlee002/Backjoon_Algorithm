package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alogrithm1197_kruskal {
  static int n;
  static int e;
  static int[] setInfo;
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

  int find(int v) {
    if (setInfo[v] == v) return v;
    else return find(setInfo[v]);
  }

  void union(int v1, int v2) {
    int fv1 = find(v1);
    int fv2 = find(v2);
    if (fv1 != fv2) setInfo[fv1] = fv2;
  }

  public static void main(String[] args) {
    Alogrithm1197_kruskal main = new Alogrithm1197_kruskal();
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    e = sc.nextInt();
    setInfo = new int[n + 1];

    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      main.union(a, b);
    }

    // 추가 작성 예정
  }
}
