package maximumelement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<Integer> getMax(List<String> operations) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int maxElement = Integer.MIN_VALUE;

        for (String operation : operations) {
            String[] tokens = operation.split(" ");
            int type = Integer.parseInt(tokens[0]);

            if (type == 1) {
                int value = Integer.parseInt(tokens[1]);
                stack.push(value);

                if (value > maxElement) {
                    maxElement = value;
                }
            } else if (type == 2) {
                if (!stack.isEmpty()) {
                    int poppedElement = stack.pop();

                    // If the popped element is the maxElement, update maxElement by checking the stack
                    if (poppedElement == maxElement) {
                        maxElement = findMaxInStack(stack);
                    }
                }
            } else if (type == 3) {
                result.add(maxElement);
            }
        }

        return result;

    }

    private static int findMaxInStack(Stack<Integer> stack) {
        int max = Integer.MIN_VALUE;
        for (int element : stack) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(res.stream().map(Object::toString).collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
