package reverseAdoublylinkedist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printDoublyLinkedList(Result.DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    public static Result.DoublyLinkedListNode reverse(Result.DoublyLinkedListNode llist) {
        // Write your code here
        if (llist == null || llist.next == null) {
            return llist;
        }
        Result.DoublyLinkedListNode currentNode = llist;
        Result.DoublyLinkedListNode temp = null;

        while (currentNode != null) {
            temp = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = temp;
            currentNode = currentNode.prev;
        }


        if (temp != null) {
            llist = temp.prev;
        }
        return llist;

    }

    class Result {


        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                DoublyLinkedList llist = new DoublyLinkedList();

                int llistCount = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < llistCount; i++) {
                    int llistItem = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    llist.insertNode(llistItem);
                }

                DoublyLinkedListNode llist1 = reverse(llist.head);

                printDoublyLinkedList(llist1, " ", bufferedWriter);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            scanner.close();
        }

        static class DoublyLinkedListNode {
            public int data;
            public DoublyLinkedListNode next;
            public DoublyLinkedListNode prev;

            public DoublyLinkedListNode(int nodeData) {
                this.data = nodeData;
                this.next = null;
                this.prev = null;
            }
        }

        static class DoublyLinkedList {
            public DoublyLinkedListNode head;
            public DoublyLinkedListNode tail;

            public DoublyLinkedList() {
                this.head = null;
                this.tail = null;
            }

            public void insertNode(int nodeData) {
                DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

                if (this.head == null) {
                    this.head = node;
                } else {
                    this.tail.next = node;
                    node.prev = this.tail;
                }

                this.tail = node;
            }
        }
    }
}