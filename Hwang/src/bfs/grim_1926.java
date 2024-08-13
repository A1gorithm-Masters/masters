package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class grim_1926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] grim = new int[n][m];
		int[] a = new int[] {0, 1, 0, -1};
		int[] b = new int[] {1, 0, -1, 0};
		int maxsize = 0;
		int num = 0;
		
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				grim[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < m ; j++) {
				if(grim[i][j]==0||grim[i][j]==-1) continue;
				num++;
				grim[i][j] = -1;
				int[] current = new int[] {i,j};
				q.offer(current);
				int size = 0;
				while (!q.isEmpty()) {
					current = q.poll();
					size++;
					for(int k = 0; k < 4; k++) {
						int na = current[0] + a[k];
						int nb = current[1] + b[k];
						if(na<0||na>=n||nb<0||nb>=m) continue;
						if(grim[na][nb]==1) {
							grim[na][nb] = -1;
							q.offer(new int[] {na,nb});
						}
					}
				}
				if(maxsize<size) maxsize = size;
			}
		}
		System.out.println(num);
		System.out.println(maxsize);
	}
}
