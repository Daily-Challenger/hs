/**
 * 아래 4가지를 이어 붙인 발음 가능
 * {"aya", "ye", "woo", "ma"}
 * 발음할 수 있는 단어의 개수 구하기
 * 
 * <ul>
 *  <li>1 <= babbling길이 <= 100</li>
 *  <li>1 <= babbling[i] 의 길이 <= 15</li>
 * </ul>
 */ 
public class Main_12 {
    

    public static void main(String[] args) {
        
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        System.out.println(solution(babbling));
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        for(String s : babbling) {

            boolean isBabbling = true;
            while(!s.isEmpty()) {
                
                if(s.startsWith("aya") || s.startsWith("woo")) {
                    s = s.substring(3);
                } else if (s.startsWith("ye") || s.startsWith("ma")) {
                    s = s.substring(2);
                } else {
                    isBabbling = false;
                    break;
                }
            }

            if(isBabbling) {
                answer++;
            }
        }
        
        return answer;
    }

    /**
     * 첫번째 풀이에서 substring 이 아닌 index 이동 방식으로 수정
     */
    public static int solution1_1(String[] babbling) {

        int answer = 0;

        for(String s : babbling) {

            int index = 0;
            while (index < s.length()) {
                if (s.startsWith("aya", index) || s.startsWith("woo", index)) {
                    index += 3;
                } else if (s.startsWith("ye", index) || s.startsWith("ma", index)) {
                    index += 2;
                } else {
                    break;
                }
            }

            if (index == s.length()) {
                answer++;
            }
        }

        return answer;
    }
    public static int solution2(String[] babbling) {
        
        int answer = 0;

        for(int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", "1");
            babbling[i] = babbling[i].replace("woo", "1");
            babbling[i] = babbling[i].replace("ye", "1");
            babbling[i] = babbling[i].replace("ma", "1");

            babbling[i] = babbling[i].replaceAll("1", "");

            if(babbling[i].isEmpty()) {
                answer++;
            }
        }

        return answer;
    }

    
}
