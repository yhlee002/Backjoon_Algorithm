package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// 트리 순회
public class Algorithm1991 {
    Node header;

    static class Node {
        String data;
        Node lt, rt;

        public Node(String data) {
            this.data = data;
            lt = null;
            rt = null;
        }
    }

    Node findByData(String data) {
        Node root = this.header;
        if (root.data == data) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.lt != null) {
                if (n.lt.data.equals(data)) return n.lt;
                q.offer(n.lt);
            }
            if (n.rt != null) {
                if (n.rt.data.equals(data)) return n.rt;
                q.offer(n.rt);
            }
        }
        return null;
    }

    /*
    전위 순회(부모 -> 왼 -> 오) - stack을 사용해 구현
    주의. 스택으로 왼쪽 노드부터 출력되게 할 때에는 오른편 노드를 먼저 넣어야 함
    큐로 왼쪽 노드부터 출력되게 할 때에는 왼편 노드를 먼저 넣어야 함

    void preorderTraversalS() {
        Node root = this.header;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.print(n.data);
            if (n.rt != null) stack.push(n.rt);
            if (n.lt != null) stack.push(n.lt);
        }
        System.out.println();
    }
     */

    /*
     전위 순회 - Queue를 사용해 구현

     void preorderTraversalQ() {
        Node root = this.header;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.data);

            if (n.lt != null) q.offer(n.lt);
            if (n.rt != null) q.offer(n.rt);
        }
        System.out.println();
    }
     */


    // 전위 순회 - 재귀
    void preorderTraversalR(Node root) {
        if (root != null) {
            System.out.print(root.data);
            if (root.lt != null) preorderTraversalR(root.lt);
            if (root.rt != null) preorderTraversalR(root.rt);
        }
    }

    // 중위 순회(왼 -> 부모 -> 오)
    void inorderTraversalR(Node root) {
        if (root != null) {
            if (root.lt != null) inorderTraversalR(root.lt);
            System.out.print(root.data);
            if (root.rt != null) inorderTraversalR(root.rt);
        }
    }

    // 후위 순회(왼 -> 오 -> 부모)
    void postorderTraversalR(Node root) {
        if (root != null) {
            if (root.lt != null) postorderTraversalR(root.lt);
            if (root.rt != null) postorderTraversalR(root.rt);
            System.out.print(root.data);
        }
    }

    // bfs로 해결(Queue 사용)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Algorithm1991 tree = new Algorithm1991();
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            String line = sc.nextLine();
            String[] list = line.split(" ");

            if (i == 0) {
                tree.header = new Node(list[0]);
                if (!list[1].equals(".")) tree.header.lt = new Node(list[1]);
                if (!list[2].equals(".")) tree.header.rt = new Node(list[2]);
                continue;
            }

            Node p = tree.findByData(list[0]);
            if (!list[1].equals(".")) p.lt = new Node(list[1]);
            if (!list[2].equals(".")) p.rt = new Node(list[2]);
        }

        tree.preorderTraversalR(tree.header);
        System.out.println();

        tree.inorderTraversalR(tree.header);
        System.out.println();

        tree.postorderTraversalR(tree.header);
        System.out.println();
    }
}