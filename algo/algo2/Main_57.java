package algo2;

public class Main_57 {

    public static void main(String[] args) {
        String new_id = "abcdefghijklmn.p";
        System.out.println(solution(new_id));
    }

    /**
     * 신규 아이디 추천
     * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
     * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
     * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
     * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
     * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
     * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     * 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
     * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     * 
     * @param new_id
     * @return
     */
    public static String solution(String new_id) {

        String recommandId = new_id.toLowerCase();
        
        String regex = "[^a-z0-9_.-]";

        recommandId = recommandId.replaceAll(regex, "");

        //"......."일때 여러번 반복해서 처리 -> 정규식으로 한번에 처리
        while(recommandId.contains("..")) {
            recommandId = recommandId.replace("..", ".");
        }
        
        if(recommandId.startsWith(".")) {
            //첫번째 인자는 정규식으로 '마침표'가 아니라 '아무문자'를 확인하는거라, 정확한 표현은  \\.
            recommandId = recommandId.replaceFirst(".", "");
            
        } 
        
        if(recommandId.endsWith(".")) {
            if(recommandId.length() > 1) {
                recommandId = recommandId.substring(0, recommandId.length() - 1);
            } else {
                recommandId = "";
            }
            
        }

        //isEmpty가 적절 - 공백은 이미 제거되어 길이가 0인지만 확인하면 됨
        if(recommandId.isBlank()) {
            recommandId = "a";
        }

        if(recommandId.length() >= 16) {
            recommandId = recommandId.substring(0, 15);
            if(recommandId.endsWith(".")) {
                recommandId = recommandId.substring(0, recommandId.length() - 1);
            }
        } 

        if(recommandId.length() <= 2) {
            char last = recommandId.charAt(recommandId.length()-1);
            while (recommandId.length() < 3) {
                recommandId += last;
            }
        }

        return recommandId;
    }

    /**
     * 개선된 풀이
     * @param new_id
     * @return
     */
    public static String solution2(String new_id) {

        String id = new_id.toLowerCase();

        id = id.replaceAll("[^a-z0-9._-]", "");
        id = id.replaceAll("\\.{2,}", ".");
        id = id.replaceAll("^\\.|\\.$", "");

        if(id.isEmpty()) {
            id = "a";
        }

        if(id.length() > 15) {
            id = id.substring(0, 15);
            id = id.replaceAll("\\.$", "");


        }

        while(id.length() < 3) {
            id += id.charAt(id.length() - 1);
        }
        
        return id;
    }
    
}
