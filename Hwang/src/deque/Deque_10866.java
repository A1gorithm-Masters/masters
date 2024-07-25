package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Deque_10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> de = new LinkedList<Integer>();
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < num ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
				case "pop_front": {
					if(!de.isEmpty()) {
						sb.append(de.removeFirst() + "\n");
					}else sb.append(-1 + "\n");
					break;
				}case "pop_back": {
					if(!de.isEmpty()) {
						sb.append(de.removeLast() + "\n");
					}else sb.append(-1 + "\n");
					break;
				}case "push_front": {
					de.offerFirst(Integer.parseInt(st.nextToken()));
					break;
				}case "push_back": {
					de.offerLast(Integer.parseInt(st.nextToken()));
					break;
				}case "size": {
					sb.append(de.size() + "\n");
					break;
				}case "empty": {
					if(de.isEmpty()) {
						sb.append(1 + "\n");
					}else sb.append(0 + "\n");
					break;
				}case "front": {
					if(!de.isEmpty()) {
						sb.append(de.peekFirst() + "\n");
					}else sb.append(-1 + "\n");
					break;
				}case "back": {
					if(!de.isEmpty()) {
						sb.append(de.peekLast() + "\n");
					}else sb.append(-1 + "\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
