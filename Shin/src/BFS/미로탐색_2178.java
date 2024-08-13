package BFS;

import java.util.*;
import java.io.*;

public class 미로탐색_2178 {
    static int N;       //가로
    static int M;       //세로
    static String []arr;
    static boolean visit[][];
    static int [][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static int [][]dist;        //최단 칸수 저장

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 세로
        M = Integer.parseInt(st.nextToken());   // 가로

        arr= new String[N];
        visit = new boolean[N][M];
        dist = new int[N][M];

        for(int i =0; i<N; i++){
            arr[i] = br.readLine();
        }

        BFS(0,0);

        //출력
        System.out.println(dist[N-1][M-1]);
    }

    static void BFS(int x, int y){
        Queue<Integer> queue = new LinkedList<>();

        //dist 배열 초기화
        for(int i =0; i<N; i++)
            Arrays.fill(dist[i],-1);

        queue.add(x);
        queue.add(y);
        dist[x][y] =1;  //칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
        visit[x][y] = true;

        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

            //갈 수 있는 곳 탐색
            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx <0 || ny < 0 || nx >=N || ny >=M) continue;
                if(visit[nx][ny]) continue;
                if(arr[nx].charAt(ny) == '0') continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] +1;
            }
        }
    }
}
