import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int count = sc.nextInt();

        //입력 받은 수를 저장할 컬렉션...
        List<Integer> list = new ArrayList<>();

        //입력 받은 수와 동일 한 순서를 만들기 위한 stack 생성...
        Stack<Integer> stack = new Stack<>();
        int value = 1;

        //값 입력
        for (int i = 0; i < count; i++) {
            int num = sc.nextInt();
            list.add(num);
        }

        for (int i = 0; i < list.size(); i++) {
            // -1 값이 나온다면 아직 stack 내부에 해당 숫자가 없다는 뜻이므로 다음 숫자 추가를 해준다. (숫자 추가는 1~N 순서대로 추가..)
            if (stack.search(list.get(i)) == -1) {
                sb.append("+\n");
                if (value <= count)
                    stack.push(value++);
            }

            // search() 적극 활용
            // 현재 찾고 있는 숫자가 stack 의 맨 위에 있다면 pop() 호출 후 - 출력
            // 현재 찾고 있는 숫자가 있긴 하지만 stack 맨 위에 없다면 수열을 만들 수 없는 상황이므로 NO 출력
            // 현재 찾고있는 숫자가 없다면 i의 값을 그대로 두기 위해서 i-- 하고 반복문 반복
            // i의 값(현재 stack 에서 찾고있는 값)은 반드시 찾고 넘어가야 한다.
            if (stack.lastElement().equals(list.get(i))) {
                stack.pop();
                if (i == list.size()-1) sb.append("-");
                else sb.append("-\n");
                continue;
            }

            else if (stack.search(list.get(i)) != -1){
                sb.setLength(0);
                sb.append("NO");
                break;
            }

            i--;
        }

        System.out.println(sb);
    }
}