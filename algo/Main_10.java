import java.util.TreeSet;

public class Main_10 {
    public static void main(String[] args) {
        
        String[] wallpaper = {"..", "#."};
        for (int i : solution(wallpaper)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 바탕화면 정리
     * 최소 드래그 범위 구하기
     * 드래그 시작점(lux, luy), 끝점(rdx, rdy) 
     * <ul>
     *  <li>1 <= wallpaper 의 길이 <= 50 </li>
     *  <li>1 <= wallpaper[i] 의 길이 <= 50 </li>
     *  <li>wallpaper[i][j] 는 "." 또는 "#" </li>
     *  <li>lux < rdx, luy < rdy</li>
     * </ul>
     * @param wallpaper
     * @return {lux, luy, rdx, rdy}
     */
    public static int[] solution(String[] wallpaper) {

        TreeSet<Integer> xList = new TreeSet<>();
        TreeSet<Integer> yList = new TreeSet<>();
        for(int i = 0; i < wallpaper.length; i++){

            for(int j = 0; j < wallpaper[0].length(); j++) {
                if('#' == (wallpaper[i].charAt(j))) {
                    xList.add(i);
                    yList.add(j);
                }
            }
        }

        int[] answer = {xList.first(), yList.first(), xList.last() + 1, yList.last() + 1};
        return answer;
    }

    /**
     * 최솟값과 최댓값만 필요함
     * 데이터를 전부 저장-정렬 -> for문에서 바로 갱신하는 방식이 더 효율적
     */
    public static int[] solution2(String[] wallpaper) {

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++){
                if('#' == wallpaper[i].charAt(j)) {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }
}
