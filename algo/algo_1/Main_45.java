package algo_1;
public class Main_45 {
    
    public static void main(String[] args) {

        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(solution(s, skip, index));
    }

    public static String solution(String s, String skip, int index) {

        //index 만큼 건너뛰는데; 
        //skip과 겹치면 세지 않음;

        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            int skipCnt = index;
            
            while(skipCnt > 0) {
                c++;
                if(c > 'z') {
                    c -= 26;
                }
                if(!skip.contains(String.valueOf(c))) {
                    skipCnt--;
                }
            }
            

            sb.append(String.valueOf(c));
        }
        return sb.toString();
    }
}
