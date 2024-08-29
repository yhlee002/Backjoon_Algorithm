package Algorism.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;
// 두 용액
public class Algorithm2470 {
    private void solution(int n, int[] list) {
        int min = Integer.MAX_VALUE;

        int minVal = 0, minVal2 = 0;
        int lt = 0, rt = n - 1;
        Arrays.sort(list);

        while(lt < rt) {
            int sum = list[lt] + list[rt];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                minVal = list[lt];
                minVal2 = list[rt];
            }

            if (sum > 0) rt -= 1;
            else lt += 1;
        }

        System.out.print(minVal + " " + minVal2);
    }

    public static void main(String[] args) {
        Algorithm2470 main = new Algorithm2470();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        main.solution(n, arr);
    }
}

