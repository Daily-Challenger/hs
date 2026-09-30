package algo3;

import java.util.*;

public class Main_3_15 {
 
    public static void main(String[] args) {
        Main_3_15 main = new Main_3_15();

        int[] elements = {7,9,1,1,4};
        System.out.println(main.solution(elements));
    }

    private int solution(int[] elements) {

        Set<Integer> sumSet = new HashSet<>();
        
        for(int i = 0; i < elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                int sum = elements[j];
                for(int k = j + 1; k <= j + i; k++) {
                    sum += k > elements.length - 1 ? elements[k - elements.length] : elements[k];
                }
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }

    /**
     * 슬라이딩 윈도우로 반복횟수 줄이기
     * @param elements
     * @return
     */
    private int solution2(int[] elements) {

        Set<Integer> sumSet = new HashSet<>();
        int n = elements.length;

        for(int len = 1; len <= n; len++) {
            int sum = 0;

            //첫번째 구간 합
            for(int i = 0; i < len; i++) {
                sum += elements[i];
            }

            sumSet.add(sum);

            for(int start = 1; start < n; start++) {

                //앞 원소 제거
                sum -= elements[start - 1];
                //새롭게 들어오는 원소 추가
                int nextIndex = (start + len - 1) % n;
                sum += nextIndex;

                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}
