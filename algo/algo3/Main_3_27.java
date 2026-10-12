package algo3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 캐시
 * 
 * 도시 이름을 순서대로 조회할 때 LRU 캐시를 적용한 총 실행시간을 구한다.
 * 캐시 적중(hit)은 1, 실패(miss)는 5의 실행시간이 소요된다.
 * 캐시 크기를 초과하면 가장 오래 사용되지 않은 도시를 제거한다.
 * 
 * Main_3_27
 */
public class Main_3_27 {
    
    public static void main(String[] args) {
        Main_3_27 main = new Main_3_27();

        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        
        System.out.println(main.solution(cacheSize, cities));
    }

    /**
     * Deque를 사용하여 LRU 캐시를 구현한다.
     * 캐시 적중 시 해당 도시를 제거 후 마지막에 추가하여 사용 순서를 갱신한다.
     * 접근 방식은 적절하지만, 조회와 중간 요소 제거에 O(cacheSize)의 시간이 소요된다.
     * 
     * @param cacheSize
     * @param cities
     * @return
     */
    public int solution(int cacheSize, String[] cities) {

        int answer = 0;
        Deque<String> deque = new ArrayDeque<>();

        for(int i = 0; i < cities.length; i++) {

            String city = cities[i].toLowerCase();

            if(deque.contains(city)) {
                answer += 1;
                deque.remove(city);
                deque.addLast(city);
            }  else {
                answer += 5;
                deque.addLast(city);
                if(deque.size() > cacheSize) {
                    deque.removeFirst();
                }
            }
        }
        
        return answer;
    }

    /**
     * 풀이1의 접근은 올바르지만, cacheSize가 커지는 경우를 가정하여 개선한 풀이이다.
     * LinkedHashMap의 accessOrder를 활용해 접근 시 사용 순서를 자동 갱신한다.
     * 조회 및 순서 갱신, 오래된 요소 제거를 평균 O(1)로 처리한다.
     * 
     * @param cacheSize
     * @param cities
     * @return
     */
    public int solution2(int cacheSize, String[] cities) {

        int answer = 0;

        /**
         * 초기 해시 테이블 용량
         * 해시 테이블을 확장하는 기준 비율
         * 요소를 접근 순서대로 관리할지 여부
         * 
         * 초기용량 16 이고 적재율 0.75라면 12개까지 저장 후 13번째 요소 추가 시 내부 용량을 32로 확장
         * (16 * 0.75 = 12); 
         */
        Map<String, Boolean> cache = new LinkedHashMap<>(16, 0.75f, true);

        for(String city : cities) {
            city = city.toLowerCase();

            if(cache.containsKey(city)) {

                if(cache.containsKey(city)) {
                    answer += 1;
                    //연결 리스트의 링크 변경
                    //기존 연결을 끊고 마지막 요소와 연결
                    cache.get(city);
                } else {
                    answer += 5;
                    cache.put(city,true);

                    if(cache.size() > cacheSize) {
                        //가장 오랫동안 사용되지 않은 key
                        String oldest = cache.keySet().iterator().next();
                        cache.remove(oldest);
                    }
                }
            }
        }

        return answer;
    }
}
