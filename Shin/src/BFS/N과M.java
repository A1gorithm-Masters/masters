package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M {
    static int[] arr;
    static boolean[] visit;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int [M+1];
        visit = new boolean[N+1];

        DFS1(1);                //N과 M(1)
        DFS2(1,1);          //N과 M(2)
        DFS3(1);                //N과 M(3)
        DFS4(1,1);           //N과 M(4)

        System.out.print(sb.toString());
    }
    public static void DFS1(int depth){
        if( depth == M+1){
            for(int i =1; i<=M; i++){
                sb.append(arr[i]+ " ");
            }
            sb.append("\n");
            return;
        }
        for(int i =1; i<=N; i++){
            if(visit[i]) continue;

            visit[i] = true;

            arr[depth] = i;
            DFS1(depth + 1);

            visit[i] = false;
        }

    }

    public static void DFS2(int depth, int at) {
        if( depth == M+1){
            for(int i=1; i<=M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }
        for(int i =at; i<=N; i++){
            if(visit[i]) continue;

            visit[i] = true;
            arr[depth] = i;
            DFS2(depth +1, i);
            visit[i] = false;
        }

    }

    public static void DFS3(int depth){
        if(depth == M+1){
            for(int i =1; i<=M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=N; i++){
            arr[depth]= i;
            DFS3(depth +1);
        }
    }

    public static void DFS4(int at , int depth){
        if(depth == M+1){
            for(int i =1; i<=M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }

        for(int i = at; i<= N; i++){
            arr[depth] = i;
            DFS4( i, depth +1);
        }
    }
}
