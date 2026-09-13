package algo2;

import java.util.*;

public class Main_65 {

    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(friends, gifts));
    }

    /**
     * 1. 선물을 주고받은 기록이 있는 경우
     *   - 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받음
     * 2. 선물을 주고받은 기록이 하나도 없음 or 주고받은 수가 같음
     *   - 선물지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받음
     *   - 선물지수란: 자신이 친구들에게 준 선물 - 받은 선물의 수
     * 3. 선물지수도 같은 경우
     *   - 선물을 주고 받지 않음
     * 
     * 이렇게 선물을 주고 받을 때, 가장 많이 받을 친구가 받을 선물의 수
     * @param friends 친구들의 이름
     * @param gifts 선물 기록(A B 형태: A가 준사람, B가 받은사람)
     * @return
     */
    public static int solution(String[] friends, String[] gifts) {

        
        int n = friends.length;

        //indexMap
        Map<String,Integer> nameToIndex = new HashMap<>();
        for(int i = 0; i < n; i++) {
            nameToIndex.put(friends[i], i);
        }

        // giftHistory[i][j] = i가 j에게 준 선물 수
        int[][] giftHistory = new int[n][n];

        // 준 선물 수 - 받은 선물 수
        int[] giftIndex = new int[n];

        for(String s : gifts) {
            String[] names = s.split(" ");
            int giver = nameToIndex.get(names[0]);
            int receiver = nameToIndex.get(names[1]);

            giftHistory[giver][receiver]++;

            giftIndex[giver]++;
            giftIndex[receiver]--;
        }

        int[] nextMonth = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                
                if(giftHistory[i][j] > giftHistory[j][i]) {
                    nextMonth[i]++;
                } else if(giftHistory[i][j] < giftHistory[j][i]) {
                    nextMonth[j]++;
                } else if(giftIndex[i] > giftIndex[j]) {
                    nextMonth[i]++;
                } else if(giftIndex[i] < giftIndex[j]) {
                    nextMonth[j]++;
                }
            }
        }

        int answer = 0;

        for(int count : nextMonth) {
            answer = Math.max(answer, count);
        }

        return answer;
    }    
    
}
