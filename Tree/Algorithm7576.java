package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algorithm7576 {
    static int m;
    static int n;
    static int[][] matrix;
    static int days = 0;
    static int cnt = 0;
    static int[] ym = {-1, 0, 1, 0};
    static int[] xm = {0, 1, 0, -1};
    static Queue<Point> q = new LinkedList<>();

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    void BFS() {
        while (!q.isEmpty()) {
            int size = q.size();
            if (cnt == n * m) return;
            else {
                for (int j = 0; j < size; j++) {
                    Point p = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int my = p.y + ym[i];
                        int mx = p.x + xm[i];
                        if (my > 0 && my <= n && mx > 0 && mx <= m) {
                            if (matrix[my][mx] == 0) {
                                matrix[my][mx] = 1;
                                q.offer(new Point(my, mx));
                                cnt++;
                            }
                        }
                    }
                }
            }
            days++;
        }

        if (cnt < n * m) days = -1;
    }

    public static void main(String[] args) {
        Algorithm7576 main = new Algorithm7576();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        matrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int status = sc.nextInt();
                matrix[i][j] = status;
                if (status == 1) {
                    q.offer(new Point(i, j));
                }
                if (status == 1 || status == -1) cnt++;
            }
        }

        main.BFS();
        System.out.println(days);
    }
}