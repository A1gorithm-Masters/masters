import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
[입력]
각 문자열은 마지막 글자를 제외하고 영문 알파벳, 공백, 소괄호("( )"), 대괄호("[ ]")로 이루어져 있으며, 온점(".")으로 끝나고, 길이는 100글자보다 작거나 같다.
입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.

[출력]
각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //StringTokenizer 이해하기 어렵네요...
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;
            StringTokenizer st = new StringTokenizer(line, ".");

            //문자열이 균형을 이루고 있는지 체크 로직
            if (st.hasMoreTokens()) {
                String str = st.nextToken();
                Stack<Character> stack = new Stack<>();

                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(' || str.charAt(i) == '[') stack.push(str.charAt(i));

                    if (str.charAt(i) == ')') {
                        if (stack.isEmpty() || stack.peek() != '(' ) { //만약 짝이 맞지않거나 stack에 괄호가 없다면(비어 있다면) 균형을 이루고 있지 않는것이기 때문에 no 출력 후 다음 문자열로 넘어간다.
                            sb.append("no\n");
                            break;
                        } else stack.pop();
                    } else if (str.charAt(i) == ']') {
                        if (stack.isEmpty() || stack.peek() != '[') { //만약 짝이 맞지않거나 stack에 괄호가 없다면(비어 있다면) 균형을 이루고 있지 않는것이기 때문에 no 출력 후 다음 문자열로 넘어간다.
                            sb.append("no\n");
                            break;
                        } else stack.pop();
                    }

                    //마지막 숫자가 끝났다면..
                    if (i == str.length()-1) {
                        if (stack.isEmpty()) sb.append("yes\n");
                        else sb.append("no\n");
                    }
                }
            }
        } //while 종료
        //결과 출력
        System.out.print(sb);
        br.close();
    }

}