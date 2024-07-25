package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class RotatingQueue_1021 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> de = new LinkedList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		for(int i = 1 ; i <= n ; i++) {
			de.offer(i);
		}
		
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for(int i = 0 ; i < m ; i++) {
			int num = Integer.parseInt(st.nextToken());
			Deque<Integer> fDeq = new LinkedList<Integer>();
			Deque<Integer> lDeq = new LinkedList<Integer>();
			fDeq.addAll(de);
			lDeq.addAll(de);
			int fnum = 0;
			int lnum = 0;
			while(fDeq.getFirst()!= num) {
				fDeq.offerLast(fDeq.removeFirst());
				fnum++;
			}
			
			while(lDeq.getLast()!= num) {
				lDeq.offerFirst(lDeq.removeLast());
				lnum++;
			}
			lDeq.offerFirst(lDeq.removeLast());
			lnum++;
			
			if(fnum<lnum) {
				sum += fnum;
				de = fDeq;
				de.removeFirst();
			} else {
				sum += lnum;
				de = lDeq;
				de.removeFirst();
			}
		}
		System.out.println(sum);
	}
}