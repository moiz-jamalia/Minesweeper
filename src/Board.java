import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Board {
    public static int[] mines;
    public static Field[][] board;
    public static int Yboard;
    public static int Xboard;
    public static int AmountMines;
    public String difficulties;
    Random random = new Random();
    Scanner input = new Scanner(System.in);

    public Board() {
        System.out.println("choose your difficulty (easy, medium or hard): ");
        difficulties = input.next();

        switch (difficulties) {
            case "easy":
                Difficulties.easy();
                Xboard = Difficulties.getXBoard();
                Yboard = Difficulties.getYBoard();
                AmountMines = Difficulties.getAmountMines();
                break;

            case "medium":
                Difficulties.medium();
                Xboard = Difficulties.getXBoard();
                Yboard = Difficulties.getYBoard();
                AmountMines = Difficulties.getAmountMines();
                break;

            case "hard":
                Difficulties.hard();
                Xboard = Difficulties.getXBoard();
                Yboard = Difficulties.getYBoard();
                AmountMines = Difficulties.getAmountMines();
                break;
        }
        mines = new int[AmountMines];
        board = new Field[Xboard][Yboard];
        startBoard();
        RandomMines();
    }

    public int getXboard() {
        return Xboard;
    }

    public int getYboard() {
        return Yboard;
    }

    public void startBoard() {
        for (int i = 0; i < Xboard; i++) {
            for (int j = 0; j < Yboard; j++) {
                board[i][j] = new Field();
            }
        }
    }

    public void RandomMines(){
        int Line;
        int Column;
        for(int i = 0; i < AmountMines; i++){
            Line = random.nextInt(Xboard);
            Column = random.nextInt(Yboard);
            if (board[Line][Column].GetIsBomb()) {
                RandomMines();
            } else {
                board[Line][Column].SetIsBomb(true);
            }
        }
    }

        public static void show() {
            System.out.println("\n\tlines");
            for (int line = Xboard - 1; line > 0; line--) {
                System.out.print("\t" + line);
                for (int column = 0; column < Yboard - 1; column++) {
                    System.out.print("\t_");
                    if (board[Xboard][Yboard].isBomb = true){
                        System.out.print("\t*");
                    }else {
                        System.out.println("\t_");
                    }
                }
                System.out.println();
            }
            System.out.print("\t ");
            for (int column = 1; column < Yboard; column++) {
                System.out.print("\t" + column);
            }
            System.out.print("\t Columns");
        }

    private Field[][] testBoard(int Xboard, int Yboard) {
        try {
            board = new Field[Xboard][Yboard];
            return board;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Field[][]> showNeighbour(Board board) {
        int y = board.getYboard();
        int x = board.getXboard();

        ArrayList<Field[][]> b = new ArrayList<>();
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