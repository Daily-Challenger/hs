package algo_1;
import java.util.*;

/**
 * 두개 뽑아서 더하기 
 * Main_36
 */
public class Main_36 {
    
    public static void main(String[] args) {
        // int[] numbers = {5,0,2,7};

        // for(int i : solution(numbers)) {
        //     System.out.print(i + " ");
        // }
        // int[] food = {1, 3, 4, 6};
        // System.out.println(solution5(food));
        // String s = "one4seveneight";
        // System.out.println(solution6(s));

        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        for(String s : solution7(strings, n)) {
            System.out.print(s + " ");
        }
    }

    /**
     * 두 수 조합 생성: O(N²)
     * TreeSet 삽입: O(log K)
     * → O(N² log K)
     * @param numbers
     * @return
     */
    public static int[] solution(int[] numbers) {

        Set<Integer> sum = new TreeSet<>();

        int x = 0;
        int y = 1;

        while(x < numbers.length) {

            if(y == numbers.length) {
                x++;
                y = x+1;
                continue;
            }
            sum.add(numbers[x] + numbers[y]);
            y++;
        }

        return sum.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 가독성만 향상
     * 두 인덱스의 합이기에 보다 직관적으로 풀이
     * @param numbers
     * @return
     */
    public static int[] solution2(int[] numbers) {
            Set<Integer> sums = new TreeSet<>();

            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    sums.add(numbers[i] + numbers[j]);
                }
            }

            return sums.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }

    /**
     * 기존 풀이에서 속도+메모리 개선
     * 두 수 조합 생성: O(N²)
     * 존재 여부 체크:  O(1)
     * 결과 배열 생성:  O(201)
     * → O(N²)
     * @param numbers
     * @return
     */
    public static int[] solution3(int[] numbers) {

        boolean[] sums = new boolean[201];
        int count = 0;

        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];

                if(!sums[sum]) {
                    sums[sum] = true;
                    count++;
                }
            }
        }

        int[] answer = new int[count];
        int index = 0;

        for(int i = 0; i < sums.length; i++) {
            if(sums[i]) {
                answer[index++] = i;
            }
        }

        return answer;
    }

    /**
     * 푸드 파이트
     * 왼쪽 -> 0 <- 오른쪽
     * 왼쪽과 오른쪽은 같은 수
     * @param food
     * @return
     */
    public static String solution4(int[] food) {

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < food.length; i++) {
            int foodCount = food[i] / 2;
            for(int j = 0; j < foodCount; j++) {
                sb.append(i);
            }
        }
        String answer = sb.toString();
        String answer2 = sb.reverse().toString();
        return answer + "0" + answer2;
    }

    /**
     * 푸드파이트2
     * @param food
     * @return
     */
    public static String solution5(int[] food) {
        StringBuilder sb = new StringBuilder("0");

        for(int i = food.length -1; i > 0; i--) {
            for(int j = 0; j < food[i]/2; j++) {
                sb.append(i);
                sb.insert(0, i);
            }
        }
        return sb.toString();
    }

    /**
     * 영단어+숫자가 섞여있을때 이를 숫자로 반환
     * @param s
     * @return
     */
    public static int solution6(String s) {

        String[] numberArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < numberArr.length; i++) {
            s = s.replace(numberArr[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }

    /**
     * 문자열 마음대로 정렬하기
     * 문자의 n번째 알파벳을 기준으로 정렬
     * 같은 경우는 사전순으로
     * @param strings
     * @param n
     * @return
     */
    public static String[] solution7(String[] strings, int n) {

        // Comparator<String> comparator = (s1, s2) -> Character.compare(s1.charAt(n), s2.charAt(n));        

        // Arrays.sort(strings, comparator);

        for(int i = 0; i < strings.length; i++) {
             for(int j = i + 1; j < strings.length; j++) {
                if(strings[i].charAt(n) > strings[j].charAt(n)) {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;

                } else if(strings[i].charAt(n) == strings[j].charAt(n)){
                    if(strings[i].compareTo(strings[j]) > 0) {
                        String temp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = temp;
                    }
                }
             }
        }
        return strings;
    }

    /**
     * 문자열 마음대로 정렬하기 2
     * 간소화
     * @param strings
     * @param n
     * @return
     */
    public static String[] solution8(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2);
            }
            return Character.compare(s1.charAt(n), s2.charAt(n));
        });

        return strings;
    }
}
