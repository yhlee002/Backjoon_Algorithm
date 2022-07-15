package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

// 나무 자르기
public class Algorithm2805 {
    private int solution(int n, int m, int[] list) {
        int answer = 0;

        int lt = 1;
        int rt = Arrays.stream(list).max().getAsInt();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            long sum = 0;
            for (int x : list) {
                if (x - mid > 0) sum += (x - mid);
            }
            if (sum >= m) {
                lt = mid + 1;
                answer = mid;
            }
            else rt = mid - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Algorithm2805 main = new Algorithm2805();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) list[i] = sc.nextInt();

        System.out.println(main.solution(n, m, list));
    }
}