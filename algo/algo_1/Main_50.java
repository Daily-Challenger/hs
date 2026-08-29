package algo_1;
import java.util.*;

public class Main_50 {
 
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant, completion));
    }

    /**
     * 완주하지 못한 선수
     * 참가자 중 완주하지 못한 1명이 있다
     * 1명의 이름을 찾는다.
     * 참가자 중에는 동명이인이 있을 수 있다.
     * @param participant 참가자
     * @param completion 완주자
     * @return
     */
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> completeMap = new HashMap<>();
        for(String s : completion) {
            int cnt = completeMap.getOrDefault(s, 0);
            completeMap.put(s, cnt + 1);
        }

        for(String s : participant) {
            int completeCnt = completeMap.getOrDefault(s, 0);
            if(completeCnt == 0) {
                answer = s;
                break;
            } else {
                completeMap.put(s, completeCnt - 1);
            }
        }
        return answer;
    }
}
