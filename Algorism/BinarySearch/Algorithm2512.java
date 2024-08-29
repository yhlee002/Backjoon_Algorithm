package Algorism.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

// 예산
public class Algorithm2512 {
    private int solution(int n, int[] arr, int m) {
        int answer = Integer.MIN_VALUE;
        Arrays.sort(arr);
        int lt = 0, rt = arr[n - 1];

        if (Arrays.stream(arr).sum() >= m) {
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                int sum = 0;
                for (int x : arr) {
                    int val = x > mid ? mid : x;
                    sum += val;
                }

                if (sum > m) {
                    rt = mid - 1;
                } else {
                    answer = answer > mid ? answer : mid;
                    lt = mid + 1;
                }
            }
        } else {
            answer = Arrays.stream(arr).max().getAsInt();
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm2512 main = new Algorithm2512();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) list[i] = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(main.solution(n, list, m));
    }
}