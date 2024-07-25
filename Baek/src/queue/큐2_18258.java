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

        Deque<Integer> deque = new ArrayDeque<>();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            switch (st.nextToken()) {
                case "push":
                    deque.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (!deque.isEmpty()) {
                        Integer pop = deque.pollLast();
                        sb.append(pop).append("\n");
                    } else sb.append(-1).append("\n");
                    break;
                case "size":
                    int size = deque.size();
                    sb.append(size).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(!deque.isEmpty()) {
                        Integer last = deque.getLast();
                        sb.append(last).append("\n");
                    } else
                        sb.append(-1).append("\n");
                    break;
                case "back":
                    if(!deque.isEmpty()) {
                        Integer first = deque.getFirst();
                        sb.append(first).append("\n");
                    } else
                        sb.append(-1).append("\n");
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}