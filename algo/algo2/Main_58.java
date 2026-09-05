package algo2;

public class Main_58 {
    
    public static void main(String[] args) {
        int[] schedules = {700, 800, 1100};
        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int startday = 5;

        System.out.println(solution(schedules, timelogs, startday));
    }

    /**
     * 유연 근무제
     * - 일주일 동안 늦지않고 출근한 사람에게 상품 지급
     * - 기준: 출근 희망시각 + 10분
     * - 토,일 은 제외
     * - 시각 표시 : (시 * 100) + 분
     * - 
     * @param schedules n명이 설정한 출근 희망 시각
     * @param timelogs  직원들이 일주일 동안 출근한 시각
     * @param startday 이벤트를 시작한 요일(1: 월, 2: 화, 3: 수, 4: 목, 5: 금, 6: 토, 7: 일)
     * @return
     */
    public static int solution(int[] schedules, int[][] timelogs, int startday) {

        
        int answer = 0;

        for(int i = 0; i < schedules.length; i++) {

            int schedule = schedules[i];

            int scheduleMax = schedule + 10;
            if(scheduleMax % 100 >= 60) {
                scheduleMax += 40;
            }

            int idx = 0;
            boolean isNotLate = true;
            int today = startday;
            while(idx < timelogs[i].length) {
                if(today % 7 == 0 || today % 7 == 6) {
                    today++;
                    idx++;
                    continue;
                }

                int timelog = timelogs[i][idx];
                
                if(timelog > scheduleMax) {
                    isNotLate = false;
                    break;
                }
                today++;
                idx++;
            }

            if(isNotLate) {
                answer++;
            }
        }
        
        return answer;
    }    
}
