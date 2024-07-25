import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        // 1 ~ size 까지의 숫자를 덱에 가지고 있는다
        int size = sc.nextInt();

        //뽑아내려고 하는 숫자의 개수
        int numSize = sc.nextInt();

        //size 까지의 숫자 저장
        for (int i = 1; i <= size; i++)
            deque.add(i);

        //뽑아야 할 숫자를 넣어둘 배열
        List<Integer> targetList = new ArrayList<>();
        //결과를 저장할 배열
        List<Integer> resultList = new ArrayList<>();

        //뽑으려고 하는 숫자 입력
        for (int i = 0; i < numSize; i++) {
            int num = sc.nextInt();
            targetList.add(num);
        }

        int idx = 0;
        int resultCnt = 0;

        //10 3
        //2 9 5
        // 뽑으려고 하는 숫자의 개수보다 작다면..
        while (idx < numSize) {

            Integer target = targetList.get(idx);

            //덱에 있는 첫 번째 원소가(Last) 뽑으려는 숫자와 일치 하다면
            if (deque.getFirst() == target) {
                Integer poll = deque.poll();
                resultList.add(poll);
                idx++; //만약 일치하는 값을 뽑아냈다면..
            } else { //덱에 있는 첫 번째 원소가(Last) 뽑으려는 숫자와 일치 하지 않는다면...
                List<Integer> tmpList = new ArrayList<> (deque);
                resultCnt++;

                // 오른쪽으로 이동
                if ( tmpList.indexOf(targetList.get(idx)) > Math.abs(tmpList.indexOf(targetList.get(idx)) - (tmpList.size() -1))) {
                    Integer pollLast = deque.pollLast(); //덱에 가장 앞에있는 (나중에 들어간 값) 값을 뺀다.
                    deque.addFirst(pollLast); // 덱에 가장 뒤에 (가장 먼저 들어가는..) 값을 추가한다.
                } else { // 왼쪽으로 이동
                    Integer poll = deque.poll(); //덱에 가장 뒤에있는 (가장 먼저 들어간 값) 값을 뺀다.
                    deque.add(poll); // 덱에 가장 뒤에 (가장 먼저 들어가는..) 값을 추가한다.
                }
            }
        } //while 끝

        System.out.println(resultCnt);
    }
}