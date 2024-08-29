package Algorism.Sort.HeapSort;

import java.util.Scanner;

/**
 * 알고리즘 수업 - 힙 정렬 1
 * https://www.acmicpc.net/problem/24173
 */
public class Algorithm24173 {
    private static int cnt = 0;
    public void heap_sort(int[] list, int n, int k) {
        list = build_min_heap(list, n, k);
        for (int i = n; i >= 2; i--) {
            swap(list, 1, i, k);
            heapify(list, 1, i - 1, k);
        }

        if (cnt < k) {
            System.out.println(-1);
        }
    }

    /**
     *
     * @param list 배열
     * @param n 배열의 수
     * @param k 출력할 교환 횟수
     */
    int[] build_min_heap(int[] list, int n, int k) { // n = list.length
        int[] heap = new int[n + 1];
        for (int i = 0; i < n; i++) {
            heap[i + 1] = list[i];
        }

        for (int i = n / 2; i >= 1; i--) {
            heapify(heap, i, n, k);
        }

        return heap;
    }

    /**
     *
     * @param list
     * @param idx0
     * @param idx1
     * @param goal
     */
    void swap(int[] list, int idx0, int idx1, int goal) {
        int val = list[idx0];
        list[idx0] = list[idx1];
        list[idx1] = val;
        cnt++;

        if (goal == cnt) {
            System.out.println(Math.min(list[idx0], list[idx1]) + " " +
                    Math.max(list[idx0], list[idx1]));
        }
    }

    // k는 부모 노드 인덱스
    // n은 마지막 인덱스
    void heapify(int[] list, int k, int n, int goal) {
        int left = 2 * k;
        int right = 2 * k + 1;

        int smaller = k;
        if (right <= n) {
            if (list[left] < list[right]) smaller = left;
            else smaller = right;
        } else if (left <= n) smaller = left;
        else return;

        // 최소 힙 성질을 만족하지 못하는 경우 재귀적으로 수정한다.
        if (list[smaller] < list[k]) {
            swap(list, k, smaller, goal);
            heapify(list, smaller, n, goal);
        }
    }

    public static void main(String[] args) {
        Algorithm24173 self = new Algorithm24173();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        self.heap_sort(arr, n, k);
    }
}
