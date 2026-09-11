package algo2;

import java.util.*;
import java.util.stream.Collectors;

public class Main_64 {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report =  {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        for(int i : solution(id_list, report, k)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 신고 결과 받기
     * 신고 횟수 제한 없음
     * 한 유저를 여러번 신고 가능하지만, 동일한 유저에 대한 신고 횟수는 1회로 처리
     * k번 이상 신고된 유저는 이용이 정지됨. 이 때 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
     * 
     * 신고자별 Set으로 중복 신고를 제거하고, 신고 횟수를 별도 Map으로 관리하는 방식.
     * 같은 문자열에 split()을 반복하고, 정지 대상만 남기기 위해 Map을 다시 생성하는 등 불필요한 문자열 처리와 중간 자료구조 생성이 존재한다.
     * 
     * @param id_list id 목록
     * @param report 신고정보 "A B" : A가 B를 신고함
     * @param k 정지 기준이 되는 신고 횟수
     * @return 유저별 처리 결과 메일을 받은 횟수 
     */
    public static int[] solution(String[] id_list, String[] report, int k) {

        //A가 B를 신고했다.
        //C가 B를 신고했다. 
        //B가 정지되었따. A,C에게 메일을 보낸다.

        //1. 유저별로 신고한 목록을 만든다.
        //2. 이때 신고한놈 count를 한다.

        //{신고자, {신고 한 사람 목록}}
        Map<String, Set<String>> reportMap = new HashMap<>();
        //{신고 당한 사람, count}
        Map<String, Integer> reportedMap = new HashMap<>();
        for(String s : report) {
            String reporter = s.split(" ")[0];
            String suspect = s.split(" ")[1];

            Set<String> reportSet = reportMap.getOrDefault(reporter, new HashSet<>());

            if(!reportSet.contains(suspect)) {
                int count = reportedMap.getOrDefault(suspect, 0);
                reportedMap.put(suspect, count + 1);
                
                reportSet.add(suspect);
                reportMap.put(reporter, reportSet);
            }
        }

        reportedMap = reportedMap.entrySet().stream()
                        .filter(entry -> entry.getValue() >= k)
                        .collect(Collectors.toMap(
                            Map.Entry::getKey, 
                            Map.Entry::getValue
                        ));

        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            Set<String> data = reportMap.get(id_list[i]);

            int count = 0;
            
            if(data != null) {
                for(String s : data) {
                    if(reportedMap.getOrDefault(s, 0) > 0) {
                        count++;
                    }
                }
            }

            answer[i] = count;
        }

        return answer;
    }

    /**
     * 개선된 풀이
     * 
     * 중복 신고를 먼저 제거한 뒤 유저명을 index로 변환하여 int 배열 기반으로 처리한다.
     * 문자열 Map 조회와 불필요한 중간 Map 생성을 줄이고, 신고 목록을 두 번만 순회하여
     * 시간복잡도 O(id_list + report) 수준으로 단순하고 효율적으로 처리한다.
     * 
     * @param id_list
     * @param report
     * @param k
     * @return
     */
    public static int[] solution2(String[] id_list, String[] report, int k) {

        int n = id_list.length;

        //이름 -> index
        Map<String, Integer> indexMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            indexMap.put(id_list[i], i);
        }

        // 동일한 신고는 1회만 인정
        Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));

        // 각 유저가 신고당한 횟수
        int[] reportedCount = new int[n];

        //중복 제거된 신고 관계 저장
        List<int[]> reports = new ArrayList<>(uniqueReports.size());

        for(String data: uniqueReports) {
            int blank = data.indexOf(' ');
            String reporter = data.substring(0, blank);
            String target = data.substring(blank + 1);

            int reporterIdx = indexMap.get(reporter);
            int targetIdx = indexMap.get(target);

            reports.add(new int[]{reporterIdx, targetIdx});
            reportedCount[targetIdx]++;
        }

        int[] answer = new int[n];

        for(int[] data : reports) {
            int reportIdx = data[0];
            int targetIdx = data[1];

            if(reportedCount[targetIdx] >= k) {
                answer[reportIdx]++;
            }
        }
        return answer;
    }

    
}
