package stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){

            Stack<Character> stack = new Stack<>();

            for( char c  : br.readLine().toCharArray()){

                if(stack.isEmpty()) stack.push(c);
                else {
                    if(stack.peek() == '(' && c == ')') stack.pop();
                    else stack.push(c);
                }
            }

            if(stack.isEmpty()) sb.append("YES\n");
            else  sb.append("NO\n");
        }

        System.out.print(sb.toString());

    }
}
