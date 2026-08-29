package algo_1;
import java.util.*;

public class Main_30 {

    public static void main(String[] args) {
        String s = "banana";
        for(int i : solution(s)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 가장 가까운 같은 글자
     * @param s
     * @return
     * 
     * 현재 문자와 같은 문자를 찾기 위해 매 위치마다 앞의 문자를 처음부터 다시 탐색한다.
     *
     * 문제점:
     * - 각 문자마다 이전 영역을 반복해서 탐색하므로 불필요한 중복 탐색이 발생한다.
     * - 문자열 길이가 n일 때 최악의 경우 시간복잡도가 O(n^2)이다.
     * - 이미 확인했던 문자들의 위치를 활용하지 못하고 매번 다시 비교한다.
     *
     * 시간복잡도: O(n^2)
     * 추가 공간복잡도: O(1)
     */
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;

        if(answer.length == 1) {
            return answer;
        }

        int x = 0;
        int y = 1;
        int idx = -1;

        while(y < s.length()) {

            if(x == y) {
                answer[y] = idx;
                idx = -1;
                x = 0;
                y++;
                continue;
            }

            if(s.charAt(x) == s.charAt(y)) {
                idx = y - x;
            }
            x++;
        }
        return answer;
    }
    
    /**
     * 개선 풀이 - HashMap
     * @param s
     * @return
     * 각 문자가 마지막으로 등장한 인덱스를 HashMap에 저장한다.
     * 현재 문자가 다시 등장하면 저장된 이전 인덱스를 이용해 거리를 바로 계산한다.
     *
     * 장점:
     * - 첫 번째 풀이처럼 이전 문자열을 매번 다시 탐색할 필요가 없다.
     * - 각 문자를 한 번씩만 확인하므로 평균 시간복잡도가 O(n)으로 개선된다.
     * - Map<Character, Integer>에 "문자 -> 마지막 등장 위치"를 저장하여
     *   필요한 이전 위치를 즉시 조회할 수 있다.
     * - 같은 문자가 여러 번 등장해도 가장 최근 위치만 갱신하면 되므로
     *   문제에서 요구하는 "가장 가까운 같은 문자"를 자연스럽게 구할 수 있다.
     *
     * 시간복잡도: 평균 O(n)
     * 추가 공간복잡도: O(k)  // k = 등장하는 문자 종류 수
     */
    public static int[] solution2(String s) {

        int[] answer = new int[s.length()];

        // 각 문자가 "마지막으로 등장한 인덱스"를 저장
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            /*
             * 이미 나온 문자라면:
             * 현재 인덱스(i) - 이전에 등장한 인덱스
             *
             * 처음 나온 문자라면:
            * getOrDefault가 i + 1을 반환
            * → i - (i + 1) = -1
            */
            answer[i] = i - map.getOrDefault(ch,i + 1);

            // 현재 위치를 해당 문자의 "가장 최근 위치"로 갱신
            map.put(ch, i);
        }

        return answer;
    }
}
