package algo_search;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class search_1 {
    
    public static void main(String[] args) {
        
        /**
         * 연습
         * x = 2에서 시작
         * 한 번의 연산으로 다음 중 하나를 수행할 수 있다.
         *  - 현재 숫자에 3을 더한다.
         *  - 현재 숫자에 2를 곱한다
         * 숫자는 20을 초과할 수 없다.
         * 
         */
        search_1 main = new search_1();
        main.solution2();;
    }

    /**
     * 값을 구할 수 있는지 여부만 확인하는 탐색
     */
    public void solution() {
        Queue<Integer> queue = new ArrayDeque<>(); //앞으로 탐색할 상태를 보관
        boolean[] visited = new boolean[21]; // 이미 발견한 상태를 기록

        /**
         * 아래를 반복
         * - queue 에서 숫자 꺼내기
         * - 목표 숫자인지 확인
         * - 다음 숫자 생성(+3, *2)
         * - 범위 및 방문 여부 검사
         * - 방문 처리 후 Queue에 추가
         */

        queue.offer(2);
        visited[2] = true;

        boolean result = false;
        while(!queue.isEmpty()) {

            int current = queue.poll();

            if(current == 14) {
                result = true;
                return;
            }

            int[] next = {current + 3, current * 2};

            for(int n : next) {

                if(n >  20) {
                    continue;
                }

                if(visited[n]) {
                    continue;
                }

                visited[n] = true;
                queue.offer(n);
            }
        }
    }

    /**
     * 최단 거리 찾기
     */
    public void solution2() {
        Queue<Integer> queue = new ArrayDeque<>();

        int[] dist = new int[21];
        Arrays.fill(dist, -1);

        queue.offer(2);
        dist[2] = 0;

        int answer = -1;
        while (!queue.isEmpty()) {
            
            int current = queue.poll();

            if(current == 14) {
                answer = dist[current];
            }

            int[] next = {current + 3, current * 2};

            for(int n : next) {
                if(n > 20) {
                    continue;
                }

                if(dist[n] > -1) {
                    continue;
                }

                dist[n] = dist[current] + 1;
                queue.offer(n);
            }
        }

        System.out.println(answer);
    }

}
