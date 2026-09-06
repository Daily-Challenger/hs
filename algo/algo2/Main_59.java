package algo2;

import java.util.*;

public class Main_59 {

    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        for(int i : solution(today, terms, privacies)) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {

        //날짜 계산

        int[] todayDate = Arrays.stream(today.split("\\."))
                            .mapToInt(i -> Integer.parseInt(i))
                            .toArray();
        
        Map<String, String[]> lastDateMap = new HashMap<>();        

        for(String s : terms) {
            String termKey = s.split(" ")[0];
            int termValue = Integer.parseInt(s.split(" ")[1]);

            int termYear = termValue / 12;
            int termMonth = termValue % 12;
            int monthMinus = todayDate[1] - termMonth;

            int year = monthMinus < 1 ? todayDate[0] - termYear - 1 : todayDate[0] - termYear;
            int month = monthMinus < 1 ? 12 + monthMinus : monthMinus;
            int day = todayDate[2];

            String[] termDate = {String.valueOf(year), 
                month < 10 ? "0" + month : String.valueOf(month), 
                day < 10 ? "0" + day : String.valueOf(day)};

            lastDateMap.put(termKey, termDate);
        }

        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {

            String date = privacies[i].split(" ")[0];
            String key = privacies[i].split(" ")[1];

            String[] privacyDate = date.split("\\.");

            String[] termDate = lastDateMap.get(key);

            StringBuilder sb1 = new StringBuilder()
                .append(privacyDate[0])
                .append(privacyDate[1])
                .append(privacyDate[2]);

            StringBuilder sb2 = new StringBuilder()
                .append(termDate[0])
                .append(termDate[1])
                .append(termDate[2]);

            if(sb1.compareTo(sb2) <= 0) {
                answer.add(i + 1);
            }

        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 모든 달이 28일로 고정되어 있으므로 날짜 계산을 보다 단순하게 할 수 있다.
     * (조건 단순화)
     * @param today
     * @param terms
     * @param privacies
     * @return
     */
    public static int[] solution2(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();

        for(String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }

        int todayDate = toDays(today);

        List<Integer> answer = new ArrayList<>();

        for(int i = 0 ; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            int collectedDate = toDays(privacy[0]);
            int validMonth = termMap.get(privacy[1]);

            int expirationDate = collectedDate + validMonth * 28;

            if(expirationDate <= todayDate) {
                answer.add(i + 1);
            }
        }
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }

    public static int toDays(String date) {
        String[] split = date.split("\\.");

        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        return year * 12 * 28
                + month * 28
                + day;
    }
    
}
