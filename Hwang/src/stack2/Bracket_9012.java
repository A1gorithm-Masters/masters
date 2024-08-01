package stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num ; i++) {
			String line = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			boolean flag = true;
			loop: for(int j = 0; j < line.length() ; j++) {
				char a = line.charAt(j);
				switch (a) {
					case '(' : {
						stack.push(a);
						break;
					}case ')' : {
						if(stack.empty()) {
							sb.append("NO\n");
							flag = false;
							break loop;
						}else if(stack.pop().equals('(')) break;
						else {
							sb.append("NO\n");
							flag = false;
							break loop;
						}
					}
				}
			}
			if(flag&&stack.empty()) {
				sb.append("YES\n");
			}else if(flag&&!stack.empty()) {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
}
