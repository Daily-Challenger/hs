package algo3;

import java.util.*;

/**
 * 기능개발
 * 
 * 각 기능의 작업 진도와 개발 속도가 주어질 때,
 * 앞선 기능이 완료되어야 뒤의 기능도 함께 배포할 수 있다는 조건에 따라
 * 각 배포 시점마다 배포되는 기능의 개수를 구한다.
 *
 * Main_3_24
 */
public class Main_3_24 {
    
    public static void main(String[] args) {
        Main_3_24 main = new Main_3_24();

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 30, 5};

        for(int i : main.solution(progresses, speeds)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 각 기능의 완료일을 계산하고, 현재 배포 기준일과 비교하여 그룹화한다.
     * 기준일 이내에 완료되는 기능은 같은 그룹으로 묶고, 초과하면 새로운 배포 그룹을 생성한다.
     * 별도의 Queue 없이 기준일과 기능 개수만 관리하여 O(N)에 처리한다.
     * 
     * @param progresses
     * @param speeds
     * @return
     */
    private int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int deployDay = getWorkingDay(progresses[0], speeds[0]);
        int count = 1;

        for(int i = 1; i < progresses.length; i++) {
            int workingDay = getWorkingDay(progresses[i], speeds[i]);

            if(workingDay > deployDay) {
                list.add(count);
                deployDay = workingDay;
                count = 1;
            } else {
                count++;
            }
        }

        //마지막 그룹 배포
        list.add(count);

        return list.stream().mapToInt(i -> i).toArray();
    }
    
    private int getWorkingDay(int progress, int speed) {

        int remain = 100 - progress;
        return remain % speed == 0 ? remain / speed : remain / speed + 1;
    }
}
