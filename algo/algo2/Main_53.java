package algo2;

import java.util.*;

public class Main_53 {
    
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        
        for (int[] arr : solution(data, ext, val_ext, sort_by)) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /**
     * data: {"코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"}
     * data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬
     * @param data 데이터
     * @param ext 추출 기준
     * @param val_ext 기준값
     * @param sort_by 정렬할 기준
     * @return
     */
    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();

        int extIdx = getIdx(ext);
        int sortIdx = getIdx(sort_by);

        for(int[] arr : data) {
            if(arr[extIdx] < val_ext) {
                list.add(arr);
            }
        }

        list.sort(Comparator.comparingInt(arr -> arr[sortIdx]));

        return list.stream().toArray(int[][]::new);
    }

    public static int getIdx(String s) {
        return switch(s) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> throw new IllegalArgumentException("Unknown column: " + s);
        };
    }
}
