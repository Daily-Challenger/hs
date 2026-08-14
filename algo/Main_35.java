public class Main_35 {
    
    public static void main(String[] args) {
        
        String s = "a B z";
        int n = 4;
        System.out.println(solution(s, n));
    }

    /**
     * s의 알파벳들을 n 만큼 밀기
     * @param s
     * @param n
     * @return
     */
    public static String solution(String s, int n) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if(temp == ' ') {
                sb.append(temp);
                continue;
            }

            boolean isUpperCase = Character.isUpperCase(temp);
            temp += n;
            
            if(isUpperCase && temp > 'Z') {
                temp -= 26;
            } else if(!isUpperCase && temp > 'z') {
                temp -= 26;
            } 

            sb.append(Character.toChars(temp));
        }
        return sb.toString();
    }

    /**
     * 순환구조로 풀이
     * @param s
     * @param n
     * @return
     */
    public static String solution2(String s, int n) {

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        if (Character.isLowerCase(ch)) {
            ch = (char) ((ch - 'a' + n) % 26 + 'a');
        } else if (Character.isUpperCase(ch)) {
            ch = (char) ((ch - 'A' + n) % 26 + 'A');
        }

        sb.append(ch);
    }

    return sb.toString();
}

}
