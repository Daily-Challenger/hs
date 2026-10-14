package algo3;

import java.util.*;

/**
 * 튜플
 * 
 * 중복 원소가 없는 튜플을 집합으로 표현한 문자열이 주어진다.
 * 집합의 순서와 내부 원소의 순서는 무관하며,
 * 주어진 집합들로부터 원래 튜플의 원소 순서를 복원하여 반환한다.
 * Main_3_29
 */
public class Main_3_29 {
    
    public static void main(String[] args) {
     
        Main_3_29 main = new Main_3_29();

        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        for(int i : main.solution(s)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 
     * 문자열을 직접 파싱하여 각 집합을 리스트로 저장하고, 집합 크기순으로 정렬한다.
     * LinkedHashSet을 이용해 처음 등장한 원소를 순서대로 추출한다.
     * 모든 집합을 별도로 저장하므로 메모리 사용과 중간 처리 과정이 상대적으로 많다.
     * 
     * @param s
     * @return
     */
    public int[] solution(String s) {

        String temp = s.substring(1, s.length() - 1);

        List<List<Integer>> totalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int num = 0;
        boolean hasNumber = false;


        for(char c : temp.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                hasNumber = true;
            } else if(c == ',' || c == '}'){
                if(hasNumber) {
                    list.add(num);
                    num = 0;
                    hasNumber = false;
                }

                if(c == '}') {
                    totalList.add(list);
                    list = new ArrayList<>();
                }
            }
        }

        totalList.sort(Comparator.comparingInt(List::size));

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for(List<Integer> inner : totalList) {
            for(int i : inner) {
                set.add(i);   
            }
        }

        return set.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 
     * 문자열을 집합 단위로 분리하고, 집합의 크기순으로 정렬한다.
     * boolean 배열로 중복 여부를 확인하며 새로운 원소를 순서대로 추출한다.
     * 불필요한 중간 리스트와 Set 생성을 제거하여 구현을 간소화한다.
     * 
     * @param s
     * @return
     */
    public int[] solution2(String s) {
        
        String[] groups = s.substring(2, s.length() - 2)
                       .split("\\},\\{");
        
        Arrays.sort(groups, Comparator.comparingInt(String::length));

        int[] answer = new int[groups.length];
        boolean[] visited = new boolean[100001];

        int idx = 0;

        for(String group : groups) {
            for(String value : group.split(",")) {
                int num = Integer.parseInt(value);

                // 처음 등장한 원소만 결과에 추가한다.
                if(!visited[num]) {
                    visited[num] = true;
                    answer[idx++] = num;
                }
            }
        }

        return answer;
    }
}
