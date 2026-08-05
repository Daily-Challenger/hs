import java.util.*;
import java.util.stream.Collector;

public class Main_26 {

    public static void main(String[] args) {
        // int a = 5;
        // int b = 3;

        // System.out.println(solution(a, b));

        // String s = "-1234";
        // System.out.println(solution2(s));

        // System.out.println(solution3(987));

        // for(int i : solution4(12345)) {
        //     System.out.println(i);
        // }

        System.out.println(solution5(118372));
    }


    public static long solution(int a, int b) {
        
        long answer = 0;

        int start = Math.min(a, b);
        int end = Math.max(a, b);

        for(int i = start; i <= end; i++) {
            answer += i;
        }
        return answer;
    }

    public static int solution2(String s) {

        // int startIndex = 0;
        // int i = 1;
        // if(s.charAt(0) == '-') {
        //     startIndex = 1;
        //     i = -1;
        // } else if(s.charAt(0) == '+') {
        //     startIndex = 1;
        // }

        // int n = Integer.parseInt(s.substring(startIndex, s.length()));

        //부호도 파싱이 된다
        return Integer.parseInt(s);
    }

    public static int solution3(int n) {
        int answer = 0;

        while(n > 0) {
            int digit = n % 10;
            answer += digit;
            n = n/10;
        }
        return answer;
    }

    public static int[] solution4(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = Character.getNumericValue(s.charAt(s.length()-i-1));
        }  
        return answer;
    }

    public static long solution5(long n) {
        
        String s = String.valueOf(n);
        List<Integer> list = new ArrayList<>();

        for(char c : s.toCharArray()) {
            list.add(Character.getNumericValue(c));
        }

        list.sort(Collections.reverseOrder());
        
        StringBuffer sb = new StringBuffer();
        for(int i : list) {
            sb.append(i);
        }

        return Long.parseLong(sb.toString());
    }
}
