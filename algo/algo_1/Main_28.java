package algo_1;
import java.util.*;
public class Main_28 {
    
    public static void main(String[] args) {
        // System.out.println(solution(626331));

        // System.out.println(solution2("4444"));

        // System.out.println(solution7(24,27));

        System.out.println(solution8("Zbcdefg"));
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

    /**
     * 수박수박수..
     * @param n
     * @return
     */
    public static String solution6(int n) {

        StringBuilder sb = new StringBuilder();
        int count = 1;
        while(count < n + 1) {
            if(count % 2 == 0) {
                sb.append("박");
            } else {
                sb.append("수");
            }
            count++;
        }
        return sb.toString();
    }

    /**
     * 약수의 개수가 짝수이면 더하고, 홀수이면 뺴기
     * @param left
     * @param right
     * @return
     */
    public static int solution7(int left, int right) {

        int answer = 0;
        for(int i = left; i <= right; i++) {
            int factorCnt = getFactors(i);
            if(factorCnt % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    //약수구하는 메소드
    public static int getFactors(int i) {

        // int count = 1; 
        // int x = i / 2;
        // while(x > 0) {
        //     if(i % x == 0) {
        //         count++;
        //     }
        //     x--;
        // }
        // return count;

        //더 짧게 도는 코드
        /**
         * 약수는 쌍으로 나오므로 √n까지만 확인.
         * 약수를 하나 찾으면 대응되는 다른 약수까지 같이 세고, 제곱수인 경우만 중복을 피함.
         */
        int count = 0;
        for (int x = 1; x * x <= i; x++) {  // √i까지만 확인
            if (i % x == 0) {               // x가 약수라면
               if (x * x == i) {            // 36의 6처럼 같은 약수가 한 쌍인 경우
                    count++;
                } else {
                    count += 2;             // x와 i/x, 약수 2개를 한 번에 카운트
                }
            }
        }
        return count;
    }

    public static String solution8(String s) {
        char[] chArr = s.toCharArray();

        Arrays.sort(chArr);

        StringBuilder sb = new StringBuilder();

        for(char c : chArr) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }

    public long solution9(int price, int money, int count) {
        long answer = 0;

        long total = 0;

        for(int i = 1; i <= count; i++) {
            total += i * price;
        }

        if(money > total) {
            answer = 0;
        } else {
            answer = total - money;
        }
        return answer;
    }

    public boolean solution10(String s) {

        if(s.length() != 4 && s.length() != 6) {
            return false;
        }
        for(char c : s.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
 