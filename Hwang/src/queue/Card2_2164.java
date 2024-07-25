package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Card2_2164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> qu = new LinkedList<Integer>();
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= num ; i++) {
			qu.offer(i);
		}
		
		while(qu.size()>1) {
			qu.remove();
			qu.offer(qu.remove());
		}
		System.out.println(qu.remove());
	}
}
