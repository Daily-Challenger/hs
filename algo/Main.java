import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //각도 합치기
        Scanner sc = new Scanner(System.in);
        int angle1 = sc.nextInt();
        int angle2 = sc.nextInt();

        int sum = (angle1 + angle2) % 360;

        System.out.println(sum);
    }
}
