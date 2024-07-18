package stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택수열_1874 {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer>stack = new Stack<>();

        boolean isPossible = true;
        int currnet =1;
        loop:
        for(int i=0; i<n; i++){
            int value = Integer.parseInt(br.readLine());

//            if( stack.isEmpty() || stack.peek() <= value) {
//                int start = stack.peek();
//                for(int j = start; j<=value; j++){
//                    stack.push(j);
//                    sb.append("+\n");
//                    //System.out.println("+");
//                }
//            }

            while(currnet <= value){
                stack.push(currnet++);
                sb.append("+\n");
                //System.out.println("+");
            }

            if( stack.peek() == value){
                stack.pop();
                sb.append("-\n");
                //System.out.println("-");
            }
            else if( stack.peek() > value){
                isPossible = false;
                break loop;
            }
        }

        if( isPossible) System.out.print(sb.toString());
        else System.out.print("No");
    }
}
