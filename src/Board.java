import java.util.Random;
import java.util.Scanner;

public class Board {
    public int[][] minen;
    public int[][] minen1;
    public char[][] board;
    public char[][] board1;
    public int Line;
    public int Column;
    public String difficulties;
    Random random = new Random();
    Scanner input = new Scanner(System.in);

    public Board(){
        System.out.println("choose your difficulties: ");
        difficulties = input.next();

        switch (difficulties) {
            case "easy" -> {
                Difficulties.easy();
                minen1 = Difficulties.getMinen();
                board1 = Difficulties.getBoard();
            }
            case "medium" -> {
                Difficulties.medium();
                minen1 = Difficulties.getMinen();
                board1 = Difficulties.getBoard();
            }
            case "hard" -> {
                Difficulties.hard();
                minen1 = Difficulties.getMinen();
                board1 = Difficulties.getBoard();
            }
        }
        minen = minen1;
        board = board1;
        PlaceMines();
        randomMines();
        fillTips();
        startBoard();
    }

    public void randomMines(){
        boolean draw;
        int line;
        int column;
        for (int i = 0; i < board.length; i++) {
            do {
                line = random.nextInt(board.length) + 1;
                column = random.nextInt(board[0].length) + 1;

                draw = minen[line][column] == -1;
            }while (draw);
            minen[line][column] = -1;
        }
    }

    public void PlaceMines(){
        for (int i = 0; i < minen.length; i++){
            for (int j = 0; j < minen.length; j++){
                minen[i][j] = 0;
            }
        }
    }

    public void fillTips(){
        for(int line=1 ; line < board.length - 1 ; line++)
            for(int column=1 ; column < board[0].length - 1 ; column++){

                for(int i=-1 ; i<=1 ; i++)
                    for(int j=-1 ; j<=1 ; j++)
                        if(minen[line][column] != -1)
                            if(minen[line+i][column+j] == -1)
                                minen[line][column]++;

            }

    }

    public void startBoard(){
        for(int i=1 ; i<minen.length ; i++)
            for(int j=1 ; j<minen.length ; j++)
                board[i][j]= '_';
    }

    public boolean win(){
        int count = 0;
        for (int line = 1; line < board.length - 1; line++){
            for (int column = 1; column < board[0].length - 1; column++){
                if (board[line][column] == '_'){
                    count++;
                }
            }
        }
        if (count == board.length){
            return true;
        }else{
            return false;
        }
    }
    public void show(){
        System.out.println("\n      lines");
        for (int line = board.length - 2; line > 0; line--){
            System.out.println("    " + line + " ");
            for (int column = 1; column < board[0].length - 1; column++){
                System.out.println("    " + board[line][column]);
            }
        }
    }

    public void showMines(){
        for(int i=1 ; i < 9; i++)
            for(int j=1 ; j < 9 ; j++)
                if(minen[i][j] == -1)
                    board[i][j]='*';

        show();
    }

    public void showNeighbors(){
        for (int i = 1; i < 2; i++){
            for (int j = 1; j < 2; j++){
                if ((minen[Line +i][Column +j] != 1) && (Line != 0 && Line != (board.length - 1) && Column != 0 && Column != (board[0].length - 1))){
                    board[Line+i][Column+j] = Character.forDigit(minen[Line+i][Column+j], board.length);
                }
            }
        }
    }
}
