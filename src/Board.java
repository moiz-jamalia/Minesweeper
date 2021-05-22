import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Board{
    public static Field[][] board;
    public static int Yboard;
    public static int Xboard;
    public static int AmountMines;
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


    public void uncover(){
        System.out.print("\nUndo (Yes or No): ");
        Scanner input = new Scanner(System.in);
        String Undo = input.next();
        int x;
        int y;

        
        if (Undo.equals("No")){
            System.out.print("Line: ");
            input = new Scanner(System.in);
            x = input.nextInt() - 1;

            System.out.print("Column: ");
            input = new Scanner(System.in);
            String Column = input.next();
            char c = Column.charAt(0);
            y = (int) c - 65;

            f = getField(x,y);
            f.setIsShown(true);
            showNeighbours(f);
            showFieldsymbol(f);
            saveBoard.setSavedboard(f);
            history.save(saveBoard.saveBoard());
        }else{
            saveBoard.restore(history.undo());
            Field g = saveBoard.getSavedboard();
            f.setFieldsymbol("_");
            f.setIsShown(false);
            Field h = getField(g.getX(),g.getY());
            h.setIsShown(true);
            showNeighbours(h);
            showFieldsymbol(h);
        }
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

    public void showNeighbours(Field field){
        ArrayList<Field> neighbours = getNeighbours(field);

        for (Field f : neighbours){
            f.setIsShown(true);
        }
    }

    //still working on that!!! I got this!!!!!
    public void showFieldsymbol(Field field){
        int countBombs = 0;
        int countNNBomb = 0;

        ArrayList<Field> neighbours = getNeighbours(field);
        ArrayList<Field> n;



        for (Field f : neighbours) {
            n = getNeighbours(f);
            if (f.getIsBomb()){
                countBombs++;
                f.setFieldsymbol("*"); // muss "_" gemacht werden später
            }
        }
        field.setFieldsymbol(String.valueOf(countBombs));
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
        return count == AmountMines;
    }
}