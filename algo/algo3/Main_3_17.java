package algo3;

import java.util.*;

/**
 * 영어 끝말 잇기
 * 
 * 1부터 번호 순서대로 한 사람씩 차례대로 단어를 말함.
 * 마지막 사람이 말한 다음은 1번부터 다시 시작
 * 
 * 탈락:
 *  - 이전에 등장했던 단어
 *  - 앞사람이 말한 단어의 마지막 문자로 시작하는 단어가 아닌 단어를 말함.
 * 
 * 가장 먼저 탈락한 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 반환
 * {번호, 차례}
 * Main_3_17
 */
public class Main_3_17 {
    
    public static void main(String[] args) {
        
        Main_3_17 main = new Main_3_17();

        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        for(int i : main.solution(n, words)) {
            System.out.print(i + " ");
        }
    }

    /**
     * deque를 사용할 이유가 없음
     *  - 앞뒤로 넣고 뺴는 기능 없음
     *  - contains()가 선형 탐색이므로 중복 검사에 O(N)이 소요되어 전체적으로 O(N²)이 될 수 있다.
     * 
     * 탈락하는 순간 바로 return 하면 되므로 round, num, isSuccess 변수가 불필요
     * 
     * @param n
     * @param words
     * @return
     */
    public int[] solution(int n, String[] words) {

        int round = 1;
        int num = 0;
        boolean isSuccess = true;
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(words[0]);

        for(int i = 1; i < words.length; i++) {

            if(i % n == 0) {
                round++;
            }

            if(deque.contains(words[i])) {
                isSuccess = false;
                num = (i % n) + 1;
                break;
            }

            String prev = deque.getLast();
            if(prev.charAt(prev.length()-1) != words[i].charAt(0)) {
                isSuccess = false;
                num = (i % n) + 1;
                break;
            }

            deque.addLast(words[i]);
        }

        if(isSuccess) {
            return new int[] {0, 0};
        } else {
            return new int[] {num, round};
        }
    }

    /**
     * HashSet으로 사용된 단어를 관리하여 중복 여부를 평균 O(1)에 검사한다.
     * 탈락 위치의 인덱스로 참가자 번호와 차례를 바로 계산해 불필요한 상태 관리를 줄였다.
     * 
     * @param n
     * @param words
     * @return
     */
    public int[] solution2(int n, String[] words) {

        Set<String> used = new HashSet<>();
        used.add(words[0]);

        for(int i = 1; i < words.length; i++) {

            String prev = words[i - 1];
            String current = words[i];

            boolean wrongStart = prev.charAt(prev.length() - 1) != current.charAt(0);

            boolean duplicated = !used.add(current);

            if(wrongStart || duplicated) {
                return new int[]{
                    (i % n) + 1, (i / n) + 1
                };
            }
        }

        return new int[] {0, 0};
    }

}
