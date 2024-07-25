package deque;

import java.io.*;
import java.util.*;

public class 회전하는큐2_1021 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // deqeue 사이즈 N
        int M = Integer.parseInt(st.nextToken());   // 뽑아내려는 개수

        Deque<Integer> dq = new LinkedList<>();

        int answer = 0;
        for (int i = 1; i <= N; i++) dq.add(i);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int cnt = 0;

            while (dq.peekFirst() != num) {  //2, 3번 연산
                dq.add(dq.remove());
                cnt++;
            }

            answer += Math.min(cnt, dq.size() - cnt); // 2번 연산과 3번 연산 중 횟수가 작은 것  선택

            dq.removeFirst();   // 1번 연산 뽑아내기
        }

        System.out.println(answer);
    }
}
