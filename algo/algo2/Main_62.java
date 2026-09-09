package algo2;

import java.util.Arrays;

public class Main_62 {
    

    public static void main(String[] args) {
        int[] mats = {5, 3, 2};
        String[][] park = {
            {"A", "A", "-1", "B", "B", "B", "B", "-1"}, 
            {"A", "A", "-1", "B", "B", "B", "B", "-1"}, 
            {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, 
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, 
            {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, 
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        System.out.println(solution(mats, park));
    }

    /**
     * 공원
     * 가지고 있는 돗자리 중 깔 수 있는 가장 큰 길이 구하기
     * (깔 수 없는 경우는 -1 반환)
     * @param mats 가지고 있는 돗자리 길이
     * @param park 공원(-1: 비어있는 자리, 그 외: 이미 돗자리가 있는 자리 - 깔 수 없음)
     * @return
     */
    public static int solution(int[] mats, String[][] park) {
        /**
         * mats를 오름차순 정렬
         * 가장 큰 돗자리부터 들어가는지 확인
         * 공원의 모든 칸을 돗자리의 왼쪽 위 시작점이라고 가정
         * 그 위치에서 size x size 영역이 전부 "-1"인지 확인
         * 하나라도 가능하면 바로 해당 size를 반환
         */

        Arrays.sort(mats);

        int height = park.length;
        int width = park[0].length;

        //가장 큰 돗자리부터 확인
        for(int i = mats.length-1; i >= 0; i--){

            int size = mats[i];
            //돗자리가 공원보다 큰 경우는 검사할 필요 없음
            if(size > height || size > width) {
                continue;
            }

            // 돗자리의 왼쪽 위 좌표를 하나씩 정한다.
            for(int row = 0; row <= height - size; row++) {
                for(int col = 0; col <= width - size; col++) {
                    if(canPlace(park, row, col, size)) {
                        return size;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean canPlace(String[][] park, int row, int col, int size) {

        for(int y = row; y < row + size; y++) {
            for(int x = col; x < col + size; x++) {
                if(!"-1".equals(park[y][x])) {
                    return false;
                }
            }
        }

        return true;
    }
}
