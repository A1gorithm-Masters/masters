
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            switch (st.nextToken()) {
                case "push_front":
                    deque.push(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(!deque.isEmpty()) {
                        Integer pop = deque.pop();
                        sb.append(pop).append("\n");
                    } else sb.append(-1).append("\n");
                    break;
                case "pop_back":
                    if (!deque.isEmpty()) {
                        Integer pollLast = deque.pollLast();
                        sb.append(pollLast).append("\n");
                    } else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if (!deque.isEmpty()) sb.append(deque.getFirst()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "back":
                    if (!deque.isEmpty()) sb.append(deque.getLast()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}
