package dfs;
//https://st-lab.tistory.com/114

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM_15649 {
	static int n;
	static int m;
	static boolean[] visited;
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
			if(!visited[i]) {
				visited[i] = true; 
				result[index] = i + 1;
				dfs(index+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		result = new int[m];
		visited = new boolean[n];
		
		dfs(0);
		System.out.println(sb);
		
	}
}
