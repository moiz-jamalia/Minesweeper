import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Board {
    public static int[] mines;
    public static char[][] board;
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
        startBoard();
        randomMines();
        showMines();
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
                board[i][j] = '_';
            }
        }
    }

    public void randomMines(){
        int Line;
        int Column;
            for (int i = 0; i < AmountMines; i++) {
                Line = random.nextInt(Xboard);
                Column = random.nextInt(Yboard);
            }

    }

    public static void showMines(){
        for (int i = 1; i < AmountMines; i++){
            for (int j = 1; j < AmountMines; j++){
                if (mines[i] == -1){
                    board[i][j] = '*';
                }
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

    public boolean setPosition(){
        int Line;
        int Column;
            System.out.println("Line: ");
            Line = input.nextInt();
            System.out.println("Column: ");
            Column = input.nextInt();


        return false;
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
        return b.stream().filter(Objects::nonNull).collect(Collectors.toCollection(ArrayList::new));
    }
}