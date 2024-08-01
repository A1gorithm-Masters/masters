package stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Goodword_3986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < num ; i++) {
			String line = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			loop: for(int j = 0; j < line.length() ; j++) {
				char a = line.charAt(j);
				switch (a) {
					case 'A' : {
						if(stack.empty()) {
							stack.push(a);							
						}else {
							if(stack.peek().equals('A')) {
								stack.pop();
							}else {
								stack.push(a);
							}
						}
						break;
					}case 'B' : {
						if(stack.empty()) {
							stack.push(a);							
						}else {
							if(stack.peek().equals('B')) {
								stack.pop();
							}else {
								stack.push(a);
							}
						}
						break;
					}
				}
			}
			if(stack.empty()) {
				sum++;
			}
		}
		System.out.println(sum);
	}
}
