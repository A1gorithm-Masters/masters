import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 탑의 정보를 담기 위해 Stack<int[]> 선언
        // 0번째 인덱스에는 탑의 순서(번호), 1번째 인덱스에는 탑의 높이가 저장된다.
        Stack<int[]> stack = new Stack<>();

        //탑의 개수를 입력
        int topCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 1; i <= topCnt; i++) {
            int tower = Integer.parseInt(st.nextToken());

            // 처음 들어온 탑이 아니라면 + stack 이 비어있지 않다면... -> 최소 탑의 번호는 2~
            while (!stack.isEmpty()) {
                // stack 맨위에 있는 탑의 높이가 현재 들어온 탑의 높이보다 크다면 (레이저 수신 가능)
                if (stack.peek()[1] > tower) {
                    //현재 들어온 탑의 번호에 레이저 수신이 가능한 stack에 있는 탑의 번호(인덱스)를 저장
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
                //기존에 있던 마지막 탑을 제거
                stack.pop();
            }

            //top이 맨 처음 들어올 때 한번 실행
            if (stack.isEmpty()) {
                sb.append("0 ");
            }

            // i: 탑의 번호, tower: 탑의 높이
            stack.push(new int[] {i, tower});
        }
        System.out.println(sb);
    }
}