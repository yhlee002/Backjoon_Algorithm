package DataStructure.Tree;

import java.util.*;

public class Alogrithm1197_kruskal {
    static int n;
    static int e;
    static int[] setInfo;
    static int sum = 0;

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    int find(int v) {
        if (setInfo[v] == v) return v;
        else return find(setInfo[v]);
    }

    void union(int v1, int v2, int cost) {
        int fv1 = find(v1);
        int fv2 = find(v2);
        if (fv1 != fv2) {
            setInfo[fv1] = fv2;
            sum += cost;
        }
    }

    public static void main(String[] args) {
        Alogrithm1197_kruskal main = new Alogrithm1197_kruskal();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        setInfo = new int[n + 1];
        for (int i = 1; i <= n; i++) setInfo[i] = i;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);
        for (Edge e : edges) {
            int fa = main.find(e.v1);
            int fb = main.find(e.v2);
            main.union(fa, fb, e.cost);
        }

        System.out.println(sum);
    }
}
