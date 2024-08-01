import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean completeFlag = true;

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            Stack<Character> stack = new Stack<>();

            String line = br.readLine();
            for (char c : line.toCharArray()) {
                //열린 괄호면 stack 에 push
                if (c == '(') stack.push(c);

                /*
                    닫힌 괄호였을때...
                    1) 만약 stack이 비어있다면 NO 출력 후 completeFlag false 로 변경하고 반복문 종료
                        - 어차피 올바른 괄호 문자열이 아니기 때문에 뒤에 문자를 볼 필요가 없다.
                        - 문자열을 다 돌아서 끝난것이 아닌 중간에 올바른 괄호 문자열이 아니라고 판단하고 종료하는 것이기 때문에 completeFlag를 false 로 변경함으로 써 중간에 종료했다는 것을 표시..
                    2) stack 이 비어있지 않다면 마지막 요소를 하나 제거
                        - 어차피 stack에 요소는 '(' 밖에 들어가지 못하기 때문에 stack에 값이 있다느 것은 쌍을 만들 수 있다는 것이기에 pop() 진행
                 */
                if (c == ')') {
                    if (!stack.isEmpty()) stack.pop();
                    else {
                        sb.append("NO\n");
                        completeFlag = false;
                        break;
                    }
                }
            }

            // 한 문장이 다 끝났는데, stack 이 비어있지 않다면 -> '(' 가 더 많았다는 뜻 -> 올바른 괄호 문자열(VPS)이 아니다.
            // 문장을 다 돌아서 나온것이 아닌, 중간에 올바른 괄호 문자열이 아니여서 break 문을 통해 나올 수 있으므로 completeFlag 가 true 인지 검증
            if (completeFlag && !stack.isEmpty()) sb.append("NO\n");
            else if (completeFlag && stack.isEmpty()) sb.append("YES\n");
            completeFlag = true;
        }
        System.out.println(sb);
    }
}