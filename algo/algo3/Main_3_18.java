package algo3;

import java.util.*;

/**
 * 일정한 금액을 지불하면 10일 동안 회원자격 부여
 * 회원을 대상으로 매일 한 가지 제품을 할인.
 * 할인제품은 하루에 하나씩만 구매 가능
 * 
 * 원하는 제품과 수량이 할인하는 날자와 10일 연속으로 일치하는 경우에 맞춰서 회원가입을 하려고 한다.
 * 
 * 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를 return
 * Main_3_18
 */
public class Main_3_18 {
 
    public static void main(String[] args) {
        
        Main_3_18 main = new Main_3_18();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(main.solution(want, number, discount));
    }

    /**
     * 10일 구간을 슬라이딩 윈도우로 이동하며 상품별 남은 필요 수량을 관리
     * 상품의 충족 상태가 변경되는 시점만 추적하여 모든 조건을 만족하는 구간을 계산
     * 
     * @param want
     * @param number
     * @param discount
     * @return
     */
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        int matchedCount = 0;

        Map<String, Integer> remain = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            remain.put(want[i], number[i]);
        }

        for(int i = 0; i < discount.length; i++) {

            String added = discount[i];

            if(remain.containsKey(added)) {
                int after = remain.get(added) - 1;
                remain.put(added, after);

                if(after == 0) {
                    matchedCount++;
                }
            }

            if(i >= 10) {
                String removed = discount[i - 10];

                if(remain.containsKey(removed)) {
                    int before = remain.get(removed);

                    if(before == 0) {
                        matchedCount--;
                    }

                    remain.put(removed, before + 1);
                }
            }

            if(i >= 9 && matchedCount == want.length) {
                answer++;
            }
        }

        return answer;
    }

    /**
     * 개선 풀이
     * 
     * 10일 구간의 상품별 개수를 슬라이딩 윈도우로 관리하고, 필요한 수량과 직접 비교한다.
     * want의 종류가 최대 10개이므로 단순 비교만으로도 충분히 효율적이고 구현이 직관적이다.
     * @param want
     * @param number
     * @param discount
     * @return
     */
    public int solution2(String[] want, int[] number, String[] discount) {

        int answer = 0;

        Map<String, Integer> required = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            required.put(want[i], number[i]);
        }

        Map<String, Integer> window = new HashMap<>();

        for(int i = 0; i < discount.length; i++) {
            
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);

            if(i >= 10) {
                String removed = discount[i - 10];
                window.put(removed,  window.get(removed) - 1);
            }

            if(i < 9) {
                continue;
            }

            boolean possible = true;

            for(String product : want) {
                if(window.getOrDefault(product, 0) != required.get(product)) {
                    possible = false;
                    break;
                }
            }

            if(possible) {
                answer++;
            }
        }
        
        return answer;
    }
}
