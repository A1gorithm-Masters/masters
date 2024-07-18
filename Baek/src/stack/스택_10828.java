import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<String> stack = new Stack<>();

        int forCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < forCnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String command = st.nextToken();

            switch (command) {
                case "push":
                    String str = st.nextToken();
                    stack.push(str);
                    break;
                case "pop":
                    if (stack.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "top":
                    if (stack.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(stack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}