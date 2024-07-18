package stack;

import java.util.*;
import java.io.*;

public class 탑_2493 {

    static class Top{
        int height;
        int idx;

        Top(int height, int idx){
            this.height = height;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Top> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){

            int h = Integer.parseInt(st.nextToken());

            //stack이 비어있으면,
            if(stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Top(h,i));
            }
            else { // 스택이 비어 있지 않고,

                while(true) {

                    if (stack.peek().height > h) { //기존 탑의 높이 > 현재 높이
                        sb.append(stack.peek().idx + " ");
                        stack.push(new Top(h, i));
                        break;
                    }
                    else stack.pop(); //기존 높이 < 현재 높이

                    if(stack.isEmpty()){
                        sb.append("0 ");
                        stack.push(new Top(h,i));
                        break;
                    }

                }
            }
        }
        System.out.print(sb.toString());

    }
}