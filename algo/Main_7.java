import java.util.*;

public class Main_7 {
    
    public static void main(String[] args) {
        
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(solution(record));
    }

    public static String[] solution(String[] record) {
        
        Map<String, String> userInfo = new HashMap<>();

        for(String str : record) {
            String[] chat = str.split(" ");

            if("Enter".equals(chat[0]) || "Change".equals(chat[0])) {
                userInfo.put(chat[1], chat[2]);
            }
        }

        List<String> messeageList = new ArrayList<>();
        for(String str : record) {
            String[] chat = str.split(" ");
            String userName = userInfo.get(chat[1]);
            
            if("Enter".equals(chat[0])) {
                messeageList.add(userName + "님이 들어왔습니다.");
            } else if("Leave".equals(chat[0])) {
                messeageList.add(userName + "님이 나갔습니다.");
            } else {
                continue;
            }
        }
        
        String[] answer = messeageList.toArray(new String[0]);
        return answer;
    }
}
