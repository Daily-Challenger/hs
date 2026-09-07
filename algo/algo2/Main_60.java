package algo2;

import java.util.*;

public class Main_60 {
    
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        for(String s : solution2(players, callings)) {
            System.out.print(s + " ");
        }
    }

    //시간초과
    public static String[] solution(String[] players, String[] callings) {

        List<String> playerList = Arrays.asList(players);

        for(String s : callings) {
            int idx = playerList.indexOf(s);
            String temp = playerList.get(idx-1);
            playerList.set(idx-1, s);
            playerList.set(idx, temp);
        }

        return playerList.stream().toArray(String[]::new);
    }    

    /**
     * 달리기 경주
     * 선수들이 순서대로 달릴때, 해설진이 추월한 선수의 이름을 부른다
     * 경주가 끝났을떄 최종 둥수를 배열로 응답
     * 
     * 5 ≤ players의 길이 ≤ 50,000
     * 2 ≤ callings의 길이 ≤ 1,000,000
     * @param players 선수이름
     * @param callings 추월한 선수 이름
     * @return
     */
    public static String[] solution2(String[] players, String[] callings) {

        Map<String, Integer> orderMap = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            orderMap.put(players[i], i);
        }

        for(String s : callings) {
            int idx = orderMap.get(s);
            String before = players[idx-1];
            
            players[idx-1] = s;
            players[idx] = before;

            orderMap.put(s, idx-1);
            orderMap.put(before, idx);            
        }

        return players;
    }       
}
