package algo3;

/**
 * 행렬의 곱셈
 * 
 * 2차원 행렬 arr1과 arr2를 입력받아 arr1에 arr2를 곱한 결과를 반환하는 함수를 완성
 * 
 * 
 * Main_3_23
 */
public class Main_3_23 {
    
    public static void main(String[] args) {
        Main_3_23 main = new Main_3_23();
        
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}; 
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        for(int[] arr : main.solution(arr1, arr2)) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    private int[][] solution(int[][] arr1, int[][] arr2) {


        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for(int k = 0; k < arr1[i].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}
