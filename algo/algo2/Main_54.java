package algo2;

import java.util.*;

public class Main_54 {

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }

    /**
     * 인형뽑기
     * 가장 위에 있는 인형을 집어 올림
     * 아래칸부터 순서대로 쌓이며 같은 숫자가 쌓일 때 터트림
     * 터트려서 사라진 인형의 개수 구하기(모두 0일땐 아무일도 일어나지 않음)
     * @param board
     * @param moves
     * @return
     */
    public static int solution(int[][] board, int[] moves) {

        int answer = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                int num = board[j][moves[i]-1];
                if(num > 0) {
                    if(!stack.isEmpty() && stack.peek() == num) {
                        stack.pop();
                        answer+=2;
                    } else {
                        stack.push(num);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    /**
     * 개선된 풀이
     * @param board
     * @param moves
     * @return
     */
    public static int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int move : moves) {
            for (int row = 0; row < board.length; row++) {
                int num = board[row][move - 1];
            
                if (num == 0) {
                    continue;
                }
            
                if (!stack.isEmpty() && stack.peek() == num) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(num);
                }
            
                board[row][move - 1] = 0;
                break;
            }        
        }
        return answer;
    }
}
