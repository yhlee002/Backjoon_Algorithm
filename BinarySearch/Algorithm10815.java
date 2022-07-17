package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Algorithm10815 {
  private static int solution(int[] arr, int num) {
    int lt = 0, rt = arr.length - 1;
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if(num > arr[mid]) lt = mid + 1;
      else if (num < arr[mid]) rt = mid - 1;
      else return 1;
    }
    return 0;
  }

  public static void main(String[] args) {
    Algorithm10815 main = new Algorithm10815();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] cards = new int[n];
    for (int i = 0; i < n; i++) cards[i] = sc.nextInt();
    Arrays.sort(cards);

    StringBuilder sb = new StringBuilder();
    int k = sc.nextInt();
    for (int i = 0; i < k; i++) {
      int num = sc.nextInt();

      sb.append(main.solution(cards, num) + " ");
    }
    System.out.println(sb.toString());
  }
}