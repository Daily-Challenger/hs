import java.util.Scanner;

public class Main_22 {

    public static void main(String[] args) {
        solution4();
    }

    public static void solution1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(str);

        sc.close();
    }

    public static void solution2() {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int n = sc.nextInt();

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            sb.append(str);
        }

        System.out.println(sb.toString());

        sc.close();
    }

    public static void solution3() {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        StringBuffer sb = new StringBuffer();
        for(char c : a.toCharArray()) {
            if(Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }

        System.out.println(sb.toString());

        sc.close();
    }

    public static void solution4() {
        String s = "!@#$%^&*(\\'\"<>?:;";

        System.out.println(s);
    }
    
}
