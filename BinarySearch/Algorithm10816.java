package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Algorithm10816 {
  private static int getUpperBound(int[] arr, int num) {
    int lt = 0, rt = arr.length - 1;
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if(num >= arr[mid]) lt = mid + 1;
      else rt = mid - 1;
    }
    return lt - 1;
  }

  private static int getLowerBound(int[] arr, int num) {
    int lt = 0, rt = arr.length - 1;
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (num <= arr[mid]) rt = mid - 1;
      else lt = mid + 1;
    }
    return rt + 1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] cards = new int[n];
    for (int i = 0; i < n; i++) cards[i] = sc.nextInt();
    Arrays.sort(cards);

    StringBuilder sb = new StringBuilder();
    int k = sc.nextInt();
    for (int i = 0; i < k; i++) {
      int num = sc.nextInt();

      int upperBound = getUpperBound(cards, num);
      int lowerBound = getLowerBound(cards, num);
      sb.append((upperBound - lowerBound + 1) + " ");
    }
    System.out.println(sb.toString());
  }
}