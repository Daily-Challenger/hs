package algo3;

import java.util.*;

/**
 * 전화번호 목록
 * 
 * 전화번호부에 저장된 전화번호 중 하나가 다른 번호의 접두어인 경우가 있는지 확인한다.
 * 접두어 관계가 존재하면 false, 존재하지 않으면 true를 반환한다.
 * 
 * Main_3_25
 */
public class Main_3_25 {
    
    public static void main(String[] args) {
        Main_3_25 main = new Main_3_25();

        String [] phone_book = {"123","456","789"};
        System.out.println(main.solution(phone_book));
    }

    /**
     * 
     * 전화번호를 사전순으로 정렬한 후 인접한 번호끼리 접두어 관계를 확인한다.
     * 정렬 시 접두어 관계가 있는 번호는 인접한 원소 비교만으로 발견할 수 있어,
     * 이중 반복문을 제거하고 비교 횟수를 줄인다. 시간 복잡도 O(N log N).
     * 
     * @param phone_book
     * @return
     */
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++) {

            if(phone_book[i + 1].startsWith( phone_book[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * 해시를 이용한 풀이
     * 
     * 모든 전화번호를 HashSet에 저장한 후 각 번호의 접두어를 생성하여 존재 여부를 확인한다.
     * 전화번호끼리 직접 비교하지 않고 해시 조회를 활용해 불필요한 탐색을 제거한다.
     * 평균 시간 복잡도 O(N × L²). (L은 전화번호의 최대 길이)
     * 
     * @param phone_book
     * @return
     */
    public boolean solution2(String[] phone_book) {
        
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for(String phone : phone_book) {

            for(int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);

                if(set.contains(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }
}
