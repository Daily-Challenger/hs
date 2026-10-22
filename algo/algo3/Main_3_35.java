package algo3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1번부터 순서대로 전달되는 택배상자를 주어진 order에 맞게 트럭에 싣는다.
 * 보조 컨테이너는 후입선출(LIFO) 방식으로 동작하며,
 * 더 이상 원하는 순서대로 실을 수 없을 때까지 적재한 상자의 개수를 반환한다.
 * 
 * Main_3_35
 */
public class Main_3_35 {

    public static void main(String[] args) {
        
        Main_3_35 main = new Main_3_35();

        int[] order = {5, 4, 3, 2, 1};
        System.out.println(main.solution(order));
    }

    /**
     *  기존 벨트와 보조 벨트의 현재 상자를 각각 비교하여 적재 여부를 판단한다.
     * Deque를 스택으로 활용해 보조 벨트에 상자를 보관하고 꺼낸다.
     * 각 상황을 개별 조건문으로 처리하므로 분기가 다소 복잡하다.
     * 
     * @param order
     * @return
     */
    public int solution(int[] order) {
        

        /**
         * 지금 꺼낼 수 있는가? 
         * 보조벨트에 넣어야 하는가?
         * 보조벨트를 언제 어디까지 뒤져야 하는가?
         */

        int answer = 0;
        int idx = 0;
        int boxNumber = 1;

        Deque<Integer> subContainer = new ArrayDeque<>();
        
        while(idx < order.length) {

            //바로 꺼낼 수 있는 상황
            if(boxNumber <= order.length && boxNumber == order[idx]) {
                boxNumber++;
                idx++;
                answer++;
            } else if(!subContainer.isEmpty() && subContainer.peekLast() == order[idx]) {
                //보조 컨테이너에서 꺼낼 수 있는 경우
                subContainer.pollLast();
                idx++;
                answer++;
            } else if(boxNumber <= order.length) {
                //보조 컨테이너로 이동
                subContainer.offerLast(boxNumber);
                boxNumber++;
            } else {
                break;
            }
        }

        return answer;
    }

    /**
     * 
     * 모든 상자를 순서대로 스택에 넣고, 원하는 상자가 맨 위에 있으면 연속해서 꺼낸다.
     * 기존 벨트에서 바로 싣는 경우까지 스택의 push/pop으로 통일하여 분기를 최소화한다.
     * 각 상자는 최대 한 번 삽입·제거되므로 시간 복잡도 O(N), 공간 복잡도 O(N)이다.
     * 
     * @param order
     * @return
     */
    public int solution2(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();

        int idx = 0;

        for (int box = 1; box <= order.length; box++) {
            stack.push(box);
  
            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
            }
        }

        return idx;
    }
}
