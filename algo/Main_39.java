import java.util.*;

public class Main_39 {
    
    public static void main(String[] args) {
        int[] answer = {1,3,2,4,2};
        for(int i : solution(answer)) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int[] answers) {

        int[] num1Answer = {1, 2, 3, 4, 5};
        int[] num2Answer = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3Answer = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == num1Answer[i%num1Answer.length]) {
                num1++;
            }
            if(answers[i] == num2Answer[i%num2Answer.length]) {
                num2++;
            }
            if(answers[i] == num3Answer[i%num3Answer.length]) {
                num3++;
            }
        }

        int max = Math.max(num1, Math.max(num2, num3));

        List<Integer> list = new ArrayList<>();
        if(max == num1) {
            list.add(1);
        }
        if(max == num2) {
            list.add(2);
        }
        if(max == num3) {
            list.add(3);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
