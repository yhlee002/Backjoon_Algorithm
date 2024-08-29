package DataStructure.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 트리의 부모 찾기(adjacency matrix 사용 -> adjacency list 사용으로 변경)
public class Algorithm11725 {
    static int[] result;
    static int num;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        list = new ArrayList[num + 1];

        for (int i = 1; i < num + 1; i++) list[i] = new ArrayList<>();

        for (int i = 2; i < num + 1; i++) { // != a
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        // retrieve
        result = new int[num + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[] checked = new boolean[num + 1];
        while (!q.isEmpty()) {
            int n = q.poll();
            for (int i = 0; i < list[n].size(); i++) {
                int child = list[n].get(i);
                if (!checked[child]) { // 이미 체크한 노드인지
                    result[child] = n;
                    q.offer(child);
                }
            }
            checked[n] = true;
        }

        for (int i = 2; i < num + 1; i++) System.out.println(result[i]);
    }
}
