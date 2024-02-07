package continuousSubArray;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String stat = sc.nextLine();
        int size = sc.nextInt();

        String[] statArr = stat.split("\\s+");

        int[] arr = new int[statArr.length];

        for (int i = 0; i < statArr.length; i++) {
            arr[i] = Integer.parseInt(statArr[i]);
        }

        int max = findMaxSubArraySum(arr, size);
        System.out.println(max);

        int[] maxSubArray = findMaxSubArray(arr, size);
        for (int i = 0; i < maxSubArray.length; i++) {
            System.out.print(maxSubArray[i] + " ");
        }
    }

    public static int findMaxSubArraySum(int[] arr, int size) {
        int max = Integer.MIN_VALUE;
        int maxEnd = 0;
        int start = 0, end = 0;
        int s = 0;

        for (int i = 0; i < size; i++) {
            maxEnd += arr[i];

            if (max < maxEnd) {
                max = maxEnd;
                start = s;
                end = i;
            }

            if (maxEnd < 0) {
                maxEnd = 0;
                s = i + 1;
            }
        }

        return max;
    }

    public static int[] findMaxSubArray(int[] arr, int size) {
        int start = 0, end = 0;
        int s = 0;
        int max = Integer.MIN_VALUE;
        int maxEnd = 0;

        for (int i = 0; i < size; i++) {
            maxEnd += arr[i];

            if (max < maxEnd) {
                max = maxEnd;
                start = s;
                end = i;
            }

            if (maxEnd < 0) {
                maxEnd = 0;
                s = i + 1;
            }
        }

        int[] maxSubArray = new int[end - start + 1];
        if (end + 1 - start >= 0) System.arraycopy(arr, start, maxSubArray, start - start, end + 1 - start);

        return maxSubArray;
    }
}