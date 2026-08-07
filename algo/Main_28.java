import java.util.*;
import java.util.stream.Collectors;

public class Main_28 {
    
    public static void main(String[] args) {
        // System.out.println(solution(626331));

        System.out.println(solution2("4444"));
    }

    /**
     * 콜라츠 추측
     * @param num
     * @return
     * 중간 계산값의 자료형 유의할것!(n 을 int로하면 잘못된 답이 나옴)
     */
    public static int solution(int num) {
        int answer = 0;
        long n = num;

        while(n != 1) {

            if(answer == 500) {
                answer = -1;
                break;
            }
            if(n % 2 == 0) {
                n = n / 2;
            } else {
                n = (n * 3) + 1;
            }
            answer++;
        }
        return answer;
    }

    /**
     * 핸드폰 번호 가리기
     * @param phone_number
     * @return
     */
    public static String solution2(String phone_number) {
        char[] chArr = phone_number.toCharArray();
        
        for(int i = 0; i < chArr.length - 4; i++) {
            chArr[i] = '*';
        } 
        StringBuilder sb = new StringBuilder();
        for(char c : chArr) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 내적
     * @param a
     * @param b
     * @return
     */
    public static int solution3(int[] a, int[] b) {
        int answer = 0;

        for(int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }

    /**
     * 나누어지는 수
     * @param arr
     * @param divisor
     * @return
     */
    public static int[] solution4(int[] arr, int divisor) {
        
        List<Integer> list = new ArrayList<>();

        for(int n : arr) {
            if(n % divisor == 0) {
                list.add(n);
            }
        }

        if(list.size() == 0) {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        } 
        list.sort(Comparator.naturalOrder());

        return list.stream().mapToInt(i->i).toArray();
    }

    /**
     * 가운데 글자 구하기
     * @param s
     * @return
     */
    public String solution5(String s) {

        int len = s.length();
        int x = len / 2;

        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(s.charAt(x)));

        if(len % 2 == 0) {
            sb.insert(0, String.valueOf(s.charAt(x -1)));
        } 
        return sb.toString();
    }
}
