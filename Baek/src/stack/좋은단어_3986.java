import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    //만약 선끼리 교차하지 않으면서 각 글자를 정확히 한 개의 다른 위치에 있는 같은 글자와 짝 지을수 있다면, 그 단어는 '좋은 단어'이다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //좋은 단어 개수
        int resultCnt = 0;
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            Stack<Character> stack = new Stack<>();
            String conStr = br.readLine();

            for (Character c : conStr.toCharArray()) {
                if (!stack.isEmpty()) { // stack 비어있지 않다면...
                    if (stack.peek() == c) //stack의 마지막 값이 현재 문자와 같다면 짝을 이룬다. -> 값을 넣지 않고 마지막값을 제거해준다.
                        stack.pop();
                    else  //stack 의 맨 뒤의 문자와 같지 않을 경우에는 해당 문자를 stack 에 추가한다.
                        stack.push(c);
                } else // stack 비어 있다면...
                    stack.push(c);
            }

            //stack 에 값이 남아있다는 것은 짝을 이루지 못했거나, 선이 교차되어 제거되지 못한 문자들이 있다는 것이므로 '좋은 단어'가 아니다.
            //stack 이 비어있다는 것은 모두 짝을 이루어 혹은 선이 교차되지 않고 짝을 이루어 제거되어 비어있는 것이므로 '좋은 단어'이다.
            if (stack.isEmpty()) resultCnt++;
        }

        System.out.println(resultCnt);
    }
}