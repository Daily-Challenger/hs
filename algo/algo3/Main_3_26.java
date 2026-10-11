package algo3;

import java.util.*;

/**
 * 롤케이크 자르기
 * 
 * 롤케이크를 두 조각으로 나누었을 때, 양쪽의 토핑 종류 수가 같아야 한다.
 * 토핑의 개수와 조각의 크기는 상관없이,
 * 공평하게 나눌 수 있는 모든 경우의 수를 반환한다
 * 
 * Main_3_26
 */
public class Main_3_26 {
    
    public static void main(String[] args) {
        
        Main_3_26 main = new Main_3_26();

        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(main.solution(topping));
    }

    /**
     * 
     * HashSet으로 왼쪽의 토핑 종류를, HashMap으로 오른쪽의 토핑별 개수를 관리
     * 토핑을 왼쪽으로 하나씩 옮기면서 오른쪽의 개수가 0이 된 토핑은 제거한다.
     * 양쪽 자료구조의 size()가 같아지는 경우를 카운트한다.
     * 시간 복잡도 O(N), 공간 복잡도 O(K) (K: 서로 다른 토핑 종류 수).
     * 
     * @param topping
     * @return
     */
    public int solution(int[] topping) {
        int answer = 0;

        Set<Integer> left = new HashSet<>();

        Map<Integer, Integer> right = new HashMap<>();

        for(int i = 0; i < topping.length; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }

        for(int i = 0; i < topping.length - 1; i++) {
            int n = topping[i];
            left.add(n);

            int count = right.get(n) - 1;
            
            if(count == 0) {
                right.remove(n);
            } else {
                right.put(n, count);
            }

            if(left.size() == right.size()) {
                answer++;
            }
        }
        
        return answer;
    }    
}
