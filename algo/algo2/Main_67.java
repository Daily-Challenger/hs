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
     * 각 세로 열을 Deque로 만들어 상자를 지그재그 순서대로 실제 적재한 뒤,
     * 목표 상자가 있는 열을 찾아 위에서부터 꺼내며 개수를 계산한다.
     * 직관적이지만 모든 상자를 저장하므로 불필요한 O(n) 공간과 자료구조 탐색이 발생한다.
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
    
    /**
     * 상자 번호와 행의 홀짝을 이용해 실제 세로 열 위치를 계산하고,
     * 목표 상자와 같은 열에 있는 위쪽 상자들의 개수를 센다.
     * 실제 적재 구조를 만들지 않아 풀이 1의 불필요한 Deque 사용을 제거하고 O(1) 공간으로 개선했다.
     * @param n
     * @param w
     * @param num
     * @return
     */
    public int solution2(int n, int w, int num) {
        int targetColumn = getColumn(num, w);
        int answer = 0;

        // num 부터 n까지 중 같은 세로 열에 있는 상자만 센다.
        // num 보다 작은 상자는 목표 상자 아래에 있으므로 확인할 필요 없음
        for(int box = num; box <= n; box++) {
            if(getColumn(box, w) == targetColumn) {
                answer++;
            }
        }

        return answer;
    }

    private int getColumn(int box, int w) {
        int row = (box - 1) / w;
        int offset = (box - 1) % row;

        //짝수 층은 왼 -> 오
        //홀수 층은 오 -> 왼
        return row % 2 == 0 ? offset : w - 1 - offset;
    }
}
