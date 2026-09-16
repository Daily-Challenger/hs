package algo3;

import java.util.Arrays;

/**
 * 최솟값 최댓값
 * Main_3_1
 */
public class Main_3_1 {
    
    public static void main(String[] args) {
        String s = "-4 -3 -2 -1 -5";
        System.out.println(solution2(s));
    }

    public static String solution(String s) {

        int[] arr = Arrays.stream(s.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0])
            .append(" ")
            .append(arr[arr.length-1]);

        return sb.toString();
    }

    /**
     * 람다 사용하지 않고 풀이
     * @param s
     * @return
     */
    public static String solution2(String s) {

        String[] arr = s.split(" ");

        int min = Integer.parseInt(arr[0]); 
        int max = Integer.parseInt(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            int n = Integer.parseInt(arr[i]);

            if(n < min) {
                min = n;
            }

            if(n > max) {
                max = n;
            }
        }

        return min + " " + max;
    }
}
