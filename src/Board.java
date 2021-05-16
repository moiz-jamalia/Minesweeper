import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Board {
    public int[] mines;
    public char[][] board;
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
        board = new char[Xboard][Yboard];
        PlaceMines();
        randomMines();
        startBoard();
    }

    public int getXboard() {
        return Xboard;
    }

    public int getYboard() {
        return Yboard;
    }

    public void randomMines() {
        boolean draw;
        int position;
        for (int i = 0; i < AmountMines; i++) {
            do {
                position = random.nextInt(AmountMines) + 1;
                draw = mines[position] == -1;
            } while (draw);
            mines[position] = -1;
        }
    }

    public void PlaceMines() {
        for (int i = 0; i < AmountMines; i++) {
            mines[i] = 0;
        }
    }

    public void startBoard() {
        for (int i = 0; i < Xboard; i++) {
            for (int j = 0; j < Yboard; j++) {
                board[i][j] = '_';
            }
        }
    }

    public boolean win() {
        int count = 0;
        for (int line = 1; line < Xboard - 1; line++) {
            for (int column = 1; column < Yboard - 1; column++) {
                if (board[line][column] == '_') {
                    count++;
                }
            }
        }
        return count == Xboard - 1;
    }

    public void show() {
        System.out.println("\n\tlines");
        for (int line = Xboard - 1; line > 0; line--) {
            System.out.print("\t" + line);
            for (int column = 0; column < Yboard - 1; column++) {
                System.out.print("\t" + board[line][column]);
            }
            System.out.println();
        }
        System.out.print("\t ");
        for (int column = 1; column < Yboard; column++) {
            System.out.print("\t" + column);
        }
        System.out.print("\t Columns");
    }

    public void showMines() {
        for (int i = 1; i < AmountMines; i++) {
            if (mines[i] == -1) {
                board[i][i] = '*';
                show();
            }
        }
    }

    public int getPosition(int Position) {
        return mines[Position];
    }

    public boolean setPosition() {
        int column;
        int line;
        do {
            System.out.print("\nLine: ");
            line = input.nextInt();
            System.out.print("\nColumn: ");
            column = input.nextInt();

            if ((board[line][column] != '_') && (line < Xboard && line > 0) && (column < Yboard && column > 0)) {
                System.out.println("Field is already shown");
            }

            if (line < 1 || line > (Xboard - 2) || column < 1 || column > (Yboard - 2)) {
                System.out.println("choose a number between 1 and " + (Xboard - 1) + " for Line");
                System.out.println("choose a number between 1 and " + (Yboard - 1) + " for Column");
            }
        } while ((line < 1 || line > Xboard || column < 1 || column > Yboard) || (board[line][column] != '_'));
        return getPosition(line) == -1;
    }

    private char[][] testBoard(int Xboard, int Yboard) {
        try {
            board = new char[Xboard][Yboard];
            return board;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<char[][]> showNeighbour(Board board) {
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
        return null;
    }
}