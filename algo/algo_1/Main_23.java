package algo_1;
public class Main_23 {
 
    public static void main(String[] args) {
        
        // int num1 = 3;
        // int num2 = 2;
        // System.out.println(solution5(num1, num2));


        // int numer1 = 1;
        // int denom1 = 2; 
        // int numer2 = 3;
        // int denom2 = 4;
        // for(int i : solution7(numer1, denom1, numer2, denom2)) {
        //     System.out.println(i);
        // }

        int[] numbers = {1,2,100,-99,1,2,3};
        for(int i : solution8(numbers)) {
            System.out.print(i + " ");
        }
    }

    public static int solution(int num1, int num2) {
        int answer = -1;

        answer = num1 + num2;
        return answer;
    }

    public static int solution2(int num1, int num2) {
        int answer = -1;

        answer = num1 - num2;
        return answer;
    }

    public static int solution3(int num1, int num2) {
        int answer = -1;

        answer = num1 * num2;
        return answer;
    }

    public static int solution4(int num1, int num2) {
        int answer = -1;

        answer = num1 / num2;
        return answer;
    }

    public static int solution5(int num1, int num2) {

        double a = (double) num1 / num2;
        int answer = (int) (a * 1000);

        return answer;
    }

    public static int solution6(int num1, int num2) {

        int answer = -1;
        if(num1 == num2) {
            answer = 1;
        }

        return answer;
    }

    public static int[] solution7(int numer1, int denom1, int numer2, int denom2) {

        int numer3 = (numer1 * denom2) + (numer2 * denom1);
        int denom3 = denom1 * denom2;

        int num = numer3 < denom3 ? numer3 : denom3;

        while(num > 1) {
            if(numer3 % num == 0 && denom3 % num == 0) {
                numer3 = numer3 / num;
                denom3 = denom3 / num;
                break;
            } 
            num --;
        }

        int[] answer = {numer3, denom3};
        return answer;
    }

    public static int[] solution8(int[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = numbers[i] * 2;
        }

        return answer;
    }
}
