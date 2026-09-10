package algo2;

public class Main_63 {
    
    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println(solution2(bandage, health, attacks));
        
    }

    /**
     * 붕대감기
     * t 초동안 1초마다 x만큼 회복
     * t 초 연속으로 붕대를 감는데 성공 시 y 만큼 체력 추가 확보
     * 공격 당하면 취소. 
     * 취소당하거나 기술이 끝나면 즉시 붕대감기 다시 사용 -> 연속 시간 0으로 초기화
     * 1. 공격턴인가?
     * 1-1. true
     *  - 피를 감소 시킨다.
     *  - 0이되면 사망이다.
     *  - 0보다 큰경우 연속 성공시간을 0으로 초기화 한다.
     * 
     * 1-2. false.
     *  - 피를 회복시킨다.
     *  - 추가회복 시킨다.
     *  - 연속 = 시전시간 인경우 0으로 초기화 한다.
     * @param bandage {기술시전시간, 초당 회복량, 추가회복량}
     * @param health 최대 체력
     * @param attacks {{공격시간, 피해량}...} - 공격 시간 기준 오름차순
     * @return
     */
    public static int solution(int[] bandage, int health, int[][] attacks) {

        int continuous = 0;
        int nowHealth = health;        
        int lastTime = attacks[attacks.length-1][0];

        int attackIdx = 0;
        for(int i = 1; i <= lastTime; i++) {
            if(i == attacks[attackIdx][0]) {
                
                nowHealth -= attacks[attackIdx][1];
                if(nowHealth < 1) {
                    return -1;
                } else {
                    continuous = 0;
                }
                attackIdx++;
            } else {
                nowHealth = Math.min(health, nowHealth + bandage[1]);
                continuous++;
                if(continuous == bandage[0]) {
                    nowHealth = Math.min(health, nowHealth + bandage[2]);
                    continuous = 0;
                }
            }
        }

        return nowHealth;
    }    

    /**
     * 개선된 풀이
     * 모든 시간을 체크하지 않고, 공격받은 시간을 체크하여 
     * 지금공격과 이전 공격 사이의 회복량과 추가 회복 횟수를 한번에 계산
     * 반복횟수가 '1~마지막 공격시간' -> '공격횟수' 로 줄어든다.
     * @param bandage
     * @param health
     * @param attacks
     * @return
     */
    public static int solution2(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health;
        int previousAttackTime = 0;

        for(int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];

            //이전 공격 이후부터 현재 공격 직전까지 회복 가능한 시간
            int healTime = attackTime - previousAttackTime - 1;

            //기본 힐
            int healAmount = healTime * bandage[1];

            //연속 회복 성공 횟수 계산
            int bonusCount = healTime / bandage[0];
            healAmount += bonusCount * bandage[2];

            currentHealth = Math.min(health, currentHealth+healAmount);

            //현재 시간에는 공격을 받으므로 회복하지 않음
            currentHealth -= damage;

            if(currentHealth <= 0) {
                return -1;
            }

            previousAttackTime = attackTime;
        }

        return currentHealth;
    }
}
