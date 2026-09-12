package algo2;

import java.util.*;
public class Main_67 {

    public static void main(String[] args) {
        int n = 22;
        int w = 6;
        int num = 8;


        System.out.println(solution(n, w, num));

    }

    /**
     * 
     * @param n 상자 전체 개수
     * @param w 가로로 놓는 상자의 개수
     * @param num 찾으려는 상자의 숫자
     * @return
     */
    public static int solution(int n, int w, int num) {
        int answer = 0;

        //snake 를 표현하는 방식;;
        //1~w까지 반복
        //w에 도달하면 역순;
        //w*2에 도달하면 정순;
        //w*3에 도달하면 역순;

        //w % 2 가 짝수면 정순
        //w % 2 가 홀수면 역순;

        //1. w를 n으로 나눈다.
        //2. 0~n까지 반복한다.
        //2-1. 반복회차가 짝수면 정순
        //2-2. 박회차가 홀수면 역순;

        Deque<Integer>[] deques = (Deque<Integer>[]) new ArrayDeque[w];

        for(int i = 0; i < w; i++) {
            deques[i] = new ArrayDeque<>();
        }

         int idx = 0;
        int row = 0;
        for(int i = 1; i <= n; i++) {

            deques[idx].push(i);

            if(row % 2 == 0) {
                idx++;
            }

            if(row % 2 != 0) {
                idx--;
            }

            if(i % w == 0) {
                if(idx == w) {
                    idx--;
                } else {
                    idx++;
                }
                row++;
                
            }
        }

        for(Deque<Integer> deque : deques) {
            if(deque.contains(num)) {
                while(!deque.isEmpty()) {
                    if(deque.pop() == num) {
                        answer++;
                        break;
                    }
                    answer++;
                }
                break;
            }
        }
        return answer;
    }    
    
}
