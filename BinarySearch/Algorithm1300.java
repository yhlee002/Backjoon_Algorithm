package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

// K번째 수
// 세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다.
// B를 오름차순 정렬했을 때, B[k]를 구해보자.
// 배열 A와 B의 인덱스는 1부터 시작한다.
public class Algorithm1300 {
    private int solution(int n, int k) {
        int answer = 0;

        int lt = 0, rt = n * n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2; // B[k]값이 될 수 있는 값
            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i * j <= mid) cnt++;
                }
            }

            if (cnt < k) lt = mid + 1;
            else {
                rt = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Algorithm1300 main = new Algorithm1300();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(main.solution(n, k));
    }
}
