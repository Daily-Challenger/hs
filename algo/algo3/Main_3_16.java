package algo3;

/**
 * 예상 대진표
 * 
 * 1부터 n까지의 번호를 부여받음
 * 1-2, 3-4, 5-6 ... 끼리 게임 진행
 * 1-2 에서의 승자는 다음 라운드 1번을 부여받음
 * 3-4 에서의 승자는 다음 라운드 2번을 부여받음
 * 게임은 한 명이 남을 떄 까지 진행
 * 
 * 이 때 A번 참가자와 B번참가자는 몇번째 라운드에서 만나는가?
 * 
 * Main_3_16
 */
public class Main_3_16 {
    
    public static void main(String[] args) {
        Main_3_16 main = new Main_3_16();

        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(main.solution(n, a, b));
        
    }

    /**
     * 현재 두 참가자가 같은 경기 조인지 확인하고, 아니라면 다음 라운드 번호를 계산하며 반복한다.
     * 동작은 직관적이지만 다음 라운드 번호 계산을 별도 메서드로 분리해 코드가 다소 길다.
     * 
     * @param n 게임 참가자 수
     * @param a 참가자1
     * @param b 참가자2
     * @return
     */
    public int solution(int n, int a, int b) {
        

        /**
         * 1-2: 1
         * 3-4: 2
         * 5-6: 3
         * 7-8: 4
         * 9-10: 5
         * 11-12: 6
         * 
         * 
         */

        //1. 둘이 이번라운드에 게임을 하는지 확인하는 법은?
        //2. 다음라운드의 번호를 확인하는 법은?

        /**
         * 1. 둘이 이번 라운드에서 게임을 하는지 확인하는법
         * 
         * 1을 빼고 2를 나눴을때 몫이 같으면 되지 않을까? 
         * 
         */

        /**
         * 다음 라운드의 숫자를 확인;
         * 2로나눈다. 
         * 나머지가 있으면 더해주고, 없으면 그 수가 본인의 수다.
         */
        int answer = 1;

        while(true) {
            if((a-1) / 2 == (b-1) / 2) {
                break;
            }

            a = getNextRoundNum(a);
            b = getNextRoundNum(b);
            answer++;

        }
        
        return answer;
    }

    private int getNextRoundNum(int n) {
        boolean isEvenNumber = n % 2 == 0;

        if(isEvenNumber) {
            return n / 2;
        } else {
            return n /2 + 1;
        }
    }

    /**
     * 두 참가자의 번호를 매 라운드마다 (번호 + 1) / 2로 갱신하고, 번호가 같아질 때까지의 횟수를 구한다.
     * 기존 풀이와 같은 원리지만 다음 라운드 계산을 단순화해 더 간결하게 구현한다.
     * @param n
     * @param a
     * @param b
     * @return
     */
    public int solution2(int n, int a, int b) {
        int round = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }

        return round;
    }    
}
