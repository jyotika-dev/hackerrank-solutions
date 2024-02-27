package balancedbrackets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

class Result {


    public static String isBalanced(String s) {
        // Write your code here public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // Check if the character is an opening bracket
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // Check if the stack is not empty and the current character matches the corresponding opening bracket
                if (!stack.isEmpty() && isMatchingBracket(stack.peek(), c)) {
                    stack.pop(); // Pop the matching opening bracket
                } else {
                    return "NO"; // Unbalanced brackets
                }
            }
        }

        // Check if the stack is empty, meaning all opening brackets have matching closing brackets
        return stack.isEmpty() ? "YES" : "NO";

    }

    private static boolean isMatchingBracket(char opening, char closing) {
        return (opening == '(' && closing == ')') || (opening == '[' && closing == ']') || (opening == '{' && closing == '}');
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
