package algo_1;
public class Main_49 {
    
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3};

        System.out.println(solution(n, lost, reserve));
        
    }

    /**
     * 
     * @param n 학생 수
     * @param lost 체육복을 도난 당한 학생 번호
     * @param reserve 여벌의 체육복을 가져온 학생 번호
     * @return 체육수업을 들을 수 있는 학생의 최댓값
     */
    public static int solution(int n, int[] lost, int[] reserve) {
        /**
         * 1. A = 전체 학생 수 - 도난당한 학생의 수
         * 2. B = 체육복을 빌릴 수 있는 학생의 수
         * 3. return: A + B
         * 
         * 체육복을 빌릴 수 있는 학생의 수
         */

        boolean[] isReserve = new boolean[n+2];
        boolean[] isLost = new boolean[n+2];
        for(int i = 1; i < isReserve.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(i == reserve[j]) {
                    isReserve[i] = true;
                }
            }
        }

        for(int i = 1; i < isLost.length; i++) {
            for(int j = 0; j < lost.length; j++) {
                if(i == lost[j]) {
                    isLost[i] = true;
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(isReserve[i] && isLost[i]) {
                isReserve[i] = false;
                isLost[i] = false;
            }
        }

        for(int i = 1; i < isReserve.length-1; i++) {
            if (!isLost[i]) {
                continue;
            }
            if(isReserve[i-1]) {
                isReserve[i-1] = false;
                isLost[i] = false;
            } else if(isReserve[i+1]) {
                isReserve[i+1] = false;
                isLost[i] = false;
            }
        }

        int answer = n;
        for(int i = 0; i < isLost.length; i++) {
            if(isLost[i]) {
                answer--;
            }
        }
        return answer;
    }

    /**
     * 개선된 풀이
     * 상태를 별도로 저장하지 않고 하나의 배열에서 처리
     * (-1:부족, 0: 정상, 1: 여벌)
     * @param n
     * @param lost
     * @param reserve
     * @return
     */
    public static int solution2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n+2];
        
        for(int l : lost) {
            people[l]--;
        }
        for(int r : reserve) {
            people[r]++;
        }

        int answer = n;

        for(int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(people[i-1] == 1) {
                    people[i-1]--;
                    people[i]++;
                } else if(people[i+1] == 1) {
                    people[i+1]--;
                    people[i]++;
                } else {
                    answer--;
                }
            }
        }

        return answer;
    }
}
