import java.io.*;
import java.util.*;

//큐
public class 카드2_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++) queue.add(i);

        while(queue.size() > 1){

            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.peek());

    }
}