package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Queue2_18258 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> qu = new LinkedList<Integer>();
		int last = 0;
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < num ; i++) {
			String x = br.readLine();
			switch (x) {
				case "pop": {
					if(!qu.isEmpty()) {
						sb.append(qu.remove() + "\n");
					}else sb.append(-1 + "\n");
					break;
				}case "size": {
					sb.append(qu.size() + "\n");
					break;
				}case "empty": {
					if(qu.isEmpty()) {
						sb.append(1 + "\n");
					}else sb.append(0 + "\n");
					break;
				}case "front": {
					if(!qu.isEmpty()) {
						sb.append(qu.peek() + "\n");
					}else sb.append(-1 + "\n");
					break;
				}case "back": {
					if(!qu.isEmpty()) {
						sb.append(last + "\n");
					}else sb.append(-1 + "\n");
					break;
				}default:{
					int n = Integer.parseInt(x.split(" ")[1]);
					last = n;
					qu.offer(n);
				}
			}
		}
		System.out.println(sb);
	}
}
