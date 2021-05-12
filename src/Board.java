import java.util.Random;
import java.util.Scanner;

public class Board {
    public int[][] minen;
    public char[][] board;
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
                minen = Difficulties.getMinen();
                board = Difficulties.getBoard();
            }
            case "medium" -> {
                Difficulties.medium();
                minen = Difficulties.getMinen();
                board = Difficulties.getBoard();
            }
            case "hard" -> {
                Difficulties.hard();
                minen = Difficulties.getMinen();
                board = Difficulties.getBoard();
            }
        }
        randomMines();
    }

    public void randomMines(){
        boolean draw;
        int line;
        int column;
        for (int i = 0; i < minen.length; i++) {
            do {
                line = random.nextInt(board.length) + 1;
                column = random.nextInt(board.length) + 1;

                draw = minen[line][column] == -1;
            }while (draw);
            minen[line][column] = -1;
        }
    }
}
