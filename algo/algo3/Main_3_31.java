package algo3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 정수 배열의 각 원소에 대해 오른쪽에 위치하면서
 * 자신보다 큰 수 중 가장 가까운 수를 찾는다.
 * 뒷 큰수가 존재하지 않으면 -1을 반환한다.
 * 
 * Main_3_31
 */
public class Main_3_31 {

    public static void main(String[] args) {
       
        Main_3_31 main = new Main_3_31();

        int[] numbers = {9, 1, 5, 3, 6, 2};
        for(int i : main.solution(numbers)){
            System.out.print(i + " ");
        };
    }

    /**
     * 이중 반복문으로 각 원소의 오른쪽을 순차 탐색하여 뒷 큰수를 찾는다.
     * 이미 탐색한 구간을 반복해서 확인하므로 중복 연산이 발생한다.
     * 최악의 경우 O(N²)의 시간복잡도로 시간 초과가 발생한다.
     * 
     * @param numbers
     * @return
     */
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length - 1; i++) {

            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                }
                answer[i] = -1;
            }
        }

        answer[numbers.length - 1] =-1;
        return answer;
    }

    /**
     * 배열을 오른쪽부터 탐색하며 Stack에 뒷 큰수 후보를 관리한다.
     * 현재 값보다 작거나 같은 후보를 제거하고, 남은 최상단 값을 정답으로 사용한다.
     * 각 원소는 최대 한 번 삽입·제거되므로 O(N)의 시간복잡도로 개선한다.
     *
     * @param numbers
     * @return
     */
    public int[] solution2(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = numbers.length - 1; i > -1; i--) {
            int n = numbers[i];

            // 현재 값보다 작거나 같은 후보 제거
            while (!deque.isEmpty() && deque.peek() <= numbers[i]) {
                deque.pop();
            }

            answer[i] = deque.isEmpty() ? -1 : deque.peek();

            deque.push(numbers[i]);

        }
        return answer;
    }     
}
