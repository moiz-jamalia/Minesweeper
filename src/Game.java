public class Game {
    boolean finish = false;

    public void Minesweeper(){
        Play();
    }

    public void Play(){
        Board board = new Board();

            do {
                board.printboard();
                board.undo();
                finish = board.returnBombPosition();

            } while (!finish);

            if (board.checkWin()){
                System.out.println("Congrats, you won");

            }else{
                System.out.println("you lost! lame");
            }
            board.printboard();
            board.undo();
    }
}