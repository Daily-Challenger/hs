import java.util.*;

public class Main_14 {
    
    public static void main(String[] args) {
        
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        for(int i : solution2(k, score)) {
            System.out.print(i + ", ");
        }
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < score.length; i++) {

            if(list.size() < k) {
                list.add(score[i]);
            } else {
                if(list.getFirst() < score[i]) {
                    list.set(0, score[i]);
                }
            }
            // 새 점수가 명예의 전당에 들어가지 않는 날도 정렬
            // n번 반복 × k개 정렬
            // = O(n × k log k)
            Collections.sort(list);
            answer[i] = list.getFirst();
        }
        return answer;
    }

    public static int[] solution2(int k, int[] score) {
        int[] answer = new int[score.length];

        //기본적으로 작은 숫자가 우선순위가 높음
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < score.length; i++) {
            //새값이 들어오거나 나올떄만 정렬
            //O(log k)
            priorityQueue.offer(score[i]);

            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }

            answer[i] = priorityQueue.peek();
        }

        return answer;
    }
}
