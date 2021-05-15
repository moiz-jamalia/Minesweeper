import java.util.Random;
import java.util.Scanner;

public class Board {
    public int[][] mines;
    public char[][] board;
    public int Line;
    public int Column;
    public static int Yboard;
    public static int Xboard;
    public static int YMines;
    public static int XMines;
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
                 XMines = Difficulties.getXMines();
                 YMines = Difficulties.getYMines();
                 break;

            case "medium":
                Difficulties.medium();
                Xboard = Difficulties.getXBoard();
                Yboard = Difficulties.getYBoard();
                XMines = Difficulties.getXMines();
                YMines = Difficulties.getYMines();
                break;

            case "hard":
                Difficulties.hard();
                Xboard = Difficulties.getXBoard();
                Yboard = Difficulties.getYBoard();
                XMines = Difficulties.getXMines();
                YMines = Difficulties.getYMines();
                break;
        }
        mines = new int[XMines][YMines];
        board = new char[Xboard][Yboard];
        PlaceMines();
        randomMines();
        fillTips();
        startBoard();
    }

    public void randomMines(){
        boolean draw;
        int line;
        int column;
        for (int i = 0; i < XMines; i++) {
            do {
                line = random.nextInt(XMines);
                column = random.nextInt(YMines);

                draw = mines[line][column] == -1;
            }while (draw);
            mines[line][column] = -1;
        }
    }

    public void PlaceMines(){
        for (int i = 0; i < XMines; i++){
            for (int j = 0; j < XMines; j++){
                mines[i][j] = 0;
            }
        }
    }

    public void fillTips(){
        for(int line=1 ; line < Xboard - 1 ; line++) {
            for (int column = 1; column < Yboard - 1; column++) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (mines[line][column] != -1) {
                            if (mines[line + i][column + j] == -1) {
                                mines[line][column]++;
                            }
                        }
                    }
                }
            }
        }
    }

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
        System.out.println("\n  lines");
        for (int line = Xboard - 1; line > 0; line--){
            System.out.print("\t" + line);
            for (int column = 0; column < Yboard; column++){
                System.out.print("\t" + board[line][column]);
            }
            System.out.println("");
        }
        System.out.print("\t\t ");
        for (int column = 1; column < Yboard; column++){
            System.out.print("\t" + column);
        }
        System.out.print("\t Columns");
    }

    public void showMines(){
        for(int i=1 ; i < (XMines - 1); i++) {
            for(int j=1 ; j < (YMines - 1); j++) {
                if(mines[i][j] == -1) {
                    board[i][j]='*';
                	show();
                }
            }
        }
    }

    public void showNeighbors(){
        for (int i = 1; i < 2; i++){
            for (int j = 1; j < 2; j++){
                if ((mines[XMines + i][YMines + j] != 1) && (XMines != 0 && XMines != 9 && Xboard != 0 && Yboard != 9)){
                    board[Xboard + i][Yboard + j] = Character.forDigit(mines[XMines + i][YMines + j], Xboard);
                }
            }
        }
    }

    public int getPosition(int XBoard, int YBoard){
        return mines[XBoard][YBoard];
    }

    public boolean setPosition(){
        do {
            System.out.print("\nLine: ");
            Line = input.nextInt();
            System.out.print("\nColumn: ");
            Column = input.nextInt();

            if ((board[Line][Column] != '_') && (Line < Xboard - 1 && Line > 0) && (Column < Yboard - 1 && Column > 0)){
                System.out.println("Field is already shown");

            }else if (Line < 1 || Line > Xboard - 2 || Column < 1 || Column > Yboard - 2){
                System.out.println("choose a number between 1 and " + Xboard + "for Line");
                System.out.println("choose a number between 1 and " + Yboard + "for Column");
            }
        }while ((Line < 1 || Line > Xboard || Column < 1 || Column > Yboard) || (board[Line][Column] != '_'));
        return getPosition(Line, Column) == -1;
    }
}