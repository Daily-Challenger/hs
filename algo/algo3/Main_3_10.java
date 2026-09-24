package algo3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 귤 고르기
 * 
 * 수확한 귤 k 개를 골라 상자 하네 담아서 판매
 * 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화
 * 
 * 귤 k 개를 고를 때, 크기가 서로 다른 종류의 수의 최솟값을 return
 * Main_3_10
 */
public class Main_3_10 {
    
    public static void main(String[] args) {
        // Main method implementation
        Main_3_10 main = new Main_3_10();

        int k = 2; 
        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};

        System.out.println(main.solution(k, tangerine));

        
    }

    /**
     * 
     * 귤의 크기별 개수를 배열에 저장하고, 정렬 후 개수가 많은 크기부터 귤을 하나씩 선택
     * 귤의 크기 최댓값만큼 배열을 생성하고 정렬하므로 불필요한 메모리와 연산이 발생
     * @param k
     * @param tangerine
     * @return
     */
    public int solution(int k, int[] tangerine) {
        int answer = 1;

        int[] count = new int[10000001];

        for(int i = 0; i < tangerine.length; i++) {
            count[tangerine[i]]++;
        }

        Arrays.sort(count);

        int idx = count.length - 1;

        while(k > 0 && idx >= 0) {
         
            if(k != 0 && count[idx] == 0) {
                idx--;
                answer++;
                continue;
            }

            k--;
            count[idx]--;
        }
        
        return answer;
    }

    /**
     * HashMap으로 귤의 크기별 개수를 계산하고, 개수만 추출하여 정렬한 뒤 많은 순서대로 선택
     * 실제 등장한 크기의 개수만 정렬하고 귤을 크기별로 한 번에 선택하여 메모리 사용과 연산을 줄임
     * @param k
     * @param tangerine
     * @return
     */
    public int solution2(int k, int[] tangerine) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int size: tangerine) {
            count.put(size, count.getOrDefault(size, 0) + 1);
        }

        int[] counts = count.values().stream()
                            .mapToInt(Integer::intValue)
                            .toArray();

        Arrays.sort(counts);

        int answer = 0;

        for(int i = counts.length - 1; i >= 0; i--) {
            k -= counts[i];
            answer++;

            if(k <= 0) {
                break;
            }
        }
        return answer;
    }
}
