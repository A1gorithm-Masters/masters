package stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상_4949 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st  = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack;

        while( true){

            String str = br.readLine();
            if( str.equals(".") ) break;

            stack = new Stack<>();
            str = str.replaceAll("[a-zA-Z.]","").replaceAll(" ",""); // 문자 제거 + 공백 제거

            boolean check = true;

            for(char c : str.toCharArray()){

                if(c == '(' || c == '[') stack.push(c);
                else if( c == ')' || c == ']') {

                    if (stack.isEmpty()) {
                        check = false;
                        break;
                    }
                    else if (c == ')' && stack.peek() == '(') stack.pop();
                    else if (c == ']' && stack.peek() == '[') stack.pop();
                    else {
                        check = false;
                        break ;
                    }
                }
            }

            if(check && !stack.isEmpty()) check = false; // [][. , (.

            if(check) {
                System.out.println("yes");
                //sb.append("yes\n");
            }
            else {
                System.out.println("no");
                //sb.append("no\n");
            }

        }

        //System.out.println(sb.toString());
    }
}
