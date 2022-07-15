package BinarySearch;

import java.util.*;

// 수 찾기
public class Algorithm1920 {
    private List<Integer> solution(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<Integer>();

        Arrays.sort(arr1);
        for (int i = 0; i < arr2.length; i++) {
            int lt = 0, cnt = 0;
            int rt = arr1.length - 1;
            while(lt <= rt) {
                int mid = (lt + rt) / 2;

                if (arr2[i] < arr1[mid]) rt = mid - 1;
                else if(arr2[i] > arr1[mid]) lt = mid + 1;
                else {
                    cnt++;
                    break;
                }
            }
            answer.add(cnt);
        }


        return answer;
    }



    public static void main(String[] args) {
        Algorithm1920 main = new Algorithm1920();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();
        int k = sc.nextInt();
        int[] arr2 = new int[k];
        for(int i = 0; i < k; i++) arr2[i] = sc.nextInt();

        for (int x : main.solution(arr1, arr2)) System.out.println(x);


    }
}