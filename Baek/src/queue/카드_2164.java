import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();

        //큐에 값 넣기
        for (int i = 1; i <= num; i++)
            queue.add(i);

        while (queue.size() != 1) {
            // 1. 맨 위의 카드를 제거
            queue.remove();

            if ((queue.size() == 1)) break;

            // 2. 그 다음 맨 위의 카드를 제거 후 맨 아래에 추가
            Integer poll = queue.poll();
            queue.add(poll);
        }

        System.out.println(queue.element());
    }
}