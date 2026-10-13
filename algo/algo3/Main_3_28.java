package algo3;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 프로세스
 * 
 * 프로세스는 대기 큐에서 꺼낸 뒤, 더 높은 우선순위가 존재하면 다시 큐에 추가된다.
 * 더 높은 우선순위가 없으면 실행 후 종료되며, 동일 우선순위는 대기 순서를 따른다.
 * 주어진 위치의 프로세스가 몇 번째로 실행되는지 반환한다.
 * 
 * Main_3_28
 */
public class Main_3_28 {
    
    public static void main(String[] args) {
        
    }

    /**
     * 일반 Queue에는 프로세스의 인덱스를, PriorityQueue에는 우선순위를 내림차순으로 저장한다.
     * 현재 프로세스보다 높은 우선순위가 존재하면 다시 큐에 넣고, 그렇지 않으면 실행한다.
     * 실행된 프로세스의 인덱스가 location과 일치하면 실행 순서를 반환한다.
     * 
     * @param priorities
     * @param location
     * @return
     */
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < priorities.length; i++) {
            queue.offer(i);
            pq.offer(priorities[i]);
        }

        while(!queue.isEmpty()) {
            int index = queue.poll();
            int priority = priorities[index];

            if(priority < pq.peek()) {
                queue.offer(index);
                continue;
            }

            pq.poll();
            answer++;

            if(index == location) {
                return answer;
            }
        }

        return answer;
    }    
}
