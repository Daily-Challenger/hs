package algo3;

import java.util.*;

/**
 * 주식
 * 
 * 초 단위로 기록된 주식 가격 배열이 주어진다.
 * 각 시점에서 가격이 떨어지지 않은 기간을 초 단위로 계산한다.
 * 가격이 떨어진 시점까지의 시간도 포함하여 배열로 반환한다.
 * Main_3_34
 */
public class Main_3_34 {
    
    public static void main(String[] args) {
        
        Main_3_34 main = new Main_3_34();

        int[] arr = {1, 2, 3, 2, 3};
        for(int i : main.solution(arr)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 
     * 단조 스택을 활용하여 가격이 떨어지지 않은 기간을 계산한다.
     * 인덱스를 스택에 저장하고, 현재 가격이 이전 가격보다 낮아지면 pop하여 유지 시간을 확정한다.
     * 순회 후 스택에 남은 인덱스는 마지막 시점까지의 유지 시간을 계산한다.
     * 시간 복잡도 O(N), 공간 복잡도 O(N).
     * 
     * @param prices
     * @return
     */
    public int[] solution(int[] prices) {

        int n = prices.length;
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {

            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - 1 - idx;
        }

        return answer;
    }
}
