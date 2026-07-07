import java.util.Scanner;

public class Main_2 {
    
    public static void main(String[] args) {
        //수 나누기
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int answer = 0;
        

        while(number > 0) {
            answer += number % 100;
            number /= 100;
        }

        System.out.println(answer);

        sc.close();
    }
}
