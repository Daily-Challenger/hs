package algo2;

import java.util.*;

public class Main_55 {

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(solution(survey, choices));
    }

    /**
     * 성격유형 검사
     * RT,CF,JM,AN 4가지 지표에 대한 점수(choices)를 확인하여
     * 성격 유형 응답(예, RCJA)
     * 
     * @param survey
     * @param choices
     * @return
     */
    public static String solution(String[] survey, int[] choices) {

        /**
         * survey 앞에 값 뒤에값;
         */
        Map<String, Integer> map = new HashMap<>(Map.of(
            "R",0, "T",0,
            "C",0, "F",0,
            "J",0, "M",0,
            "A",0, "N",0
        ));

        for(int i = 0; i < choices.length; i++) {
            int score = choices[i] -4 ;
            String key = "";
            if(score > 0) {
                key = String.valueOf(survey[i].charAt(1));
            } else {
                key = String.valueOf(survey[i].charAt(0));
            }
            int beforeScore = map.getOrDefault(key, 0);
            map.put(key, beforeScore + Math.abs(score));
        }

        String[][] type = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};

        StringBuilder sb = new StringBuilder();

        for(String[] arr : type) {
            String s = getType(map, arr[0], arr[1]);
            sb.append(s);
        }
        
        return sb.toString();
    }    
    
    private static String getType(Map<String, Integer> map, String s1, String s2) {
        int n1 = map.getOrDefault(s1, 0);
        int n2 = map.getOrDefault(s2, 0);

        if(n1 > n2) {
            return s1;
        } else if(n1 < n2) {
            return s2;
        } else {
            return s1.compareTo(s2) < 0 ? s1 : s2;
        }
    }

    /**
     * 개선된 풀이
     * 0일때 값을 넣어도 답은 맞지만, 불필요한 계산이 발생하지 않도록 continue.
     * type 자체를 알파벳 순서로 선언하여 순서 계산 없이 바로 사용할 수 있도록 수정
     * @param survey
     * @param choices
     * @return
     */
    public static String solution2(String[] survey, int[] choices) {
        Map<Character, Integer> score = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            int point = choices[i] - 4;

            if (point == 0) {
                continue;
            }

            char type;

            if (point < 0) {
                type = survey[i].charAt(0);
            } else {
                type = survey[i].charAt(1);
            }

            score.put(
                type,
                score.getOrDefault(type, 0) + Math.abs(point)
            );
        }
        char[][] types = {
            {'R', 'T'},
            {'C', 'F'},
            {'J', 'M'},
            {'A', 'N'}
        };

        StringBuilder answer = new StringBuilder();

        for (char[] type : types) {
            answer.append(
                score.getOrDefault(type[0], 0) >= score.getOrDefault(type[1], 0)
                    ? type[0]
                    : type[1]
            );
        }        
        return answer.toString();
    }
}
