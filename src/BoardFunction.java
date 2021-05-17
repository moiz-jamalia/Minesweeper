import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class BoardFunction {

    public static void show(){
        for (int i = 0; i < Board.Xboard; i++){
            for (int j = 0; j < Board.Yboard; j++){
                Board.board = new char[i][j];
            }
        }
    }

    public static boolean win(){
        return true;
    }

    public static void startBoard() {
        for (int i = 0; i < Board.Xboard; i++) {
            for (int j = 0; j < Board.Yboard; j++) {
                Board.board[i][j] = '_';
            }
        }
    }

    private static char[][] testBoard(int Xboard, int Yboard) {
        try {
            Board.board = new char[Xboard][Yboard];
            return Board.board;
        } catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<char[][]> showNeighbour(Board board) {
        int y = board.getYboard();
        int x = board.getXboard();

        ArrayList<char[][]> b = new ArrayList<>();
        b.add(testBoard(x, y + 1));
        b.add(testBoard(x, y - 1));
        b.add(testBoard(x - 1, y));
        b.add(testBoard(x - 1, y + 1));
        b.add(testBoard(x - 1, y - 1));
        b.add(testBoard(x + 1, y));
        b.add(testBoard(x + 1, y + 1));
        b.add(testBoard(x + 1, y - 1));
        return b.stream().filter(Objects::nonNull).collect(Collectors.toCollection(ArrayList::new));
    }
}
