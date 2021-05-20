import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Board {
    public static int[] mines;
    public static Field[][] board;
    public static Field field;
    public static int Yboard;
    public static int Xboard;
    public static int AmountMines;
    public String difficulties;
    public static int MinePosition;
    Random random = new Random();
    Scanner input = new Scanner(System.in);

    public Board() {
        System.out.print("choose your difficulty (easy, medium or hard): ");
        difficulties = input.next();

        switch (difficulties) {
            case "easy":
                Difficulties.easy();
                Xboard = Difficulties.Xboard;
                Yboard = Difficulties.Yboard;
                AmountMines = Difficulties.getAmountMines();
                break;

            case "medium":
                Difficulties.medium();
                Xboard = Difficulties.Xboard;
                Yboard = Difficulties.Yboard;
                AmountMines = Difficulties.getAmountMines();
                break;

            case "hard":
                Difficulties.hard();
                Xboard = Difficulties.Xboard;
                Yboard = Difficulties.Yboard;
                AmountMines = Difficulties.getAmountMines();
                break;
        }
        mines = new int[AmountMines];
        board = new Field[Xboard][Yboard];
        field = new Field(Xboard, Yboard);
        startBoard();
        RandomMines();
        showNeighbours(field);
    }

    public void startBoard() {
        for (int i = 0; i < Xboard; i++) {
            for (int j = 0; j < Yboard; j++) {
                board[i][j] = new Field(i,j);
            }
        }
    }

    public void RandomMines(){
        int Line;
        int Column;
        for(int i = 0; i < AmountMines; i++){
            do {
                Line = random.nextInt(Xboard);
                Column = random.nextInt(Yboard);
            }while (board[Line][Column].getIsBomb());
            board[Line][Column].setIsBomb(true);
            field = new Field(Line, Column);
            field.setIsBomb(true);
        }
    }
    //Problem
    public boolean win(){
        int count = 0;
        for (int line = 1; line < Xboard; line++){
            for (int column = 1; column < Yboard; column++){
                if (Field.getFieldsymbol() == '_') {
                    count++;
                }
            }
        }
        return count == AmountMines;
    }

    public void show() {
        int x = Xboard;
        int y = Yboard;
        Field f = new Field(x,y);
        f.setIsShown(true);
        System.out.println("\n\tlines");
        for (int line = Xboard - 1; line > 0; line--) {
            System.out.print("\t" + line);
            for (int column = 0; column < Yboard - 1; column++) {
                setNeighbourFieldsymbol(f);
                System.out.print("\t" +Field.fieldsymbol);
            }
            System.out.println();
        }
        System.out.print("\t ");
        for (int column = 1; column < Yboard; column++) {
            System.out.print("\t" + column);
        }
        System.out.print("\t Columns");
    }

    public static int getMine(int x, int y){
        boolean b = board[x][y].getIsBomb();
        if (b) {
            return -1;
        } else {
            return 1;
        }
    }

    public void setPosition(){
        int Line;
        int Column;

        do {
            System.out.print("\nLine: ");
            Line = input.nextInt();
            System.out.print("Column: ");
            Column = input.nextInt();


            if ((Field.fieldsymbol != '_') && ((Line < 9 && Line > 0) && (Column < 9 && Column > 0))){
                System.out.println("Field is already shown");
            }

            if (Line < 1 || Line >= Xboard || Column < 1 || Column >= Yboard){
                System.out.println("Choose a number between 1 and " + (Xboard - 1) + " for Line");
                System.out.println("Choose a number between 1 and " + (Yboard - 1) + " for Column");
            }

        }while ((Line < 1 || Line >= Xboard || Column < 1 || Column >= Yboard) || (Field.fieldsymbol != '_'));

        MinePosition = getMine(Line,Column);
    }

    public static boolean MinePosition(){
        return MinePosition == -1;
    }

    public static Field testBoard(int x, int y) {
        try {
            return new Field(x,y);
        } catch (Exception e) {
            return null;
        }
    }

    // working on that
    public void setNeighbourFieldsymbol(Field f){
        ArrayList<Field> neighbours = getNeighbours(f);
        showNeighbours(f);

        for (Field neighbour : neighbours) {
            f = neighbour;
            showNeighbours(f);
            if (f.isBomb && f.isShown) {
                Field.setFieldsymbol('1');
            } else {
                Field.setFieldsymbol('_');
            }
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
}