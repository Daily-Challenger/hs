package algo3;

import java.util.Arrays;

/**
 * 논문별 인용 횟수가 주어졌을 때 H-Index의 최댓값을 구한다.
 * H-Index는 h회 이상 인용된 논문이 h편 이상 존재하는 최대 정수 h이다.
 * 
 * Main_3_22
 */
public class Main_3_22 {
    
    public static void main(String[] args) {
        Main_3_22 main = new Main_3_22();

        int[] citations = {0, 1, 1, 1, 1};

        System.out.println(main.solution(citations));
    }
   
    /**
     * 인용 횟수를 오름차순 정렬한 뒤, 인덱스와 H-Index 후보를 증가시키며 조건을 검사한다.
     * 두 변수를 독립적으로 관리하여 조건 분기가 복잡하고, 후보 검증 및 반환값 처리에 오류가 발생할 수 있다.
     * 
     * @param citations
     * @return
     */
    private int solution(int[] citations) {

        Arrays.sort(citations);

        int n = citations.length;
        int h = 0;
        int idx = 0;

        while(idx < citations.length) {
            //h번 이상 인용된 논문의 개수 >= h 이상이어야 한다.

            //1. h번 이상에 포함이 되는가?  -아닌경우 idx를 늘린다.
            if(citations[idx] <= h) {
                idx++;
                continue;
            }

            if(n - idx <= h) {
                break;
            }

            h++;
        }

        return h;
    }

    /**
     * 기존 풀이 개선
     * h와 idx를 독립적으로 증가시키면 관리가 복잡해지므로
     * n - i 를 바로 H-Index 후보로 사용한다.
     * 
     * @param citations
     * @return
     */
    private int solution2(int[] citations) {

        Arrays.sort(citations);

        int n = citations.length;
        int h = 0;

        for(int i = 0; i < n; i++) {
            int candidate = n - i;

            if(citations[i] >= candidate) {
                h = candidate;
                break;
            }
        }

        return h;
    }

    /**
     * 개선 풀이
     * 
     * 직관성: H-Index 정의를 조건문 하나로 표현
     * 직관성: H-Index 정의를 조건문 하나로 표현
     * 간결성: 불필요한 변수나 Math.min(), Math.max() 연산 없음
     * - 정확성: 인용 횟수가 전부 0인 경우도 처리
     * 
     * @param citations
     * @return
     */
    private int solution3(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;

        for(int i = 0; i < n; i++) {
            if(citations[i] >= n - i) {
                return n - i;
            }
        }
        
        return 0;
    }

}
