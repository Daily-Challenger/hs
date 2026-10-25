package algo3;

import java.util.*;

public class Main_3_37 {
    
    public static void main(String[] args) {
       
    }

    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> inMap = new HashMap<>();

        
        // 차량별 누적 주차 시간
        Map<String, Integer> totalTimeMap = new TreeMap<>();

        for (String record : records) {
            String[] arr = record.split(" ");

            int time = toMinute(arr[0]);
            String car = arr[1];
            String type = arr[2];

            if ("IN".equals(type)) {
                // 입차 시간 저장
                inMap.put(car, time);

                // 출차 기록이 없어도 차량이 결과에 포함되도록 초기화
                totalTimeMap.putIfAbsent(car, 0);

            } else {
                // 입차 시간을 가져오면서 제거
                int inTime = inMap.remove(car);

                // 주차 시간 계산
                int parkingTime = time - inTime;

                // 누적 주차 시간 갱신
                totalTimeMap.put(
                    car,
                    totalTimeMap.get(car) + parkingTime
                );
            }
        }

        // 2. 출차하지 않은 차량 처리 (23:59)
        int endTime = toMinute("23:59");

        for (String car : inMap.keySet()) {
            int inTime = inMap.get(car);
            int parkingTime = endTime - inTime;

            totalTimeMap.put(
                car,
                totalTimeMap.get(car) + parkingTime
            );
        }

        // 3. 차량별 요금 계산
        int[] answer = new int[totalTimeMap.size()];
        int idx = 0;

        for (int totalTime : totalTimeMap.values()) {

            int charge = fees[1];

            if (totalTime > fees[0]) {
                int extraTime = totalTime - fees[0];

                // 단위 시간으로 나누고 올림
                int units = (extraTime + fees[2] - 1) / fees[2];

                charge += units * fees[3];
            }

            answer[idx++] = charge;
        }

        return answer;
    }

    private int toMinute(String time) {
        String[] arr = time.split(":");

        return Integer.parseInt(arr[0]) * 60
             + Integer.parseInt(arr[1]);
    }    
}
