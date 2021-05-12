import java.util.Random;
import java.util.Scanner;

public class Board {
    public int[][] minen;
    public int[][] minen1;
    public char[][] board;
    public char[][] board1;
    public int line;
    public int column;
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
}
