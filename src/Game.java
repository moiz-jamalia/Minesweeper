public class Game {
    boolean finish = false;
    int turn = 0;

    public void Minesweeper(){
        Play();
    }

    public void Play(){
        Board board = new Board();

            do {
                board.printboard();
                board.uncover();
                finish = board.returnBombPosition();

            } while (!finish);

            if (board.checkWin()){
                System.out.println("Congrats, you won");

            }else{
                System.out.println("you lost! lame");
            }
    }
}