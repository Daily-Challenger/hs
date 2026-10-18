package algo3;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 더 맵게
 * 
 * 음식의 스코빌 지수를 가장 낮은 두 음식부터 섞어 모든 음식의 스코빌 지수를 K 이상으로 만든다.
 * 모든 음식이 K 이상이 되기 위한 최소 혼합 횟수를 반환한다.
 * 불가능한 경우 -1을 반환한다.
 * Main_3_32
 */
public class Main_3_32 {
    
    public static void main(String[] args) {
        
        Main_3_32 main = new Main_3_32();

        int[] scoville = {1, 2};
        int K = 7;
        System.out.println(main.solution(scoville, K));
        
    }

    /**
     * 최소 힙(PriorityQueue)을 사용하여 가장 낮은 두 스코빌 지수를 반복적으로 섞는다.
     * 최솟값을 poll()로 꺼낸 후 종료 조건을 검사하므로 불필요한 요소 제거가 발생할 수 있다.
     * 시간복잡도 O(N log N), 공간복잡도 O(N).
     * 
     * @param scoville
     * @param K
     * @return
     */
    public int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> queue = new PriorityQueue<>();

        for(int i : scoville) {
            queue.add(i);
        }

        while(queue.size() >= 2) {
            int x = queue.poll();

            if(x >= K) {
                return answer;
            }

            int y = queue.poll();

            int mix = x + (y * 2);
            answer++;
            queue.add(mix);
        }

        if(queue.poll() >= K) {
            return answer;
        } else {
            return -1;
        } 
    }

    /**
     * 개선된 풀이
     * 
     *  최소 힙(PriorityQueue)의 peek()로 최솟값이 K 이상인지 확인한다.
     * 조건을 만족하지 않을 때만 가장 낮은 두 음식을 섞어 혼합 횟수를 계산한다.
     * 불필요한 요소 제거 없이 종료 조건을 명확히 처리하며, 시간복잡도 O(N log N), 공간복잡도 O(N).
     * 
     * @param scoville
     * @param K
     * @return
     */
    public int solution2(int[] scoville, int K) { 

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int value : scoville) {
            queue.offer(value);
        }

        int count = 0;

        while(queue.size() > 1 && queue.peek() < K) {
            int first = queue.poll();
            int second = queue.poll();

            queue.offer(first + second * 2);
            count++;
        }

        return queue.peek() >= K ? count : -1;
    }
}
