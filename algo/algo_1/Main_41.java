package algo_1;
public class Main_41 {
    
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(solution(babbling));
    }

    /**
     * "aya", "ye", "woo", "ma" 네가지 조합으로만 발음 가능
     * 연속해서 같은 발음은 불가
     * @param babbling
     * @return
     */
    public static int solution(String[] babbling) {
        int answer = 0;

        for(int i = 0; i < babbling.length; i++) {
            String s = babbling[i].replace("aya", "1")
                                    .replace("ye", "2")
                                    .replace("woo", "3")
                                    .replace("ma", "4");
                              
            if(Character.isAlphabetic(s.charAt(0))) {
                continue;
            }
            int y = 1;
            boolean isBabbling = true;
            while(y < s.length()) {
                if(Character.isAlphabetic(s.charAt(y))) {
                    isBabbling = false;
                    break;
                }
                if(s.charAt(y-1) == s.charAt(y)) {
                    isBabbling = false;
                    break;
                }
                y++;
            }

            if(isBabbling) {
                answer ++;
            }
        }

        return answer;
    }
}
