package algo2;

import java.util.*;

public class Main_68 {
    
    public static void main(String[] args) {
        
    }

    public static int solution(String message, int[][] spoiler_ranges) {

        int answer = 0;
        int n = message.length();

        int[] spoilerAt = new int[n];

        Arrays.fill(spoilerAt, -1);

        for(int r = 0; r < spoiler_ranges.length; r++) {

            int start = spoiler_ranges[r][0];
            int end = spoiler_ranges[r][1];

            for(int i = start; i <= end; i++) {
                spoilerAt[i] = r;
            }
        }

        // 스포가 아닌 영역에서 등장한 단어
        Set<String> normalWords = new HashSet<>();

        // revealAt[r]:
        // r번째 스포 구간을 클릭했을때 완전히 공개되는 단어들
        List<List<String>> revealAt = new ArrayList<>();

        for(int i = 0; i < spoiler_ranges.length; i++) {
            revealAt.add(new ArrayList<>());
        }

        int start = 0;

        String[] words = message.split(" ");

        for(String word : words) {
            int end = start + word.length() - 1;

            //이 단어가 마지먹으로 걸쳐 있는 스포 구간 번호
            int lastRange = -1;

            for(int i = start; i <= end; i++) {
                lastRange = Math.max(lastRange, spoilerAt[i]);
            }
 
            if(lastRange == -1) {
                //스포구간에 포함되지 않은 단어
                normalWords.add(word);
            } else {
                //마지막으로 겹치는 스포 구간이 공개되는 순간 이 단어도 완전히 공개됨
                revealAt.get(lastRange).add(word);
            }

            //다음단어 시작위치 : + 1은 단어사이의 공백
            start = end + 2;
        }

        // 이전에 공개된 모든 스포 단어
        Set<String> revealed = new HashSet<>();

        //실제 스포 구간 클릭 순서대로 처리
        for(List<String> wordsAtRange : revealAt) {

            //같은 시점에 공개되는 단어는 왼 -> 오 처리
            for(String word : wordsAtRange) {

                if(!normalWords.contains(word) && !revealed.contains(word)) {
                    answer++;
                }
                //이전에 공개된 스포 단어에 포함
                revealed.add(word);
            }
        }

        return answer;
    }    


}
