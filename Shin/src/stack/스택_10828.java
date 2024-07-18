package stack;

import java.io.*;
import java.util.*;

//1. 스택
public class 스택_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int  N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrList = new ArrayList<>();
        int pos = 0;
        for(int i= 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push" :
                    arrList.add(pos++, Integer.valueOf(st.nextToken()));
                    break;

                case "pop" :
                    if(pos ==0 ) sb.append("-1\n");
                    else sb.append(arrList.remove(--pos) + "\n");
                    break;

                case "size" :
                    sb.append(pos + "\n");
                    break;

                case "empty" :
                    if(pos == 0) sb.append("1\n");
                    else sb.append("0\n");
                    break;

                case "top" :
                    if(pos ==0)sb.append("-1\n");
                    else sb.append(arrList.get(pos-1) + "\n");
                    break;
            }
        }

        System.out.print(sb.toString());

    }
}