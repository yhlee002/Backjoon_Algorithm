package BinarySearch;

import java.util.Scanner;

// K번째 수
public class Algorithm1300 {
    private int solution(int n, int k) {
        int lt = 0, rt = k;
        while (lt <= rt) {
            int mid = (lt + rt) / 2; // B[k]값이 될 수 있는 값
            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i , n);
            }

            if (cnt >= k) rt = mid;
            else {
                lt = mid + 1;
            }
        }
        return lt;
    }

    public static void main(String[] args) {
        Algorithm1300 main = new Algorithm1300();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(main.solution(n, k));
    }
}
