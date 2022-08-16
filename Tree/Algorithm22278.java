package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 두 최단 경로
public class Algorithm22278 {
    static int n;
    static int m;
    static int[][] matrix;
    static boolean[][] checked;
    static List<Integer>[] paths;
    static boolean[] checked2;
    static int min;

    void DFS(int x, int k, int sum) { // x: 목표지점, k: 현재 지점, sum: 경로 가중치의 합
        if (k == x) { // 하나의 경로 탐색
            paths[x - 1].add(sum);
        } else {
            for (int i = 1; i <= n; i++) {
                if (!checked[k][i]) {
                    checked[k][i] = true;
                    DFS(x, i, sum + matrix[k][i]);
                    checked[k][i] = false;
                }
            }
        }
    }

    void getMinSum(int L, int x, int sum) {
        if (L == 2) {
            min = Math.min(min, sum);
        } else {
            for (int i = 0; i < paths[x - 1].size(); i++) {
                if (!checked2[i]) {
                    checked2[i] = true;
                    getMinSum(L + 1, x, sum + paths[x - 1].get(i));
                    getMinSum(L, x, sum);
                    checked2[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Algorithm22278 main = new Algorithm22278();
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int k = 0; k < tc; k++) {
            n = sc.nextInt();
            m = sc.nextInt();
            paths = new ArrayList[n];
            matrix = new int[n + 1][n + 1];
            checked = new boolean[n + 1][n + 1];

            sc.nextLine();
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int edge = sc.nextInt();
                matrix[a][b] = edge;
            }

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    min = Integer.MAX_VALUE;
                    paths[i] = new ArrayList<>();
                    checked[1][1] = true;
                    main.DFS(i + 1, 1, 1);
                    if (paths[i].size() < 2) min = -1;
                    else {
                        checked2 = new boolean[paths[i].size()];
                        main.getMinSum(0, i + 1,0);
                    }

                    System.out.print(min + " ");
                }
            }
            System.out.println();
        }

    }
}
