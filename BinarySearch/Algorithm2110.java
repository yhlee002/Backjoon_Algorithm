package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

// 공유기 설치
public class Algorithm2110 {
    private int solution(int n, int c, int[] arr) {
        int answer = Integer.MIN_VALUE;
        Arrays.sort(arr);
        int lt = 1, rt = arr[n - 1] - arr[0];

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = 1, max = Integer.MAX_VALUE;

            int ep = arr[0];
            for (int i = 1; i < n; i++) {
                if (arr[i] - ep >= mid) {
                    cnt++;
                    if (max > arr[i] - ep) max = arr[i] - ep;
                    ep = arr[i];
                }
            }

            if (cnt >= c) {
                lt = mid + 1;
                if (max > answer) answer = max;
            } else rt = mid - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm2110 main = new Algorithm2110();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) list[i] = sc.nextInt();
        System.out.println(main.solution(n, c, list));
    }
}