package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

// 랜선 자르기
public class Algorithm1654 {
    private long solution(int k, int n, int[] list) {
        long answer = 0;

        long lt = 1; // 문제에서 모든 랜선의 길이는 '자연수'라고 했기 때문에 0이 아닌 1로 초기화시켜야 한다.
        long rt = Arrays.stream(list).max().getAsInt(); // 가장 긴 랜선

        // 가지고 있는 랜선(k개)을 모두 같은 길이인 n개의 랜선으로 만들고자 함. ex. 300cm x 1개 -> 140cm x 2개
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += (list[i] / mid); // 몫을 더함
            }

            if (cnt >= n) {
                lt = mid + 1;
                answer = mid;
            } else rt = mid - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm1654 main = new Algorithm1654();
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] list = new int[k];
        for (int i = 0; i < k; i++) list[i] = sc.nextInt();

        System.out.println(main.solution(k, n, list));
    }
}
