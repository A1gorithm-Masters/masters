package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class miro_2178 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][][] miro = new int[n][m][2];
		int[] a = new int[] {0, 1, 0, -1};
		int[] b = new int[] {1, 0, -1, 0};
		int num=0;
		
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j = 0; j < m; j++) {
				miro[i][j][0] = (line.charAt(j))-48;
			}
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0,0,1});
		while (!q.isEmpty()) {
			int[] current = q.poll();
			for(int k = 0; k < 4; k++) {
				int na = current[0] + a[k];
				int nb = current[1] + b[k];
				num = current[2];
				if(na<0||na>=n||nb<0||nb>=m) continue;
				if(miro[na][nb][0]==-1&&miro[na][nb][1]>num+1) {
					miro[na][nb][0]=1;
				}
				if(miro[na][nb][0]==1) {
					num++;
					miro[na][nb][0] = -1;
					miro[na][nb][1] = num;
					q.offer(new int[] {na,nb, num});
				}
			}
		}
		System.out.println(miro[n-1][m-1][1]);
	}
}
