
import java.util.*;
public class Main_27 {
    
    public static void main(String[] args) {
     
        // long n = 1;
        // System.out.println(solution(n));

        // int[] arr = {1,2,3,4};
        // System.out.println(solution3(arr));

        // System.out.println(solution4(12));

        int[] arr = {1,2,3,4,6,7,8,0};

        System.out.println(solution8(arr));
    }

    /**
     * 정수 제곱근 판별
     * @param n
     * @return
     */
    public static long solution(long n) {
        long x = (long) Math.sqrt(n);

        if(x*x == n) {
            return (x+1) * (x+1);
        } else {
            return -1;
        }
    }

    /**
     * 홀/짝
     * @param num
     * @return
     */
    public static String solution2(int num) {

        if(num % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    /**
     * 평균구하기
     * @param arr
     * @return
     */
    public static double solution3(int[] arr) {
        
        double n = arr.length;
        long sum = 0;

        for(int i : arr) {
            sum += i;
        }

        return sum/n;
    }

    /**
     * 하샤드 수
     * @param x
     * @return
     */
    public static boolean solution4(int x) {

        int sum = 0;
        int n = x;
        while(n > 0) {
            sum += n % 10;
            n = n / 10;
        }

        if(x % sum == 0) {
            return true;
        } else {
            return false;
        }
    }

    public long[] solution5(int x, int n) {
        long[] answer = new long[n];

        answer[0] = x;
        for(int i = 1; i < n; i++) {
            answer[i] = answer[i-1] + x;
        }
        return answer;
    }

    /**
     * 문자열 내 p와 y의 개수
     */
    public static boolean solution6(String s) {

        int pCount = 0;
        int yCount = 0;

        for(int i = 0; i < s.length(); i++) {
            if('p' == Character.toLowerCase(s.charAt(i))) {
                pCount++;
            } else if ('y' == Character.toLowerCase(s.charAt(i))) {
                yCount++;
            }
        }

        if(pCount == yCount) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 음양 더하기
     * @param absolutes
     * @param signs
     * @return
     */
    public static int solution7(int[] absolutes, boolean[] signs) {

        int answer = 0;
        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i]) {
                answer += absolutes[i];
            } else {
                answer += (-1) * absolutes[i];
            }

        }
        return answer;
    }

    /**
     * 없는 수 합 구하기
     * @param numbers
     * @return
     */
    public static int solution8(int[] numbers) {
        int answer = 0;

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for(int i = 0; i < numbers.length; i++) {
            arr[numbers[i]] = 0;
        }

        for(int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        return answer;
    }

    /**
     * 서울에서 김서방 찾기
     * @param seoul
     * @return
     */
    public static String solution9(String[] seoul) {

        int x = 0;
        for(int i = 0; i < seoul.length; i++) {
            if("Kim".equals(seoul[i])) {
                x = i;
                break;
            }
        }

        return "김서방은 " + x + "에 있다"; 
    }

    /**
     * 제일 작은수 제거하기
     * @param arr
     * @return
     */
    public int[] solution10(int[] arr) {

        if(arr.length == 1) {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        int min = Integer.MAX_VALUE;

        for(int i : arr) {
            min = Math.min(i, min);
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != min) {
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
