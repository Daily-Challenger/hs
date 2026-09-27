package algo3;

import java.util.Arrays;

public class Main_3_11 {

    public static void main(String[] args) {
        Main_3_11 main = new Main_3_11();

        int[] people = {70, 50, 80};
        int n = 100;

        System.out.println(main.solution(people, n));
        
    }

    /**
     * 구명보트
     * 
     * 구명보트는 최대 2명까지 탑승할 수 있으며, 두 사람의 무게 합이 제한을 넘을 수 없다.
     * 모든 사람을 구출할 때 필요한 최소 보트 수를 구한다.
     * 
     * 정렬 후 가장 무거운 사람 + 가장 가벼운 사람을 투 포인터로 비교
     * 
     * @param people
     * @param limit
     * @return
     */
    public int solution(int[] people, int limit) {
        int answer = 0;

        int x = 0;
        int y = people.length - 1;

        Arrays.sort(people);

        while(x <= y) {

            if(people[x] + people[y] <= limit) {
                x++;
            } 

            y--;
            answer++;
        }
        return answer;
    } 


}
