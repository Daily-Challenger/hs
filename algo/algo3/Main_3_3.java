package algo3;

public class Main_3_3 {
    
    public static void main(String[] args) {
        String s = "for the last week";
        System.out.println(solution(s));
    }

    /**
     * JadenCase 문자열 만들기
     * 모든 단어의 첫문자를 대문자로 만든다.
     * 첫 문자가 알파벳이 아닐 때는 이어지는 알파벳은 소문자로 쓴다.
     * 
     * @param s
     * @return
     */
    public static String solution(String s) {

        //공백까지 반복, 다음 다음 다음

        boolean isWordStart = true;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == ' ') {
                isWordStart = true;
            } else if(isWordStart) {
                c = Character.toUpperCase(c);
                isWordStart = false;
            } else {
                c= Character.toLowerCase(c);
            }

            sb.append(c);
        }

        return sb.toString();
    }    
}
