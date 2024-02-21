package equalstacks;

import java.io.*;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        // Initialize the cumulative heights of each stack
        int cumulativeHeight1 = 0;
        int cumulativeHeight2 = 0;
        int cumulativeHeight3 = 0;

        // Populate stacks and calculate cumulative heights
        for (int i = h1.size() - 1; i >= 0; i--) {
            stack1.push(h1.get(i));
            cumulativeHeight1 += h1.get(i);
        }

        for (int i = h2.size() - 1; i >= 0; i--) {
            stack2.push(h2.get(i));
            cumulativeHeight2 += h2.get(i);
        }

        for (int i = h3.size() - 1; i >= 0; i--) {
            stack3.push(h3.get(i));
            cumulativeHeight3 += h3.get(i);
        }

        // Check for equal heights
        while (!(cumulativeHeight1 == cumulativeHeight2 && cumulativeHeight2 == cumulativeHeight3)) {
            // Find the stack with the maximum cumulative height and pop the top element
            if (cumulativeHeight1 >= cumulativeHeight2 && cumulativeHeight1 >= cumulativeHeight3) {
                cumulativeHeight1 -= stack1.pop();
            } else if (cumulativeHeight2 >= cumulativeHeight1 && cumulativeHeight2 >= cumulativeHeight3) {
                cumulativeHeight2 -= stack2.pop();
            } else {
                cumulativeHeight3 -= stack3.pop();
            }
        }

        return cumulativeHeight1;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
