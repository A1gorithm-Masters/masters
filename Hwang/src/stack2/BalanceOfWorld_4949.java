package stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalanceOfWorld_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		while (!line.equals(".")) {
			boolean flag = true;
			Stack<Character> stack = new Stack<Character>();
			loop: for(int i = 0; i < line.length() ; i++) {
				char a = line.charAt(i);
				switch (a) {
					case '[' : {
						stack.push(a);
						break;
					}case '(' : {
						stack.push(a);
						break;
					}case ']' : {
						if(stack.empty()) {
							sb.append("no\n");
							flag = false;
							break loop;
						}else if(stack.pop().equals('[')) break;
						else {
						    sb.append("no\n");
						    flag = false;
						    break loop;
						}
					}case ')' : {
						if(stack.empty()) {
							sb.append("no\n");
							flag = false;
							break loop;
						}else if(stack.pop().equals('(')) break;
						else {
							sb.append("no\n");
							flag = false;
							break loop;
						}
					}
				}
			}
			if(flag&&stack.empty()) {
				sb.append("yes\n");
			}else if(flag&&!stack.empty()) {
				sb.append("no\n");
			}
			line = br.readLine();
		}
		System.out.println(sb);
	}
}
