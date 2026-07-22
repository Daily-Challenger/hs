/**
 * 쿼드 트리
 * Main_17
 */
public class Main_17 {
    
    public static void main(String[] args) {
        
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        for(int i : solution(arr)) {
            System.out.println(i);
        }
    }
    private static final int[] answer = new int[2];

    public static int[] solution(int[][] arr) {
        divide(arr, 0, 0, arr.length);
        return answer;
    }

    public static void divide(int[][] arr, int row, int col, int size) {
        if(isSame(arr, row, col, size)) {
            answer[arr[row][col]]++;
            return;
        }

        int half = size / 2;

        divide(arr, row, col, half);
        divide(arr, row, col + half, half);
        divide(arr, row + half, col, half);
        divide(arr, row + half, col + half, half);
    }

    public static boolean isSame(int[][] arr, int row, int col, int size) {
        int value = arr[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
