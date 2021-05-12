import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Board {
    public int[][] minen;
    public char[][] board;
    public int Line;
    public int column;
    public String difficulties;
    Random random = new Random();
    Scanner input = new Scanner(System.in);

    public Board(){
        System.out.println("choose your difficulties: ");
        difficulties = input.next();

        if(difficulties.equals("easy")){
            Difficulties.easy();
            minen = Difficulties.getMinen();
            board = Difficulties.getBoard();

        }else if (difficulties.equals("medium")){
            Difficulties.medium();
            minen = Difficulties.getMinen();
            board = Difficulties.getBoard();
        }else if (difficulties.equals("hard")){
            Difficulties.hard();
            minen = Difficulties.getMinen();
            board = Difficulties.getBoard();
        }
    }
}
