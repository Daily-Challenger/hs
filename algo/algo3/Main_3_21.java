package algo3;

import java.util.*;

/**
 * 의상
 * 
 * 의상 이름과 종류가 주어질 때 서로 다른 의상 조합의 수를 구한다.
 * 같은 종류의 의상은 최대 1개만 착용할 수 있으며,
 * 하루에 최소 1개의 의상은 반드시 착용해야 한다.
 * 
 */
public class Main_3_21 {
    
    public static void main(String[] args) {
        
        Main_3_21 main = new Main_3_21();

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        main.solution(clothes);

    }

    /**
     * 의상 종류별 개수를 구한 뒤, 각 종류마다 착용하지 않는 경우를 포함해 경우의 수를 곱한다.
     * 모든 종류에서 아무것도 착용하지 않는 한 가지 경우를 제외하여 최종 조합 수를 구한다.
     * 
     * @param clothes
     * @return
     */
    public int solution(String[][] clothes) {

        Map<String, Integer> countByType = new HashMap<>();
        
        for(String[] cloth : clothes) {
            String type = cloth[1];
            countByType.put(type, countByType.getOrDefault(type, 0) + 1);
        }

        int answer = 1;

        for(int count : countByType.values()) {
            answer *= count + 1;
        }       

        return answer - 1;
    }    
}
