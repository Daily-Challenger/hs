import java.util.*;

public class Main_38 {

    public static void main(String[] args) {
        // int n = 6;
        // int[] arr1 = {46, 33, 33 ,22, 31, 50};
        // int[] arr2 = {27 ,56, 19, 14, 14, 10};
        
        // for(String s : solution(n, arr1, arr2)) {
        //     System.out.println(s);
        // }

        // int[] nums = {3,3,3,2,2,2};

        // System.out.println(solution3(nums));

        // int number = 10;
        // int limit = 3;
        // int power = 2;

        int a = 5;
        int b = 24;
        System.out.println(solution5(a, b));
        
    }
    
    /**
     * 이진수 변환 후 겹치는 부분은 #, 둘다 0 이면 공백
     * @param n
     * @param arr1
     * @param arr2
     * @return
     */
    public static String[] solution(int n, int[] arr1, int[] arr2){

        String[] s1 = replace(arr1, n);
        String[] s2 = replace(arr2, n);

        String[] answer = new String[n];
        for(int i = 0; i < s1.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                
                if(s1[i].charAt(j) == '1' || s2[i].charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    public static String[] replace(int[] arr, int n) {

        String[] s = new String[arr.length];
        for(int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            int num = arr[i];
            while(num > 0) {
                sb.insert(0, num % 2);
                num /= 2;
            }
            while(sb.toString().length() < n) {
                sb.insert(0, 0);
            }
            s[i] = sb.toString();
        }
        return s;
    }

    /**
     * Integer.toBinaryString 를 이용한 풀이
     * @param n
     * @param arr1
     * @param arr2
     * @return
     */
    public static String[] solution1_2(int n, int[] arr1, int[] arr2){
        String[] answer = new String[n];

        for(int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);

            binary = String.format("%" + n + "s", binary);

            answer[i] = binary
                        .replace('1', '#')
                        .replace('0',' ');
        }

        return answer;
    }

    /**
     * 사진에 나온사람의 이름-점수 계산
     * @param name 이름
     * @param yearning 점수
      * @param photo 사진에 나온사람
     * @return
     */
    public int[] solution2(String[] name, int[] yearning, String[][] photo) {

        Map<String, Integer> scoreMap = new HashMap<>();

        for(int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];

        for(int i = 0; i < photo.length; i++) {
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++) {
                sum += scoreMap.getOrDefault(photo[i][j], 0);
            }
            answer[i] = sum;
        }

        return answer;
    }

    /**
     * 중복을 제거한 폰켓몬 종류 수와 선택 가능한 마릿수(N/2) 중 작은 값이 최대 종류 수.
     * @param nums
     * @return
     */
    public static int solution3(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();        
        int answer = 0;
        int max = nums.length/2;
        for(int i = 0; i < nums.length; i++) {
            int n = map.getOrDefault(nums[i], 0);
            
            if(n == 0) {
                answer++;
                map.put(nums[i], ++n);
            }

            if(answer == max) {
                break;
            }
        }

        return answer;
    }

    /**
     * 중복 제거가 목적이므로 HashSet을 사용
     * @param nums
     * @return
     */
    public static int solution3_1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        return Math.min(set.size(), nums.length / 2);
    }

    /**
     * 1부터 number까지 각 숫자의 약수 개수를 구해 공격력으로 사용한다.
     * 약수 개수가 limit를 초과하면 power로 대체하여 모든 공격력의 합을 반환한다.
     * @param number
     * @param limit
     * @param power
     * @return
     */
    public static int solution4(int number, int limit, int power) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            int n = divisor(i);
            if(n > limit) {
                answer += power;
            } else {
                answer += n;
            }
        }
        return answer;
    }    

    public static int divisor(int number) {

        int count = 0;
        int sqrt = (int) Math.sqrt(number);

        for(int i = 1; i <= sqrt; i++) {
            if(number % i == 0) {
                if(i == number / i) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    /**
     * 개선코드
     * 각 숫자마다 √n까지 약수를 직접 찾는 대신, 배수들을 한 번에 갱신해 전체 약수 개수를 O(N log N)에 계산한다
     * 추가 배열 O(N)을 사용하지만, 전체 실행 속도는 기존 O(N√N) 풀이보다 효율적이다.
     * @param number
     * @param limit
     * @param power
     * @return
     */
    public static int solution4_1(int number, int limit, int power) {

        int[] count = new int[number+1];

        //i를 약수로 가지는 모든 숫자의 약수 개수를 증가
        for(int i = 1; i <= number; i++) {
            //i의 배수들은 모두 i를 약수로 가짐
            for(int j = i; j <= number; j += i) {
                //j는 i의 배수이므로 i가 약수 하나에 해당
                count[j]++;
            }
        }

        int answer = 0;
        for(int i = 1; i <= number; i++) {
            answer += count[i] > limit ? power : count[i];
        }

        return answer;
    }

    /**
     * 2016년 1월 1일이 금요일.
     * 2016년 a월 b일의 요일 구하기
     * @param a
     * @param b
     * @return
     */
    public static String solution5(int a, int b) {

        int[] monthly = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weekly = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int days = b - 1;

        for(int i = 0; i < a - 1; i ++) {
            days += monthly[i];
        }

        return weekly[days % 7];
    }
}
