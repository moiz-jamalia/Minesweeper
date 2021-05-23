import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Board{
    public static Field[][] board;
    public static int Yboard;
    public static int Xboard;
    public static int AmountBombs;
    public static int BombPosition;
    public Field f;
    Random r = new Random();
    Difficulties d = new Difficulties();
    SaveBoard saveBoard = new SaveBoard();
    LayoutHistory history = new LayoutHistory();

    public Board() {
        System.out.print("choose your difficulty (easy, medium or hard): ");
        Scanner input = new Scanner(System.in);
        String difficulties = input.next();

        switch (difficulties) {
            case "easy":
                d.easy();
                Xboard = d.Xboard;
                Yboard = d.Yboard;
                AmountBombs = d.AmountBombs;
                break;

            case "medium":
                d.medium();
                Xboard = d.Xboard;
                Yboard = d.Yboard;
                AmountBombs = d.AmountBombs;
                break;

            case "hard":
                d.hard();
                Xboard = d.Xboard;
                Yboard = d.Yboard;
                AmountBombs = d.AmountBombs;
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
        for(int i = 0; i < AmountBombs; i++){
            do {
                Line = r.nextInt(Xboard);
                Column = r.nextInt(Yboard);
            }while (board[Line][Column].getIsBomb());
            board[Line][Column].setIsBomb();
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

    public void undo(){
        System.out.print("\nUndo (Yes or No): ");
        Scanner input = new Scanner(System.in);
        String Undo = input.next();

        if (Undo.equals("No")){
            uncover();
        }else {
            saveBoard.restore(history.undo());
            board = saveBoard.getSavedboard();
            f.setIsShown(false);
            f.setFieldsymbol("_");
        }
    }

    public void uncover(){
        System.out.print("Line: ");
        Scanner input = new Scanner(System.in);
        int x = input.nextInt() - 1;

        System.out.print("Column: ");
        input = new Scanner(System.in);
        String Column = input.next();
        char c = Column.charAt(0);
        int y = (int) c - 65;

        f = getField(x,y);
        showFieldsymbol(f);
        ArrayList<Field> neighbours = getNeighbours(f);
        for (Field neighbour : neighbours) {
            showFieldsymbol(neighbour);
            if (neighbour.getIsBomb()) {
                neighbour.setFieldsymbol("_");
            }
        }
        winlose(f);

        saveBoard.setSavedboard(board);
        history.save(saveBoard.saveBoard());
    }

    public boolean returnBombPosition(){
        return BombPosition == -1;
    }

    public Field testBoard(int x, int y) {
        try {
            return getField(x,y);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Field> getNeighbours(Field f) {
        int x = f.getX();
        int y = f.getY();

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

    public void winlose(Field f) {
        if (f.getIsBomb()) {
            BombPosition = -1;
            f.setIsShown(true);
            for (int i = 0; i < Xboard; i++) {
                for (int j = 0; j < Yboard; j++) {
                    if (board[i][j].getIsBomb()) {
                        board[i][j].setFieldsymbol("*");
                    }
                }
            }
        }
    }

    public void showFieldsymbol(Field field){
        int countBombs = 0;
        field.setIsShown(true);
        if (neighbourBombs(field) == 0){
            ArrayList<Field> n = getNeighbours(field);
            for (Field f : n){
                if (f.getIsBomb()) {
                    countBombs++;
                    f.setFieldsymbol("_");
                }
            }
            field.setFieldsymbol(String.valueOf(countBombs));
        }
    }

    public int neighbourBombs(Field field){
        int countBombs = 0;
        ArrayList<Field> n = getNeighbours(field);

        for (Field f : n) {
            if (f.getIsBomb() && f.getIsShown()){
                countBombs++;
            }
            field.setFieldsymbol(String.valueOf(countBombs));
        }
        return countBombs;
    }

    public boolean checkWin() {
        int count = 0;
        for (int i = 0; i < Xboard; i++){
            for (int j = 0; j < Yboard; j++){
              if (getField(i,j).getFieldsymbol().equals("_")){
                    count++;
                }
            }
        }
        return count == AmountBombs;
    }
}