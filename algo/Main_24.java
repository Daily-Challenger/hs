public class Main_24 {
    
    public static void main(String[] args) {
        String s = "a";

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;

        int count = 1;

        char[] ch = s.toCharArray();
        char c = ch[0];

        int x = 1;

        if(ch.length == 1) {
            return 1;
        }
        while(x < ch.length) {
            if(c == ch[x]) {
                count++;
            } else {
                count--;
            }
            x++;
            if(count == 0) {
                answer++;
                if(x < ch.length) {
                    c = ch[x];
                } 
            } else if(x == ch.length){
                answer++;
            }
        }        
        return answer;
    }

    public static int solution2(String s) {
        int answer = 0;
        char first = s.charAt(0);
        int balance = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == first) {
                balance++;
            } else {
                balance--;
            }

            if(balance == 0) {
                answer++;

                if(i + 1 < s.length()) {
                    first = s.charAt(i + 1);
                }
            }
        }

        if(balance != 0) {
            answer++;
        }

        return answer;
    }
}
