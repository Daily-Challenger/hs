import java.util.ArrayList;
import java.util.List;


public class Main_15 {

    private static final List<int[]> moves = new ArrayList<>();
    public static void main(String[] args) {
        

    }

    public static int[][] solution(int n) {
        move(n, 1, 2, 3);
        return moves.toArray(new int[moves.size()][]);
    }

    public static void move(int n, int from, int via, int to) {
        if(n == 1) {
            moves.add(new int[]{from, to});
            return;
        }

        move(n-1, from, to, via);
        moves.add(new int[]{from, to});
        move(n-1, via, from, to);
    }
}
