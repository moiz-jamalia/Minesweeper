import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Board{
    public static Field[][] board;
    public static int Yboard;
    public static int Xboard;
    public static int AmountMines;
    public static int BombPosition;
    Random r = new Random();
    Difficulties d = new Difficulties();

    public Board() {
        System.out.print("choose your difficulty (easy, medium or hard): ");
        Scanner input = new Scanner(System.in);
        String difficulties = input.next();

        switch (difficulties) {
            case "easy":
                d.easy();
                Xboard = d.Xboard;
                Yboard = d.Yboard;
                AmountMines = d.AmountMines;
                break;

            case "medium":
                d.medium();
                Xboard = d.Xboard;
                Yboard = d.Yboard;
                AmountMines = d.AmountMines;
                break;

            case "hard":
                d.hard();
                Xboard = d.Xboard;
                Yboard = d.Yboard;
                AmountMines = d.AmountMines;
                break;
        }
        board = new Field[Xboard][Yboard];
        startBoard();
        setRandomMines();
    }

    public void startBoard() {
        for (int i = 0; i < Xboard; i++) {
            for (int j = 0; j < Yboard; j++) {
                board[i][j] = new Field(i,j);
            }
        }
    }

    public void setRandomMines(){
        int Line;
        int Column;
        for(int i = 0; i < AmountMines; i++){
            do {
                Line = r.nextInt(Xboard);
                Column = r.nextInt(Yboard);
            }while (board[Line][Column].getIsBomb());
            board[Line][Column].setIsBomb(true);
        }
    }

    public void printboard(){
        char c = 65;
        for (int i = 1; i <= Xboard; i++){
            System.out.print("\t" +i);
        }
        System.out.println();
        for (int i = 0; i < Yboard; i++){
            System.out.print(c);
            for (int j = 0; j < Xboard; j++) {
                    System.out.print("\t" + getField(j,i).getFieldsymbol());
            }
            System.out.println();
            c++;
        }
    }

    private Field getField(int x, int y){
        return board[x][y];
    }


    public void uncover(){
        int x;
        int y;
        do {
            System.out.print("\nLine: ");
            Scanner input = new Scanner(System.in);
            x = input.nextInt() - 1;

            System.out.print("Column: ");
            input = new Scanner(System.in);
            String Column = input.next();
            char c = Column.charAt(0);
            y = (int) c - 65;

            System.out.println(x);
            System.out.println(y);

            if (((x < Xboard && x > 0) && (y < Yboard && y > 0)) && !getField(x, y).getFieldsymbol().equals("_")) {
                System.out.println("Field is shown");
            }

        }while ((x < 1 || x > Xboard || y < 1 || y > Yboard) && getField(x,y).getFieldsymbol().equals("_"));

        BombPosition = getField(x, y).getIsBomb() ? 1 : -1;
    }

    public boolean returnBombPosition(){
        return BombPosition == -1;
    }

    public Field testBoard(int x, int y) {
        try {
            return new Field(x,y);
        } catch (Exception e) {
            return null;
        }
    }


    public ArrayList<Field> getNeighbours(Field f) {
        int y = f.getY();
        int x =f.getX();

        ArrayList<Field> neighbours = new ArrayList<>();
        neighbours.add(testBoard(x, y + 1));
        neighbours.add(testBoard(x, y - 1));
        neighbours.add(testBoard(x - 1, y));
        neighbours.add(testBoard(x - 1, y + 1));
        neighbours.add(testBoard(x - 1, y - 1));
        neighbours.add(testBoard(x + 1, y));
        neighbours.add(testBoard(x + 1, y + 1));
        neighbours.add(testBoard(x + 1, y - 1));
        return neighbours;
    }

    public void showNeighbours(Field field){
        ArrayList<Field> neighbours = getNeighbours(field);

        for (Field f : neighbours){
            f.setIsShown(true);
        }
    }

    public boolean checkWin(){
       return true;
    }
}