package gullyboybhothard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String stat = sc.nextLine();
        int p = sc.nextInt();
        int n = sc.nextInt();

        List<Character> character = new ArrayList<>();

        for (char ch : stat.toCharArray()) {
            if (ch != ' ') {
                character.add(ch);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = p - 1; j < character.size(); j++) {
                System.out.print(character.get(j) + " ");
            }

            for (int j = 0; j < p - 1; j++) {
                System.out.print(character.get(j) + " ");
            }
        }
    }
}