package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로_10773 {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<k; i++){
            int value = Integer.parseInt(br.readLine());

            if(value == 0 && !stack.isEmpty()) stack.pop();
            else stack.push(value);
        }

        //System.out.println(stack);
        int sum =0;
        int size = stack.size();
        for(int i=0; i<size; i++){

            sum+= stack.pop();
        }

        System.out.println(sum);
    }
}
