package deleteNodeatEndofLinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            list.add(value);
        }
        if (!list.isEmpty()) {
            list.removeLast();
        }

        printlist(list);
        sc.close();
    }

    private static void printlist(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            System.out.println("null");
        } else {
            for (int value : list) {
                System.out.print(value + " ");
            }
        }
    }
}