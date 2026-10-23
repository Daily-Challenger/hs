package algo3;

import java.util.*;

/**
 * 영문 대문자로 이루어진 문자열을 LZW 압축 알고리즘으로 압축한다.
 * 사전에 존재하는 가장 긴 문자열의 색인 번호를 출력하고,
 * 다음 문자를 결합한 문자열을 사전에 추가하여 압축 결과를 반환한다.
 * 
 * Main_3_36
 */
public class Main_3_36 {
    
    public static void main(String[] args) {
     
        Main_3_36 main = new Main_3_36();
        String s = "KAKAO";
        System.out.println(main.solution(s));
    }

    /**
     * HashMap을 이용해 문자열과 사전 색인 번호를 관리한다.
     * 현재 위치부터 문자열을 확장하며 사전에 존재하는 가장 긴 문자열을 찾는다.
     * 해당 색인을 결과에 추가하고, 새로운 문자열을 사전에 등록한 뒤 처리 위치를 이동한다.
     * 
     * @param msg
     * @return
     */
    public int[] solution(String msg) {

        List<String> dictionary = new ArrayList<>();
        dictionary.add("");

        for(char c = 'A'; c <= 'Z'; c++) {
            dictionary.add(String.valueOf(c));
        }

        List<Integer> answer = new ArrayList<>();

        int idx = 0;
        while(idx < msg.length()) {
            StringBuilder sb = new StringBuilder();
            int wordIdx = 0;

            while(idx + sb.length() < msg.length()) {

                char c = msg.charAt(idx + sb.length());
                String next = sb.toString() + c;

                int foundIdx = dictionary.indexOf(next);

                if(foundIdx == -1) {
                    dictionary.add(next);
                    break;
                }

                sb.append(c);
                wordIdx = foundIdx;
            }
            answer.add(wordIdx);
            idx += sb.length();
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }    
}
