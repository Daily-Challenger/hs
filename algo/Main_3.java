public class Main_3 {

    public static void main(String[] args) {
        
        String video_len = 	"07:22";
        String pos = "04:05"; 
        String op_start = "00:15";
        String op_end = "04:07";
        String[] commands = {"next"};

        System.out.println(solution(video_len, pos, op_start, op_end, commands));
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        /**
         * 제공하는 기능
         * prev: 10초 전으로 이동(현재 위치가 10초 미만인 경우 0으로)
         * next: 10초 후로 이동(남은 시간이 10초 미만인 경우 마지막 위치-동영상의 길이)
         * 오프닝 건너뛰기: 현재 위치가 오프닝 구간인 경우 자동으로 오프닝이 끝나는 위치로 이동
         * 
         * 입력이 끝난 후 동영상의 위치를 "mm:ss" 형식으로 return
         */
        String answer = "";
        
        int videoSec = convertToSec(video_len);
        int posSec = convertToSec(pos);
        int opsSec = convertToSec(op_start);
        int opeSec = convertToSec(op_end);

       
        //현재 위치가 오프닝 구간인지 여부 확인
        if(opsSec <= posSec && opeSec >= posSec) {
            posSec = opeSec;
        }

        //동작
        for(String move : commands) {
            if("prev".equals(move)) {
                posSec = posSec - 10 < 0 ? 0 : posSec - 10;
            } else {
                posSec = posSec + 10 >= videoSec ? videoSec : posSec + 10;
            }

            if(opsSec <= posSec && opeSec >= posSec) {
                posSec = opeSec;
            }
        }

        int m = posSec / 60;
        int s = posSec % 60;

        String mm = m < 10 ? "0" + String.valueOf(m) : String.valueOf(m);
        String ss = s < 10 ? "0" + String.valueOf(s) : String.valueOf(s);

        answer = mm + ":" + ss;
        return answer;
    }

    public static int convertToSec(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
}
