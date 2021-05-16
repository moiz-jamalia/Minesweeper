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
    public Board(){
        System.out.println("choose your difficulty: ");
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
//        fillTips();
        startBoard();
    }

    public void randomMines(){
        boolean draw;
        int position;
        for (int i = 0; i < AmountMines; i++) {
            do {
                position = random.nextInt(AmountMines);
                draw = mines[position] == -1;
            }while (draw);
            mines[position] = -1;
        }
    }

    public void PlaceMines(){
        for (int i = 0; i < AmountMines; i++) {
            mines[i] = 0;
        }
    }

//    public void fillTips(){
//        for(int line = 1 ; line < Xboard - 1 ; line++) {
//            for (int column = 1; column < Yboard - 1; column++) {
//                for (int i = -1; i <= 1; i++) {
//                    for (int j = -1; j <= 1; j++) {
//                        if (mines[line][column] != -1) {
//                            if (mines[line + i][column + j] == -1) {
//                                mines[line][column]++;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }

    public void startBoard(){
        for(int i = 1 ; i < Xboard; i++) {
            for (int j = 1; j < Yboard; j++) {
                board[i][j] = '_';
            }
        }
    }

    public boolean win(){
        int count = 0;
        for (int line = 1; line < Xboard - 1; line++){
            for (int column = 1; column < Yboard - 1; column++){
                if (board[line][column] == '_'){
                    count++;
                }
            }
        }
        return count == Xboard - 1;
    }

    public void show(){
        System.out.println("\n\tlines");
        for (int line = Xboard - 1; line > 0; line--){
            System.out.print("\t" + line);
            for (int column = 0; column < Yboard - 1; column++){
                System.out.print("\t" + board[line][column]);
            }
            System.out.println();
        }
        System.out.print("\t\t ");
        for (int column = 1; column < Yboard; column++){
            System.out.print("\t" + column);
        }
        System.out.print("\t Columns");
    }
    public void showMines(){
        for(int i = 1; i < AmountMines; i++) {
            if(mines[i] == -1) {
                board[i][i]='*';
                show();
            }
        }
    }

    public int getPosition(int Position){
        return mines[Position];
    }

    public boolean setPosition(){
        int column;
        int line;
        do {
            System.out.print("\nLine: ");
            line = input.nextInt();
            System.out.print("\nColumn: ");
            column = input.nextInt();

            if ((board[line][column] != '_') && (line < Xboard && line > 0) && (column < Yboard && column > 0)){
                System.out.println("Field is already shown");
            }

            if (line < 1 || line > (Xboard - 2) || column < 1 || column > (Yboard - 2)){
                System.out.println("choose a number between 1 and " + (Xboard - 1) + " for Line");
                System.out.println("choose a number between 1 and " + (Yboard - 1)+ " for Column");
            }
        }while ((line < 1 || line > Xboard || column < 1 || column > Yboard) || (board[line][column] != '_'));
        return getPosition(line) == -1;
    }

    private char[][] testBoard(int Xboard, int Yboard){
        try {
            board = new char[Xboard][Yboard];
            return board;
        }catch (Exception e){
            return null;
        }
    }

    public ArrayList<char[][]> showNeighbour(Board board) {
       int y = Difficulties.getYBoard();
       int x = Difficulties.getXBoard();

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

//    public void showNeighbors(){
//        for (int i = 1; i < 2; i++){
//            for (int j = 1; j < 2; j++){
//                if ((mines[Line + i][Column + j] != 1) && (Line != 0 && Line != 9 && Column != 0 && Column != 9)){
//                    board[Line + i][Column + j] = Character.forDigit(mines[Line + i][Column + j], AmountMines);
//                }
//            }
//        }
//    }
}