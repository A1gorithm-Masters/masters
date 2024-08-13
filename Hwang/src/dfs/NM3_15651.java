package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM3_15651 {
	static int n;
	static int m;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int index) {
		if(index==m) {
			for(int i : result) {
				sb.append(i + " ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < n; i++) {
			result[index] = i + 1;
			dfs(index+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		result = new int[m];
		
		dfs(0);
		System.out.println(sb);
		
	}
}
