import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        int forCnt = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < forCnt; i++) {
            int input = Integer.parseInt(br.readLine());

            switch (input) {
                case 0:
                    if (!stack.isEmpty()) stack.pop();
                    break;

                default:
                    stack.push(input);
                    break;
            }
        }

        for (int i : stack) {
            sum += i;
        }
        System.out.println(sum);
    }
}