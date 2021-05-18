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
    // Many fragen wie es funktioniert
    public void RandomMines(){
        int Line;
        int Column;
        for(int i = 0; i < AmountMines; i++){
            Line = random.nextInt(Xboard);
            Column = random.nextInt(Yboard);
            if (board[Line][Column].GetIsBomb()) {
                Line = random.nextInt(Xboard);
                Column = random.nextInt(Yboard);
            }
            board[Line][Column].SetIsBomb(true);
        }
    }
    //Problem
    public boolean win(){
        int count = 0;
        for (int line = 1; line < Xboard - 1; line++){
            for (int column = 1; column < Yboard - 1; column++){
                if (board[line][column].GetIsBomb()){
                    count++;
                }
            }
        }
        return count == Xboard - 1;
    }

    //nochmals anschauen und korrigieren
    public void show() {
        System.out.println("\n\tlines");
        for (int line = Xboard - 1; line > 0; line--) {
            System.out.print("\t" + line);
            for (int column = 0; column < Yboard - 1; column++) {
                System.out.print("\t_");
            }
            System.out.println();
        }
        System.out.print("\t ");
        for (int column = 1; column < Yboard; column++) {
            System.out.print("\t" + column);
        }
        System.out.print("\t Columns");
    }
    //komplett neu programmieren (ab if-Schleife)
    public boolean setPosition(){
        int Line;
        int Column;
        do {
            System.out.print("\nLine: ");
            Line = input.nextInt();
            System.out.print("\nColumn: ");
            Column = input.nextInt();

            if (((Line >= Xboard || Line <= 0) || (Column >= Yboard || Column <= 0))) {
                System.out.println("Field is already shown");
                show();
            }
            if (Line < 1 || Line > (Xboard - 2) || Column < 1 || Column > (Yboard - 2)) {
                System.out.println("choose a number between 1 and " + (Xboard - 1) + " for Line");
                System.out.println("choose a number between 1 and " + (Yboard - 1) + " for Column");
            }
        }while (!(Line >= 1 && Line <= Xboard && Column >= 1 && Column <= Yboard) || (board[Line][Column].GetIsBomb()));

        return board[Line][Column].GetIsBomb();
    }

    public Field[][] testBoard(int Xboard, int Yboard) {
        try {
            board = new Field[Xboard][Yboard];
            return board;
        } catch (Exception e) {
            return null;
        }
    }

    //Schauen wie man es anwendet
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