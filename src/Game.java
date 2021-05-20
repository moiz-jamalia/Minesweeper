public class Game {
    boolean finish = false;
    int turn = 0;

    public void Minesweeper(){
        Play();
    }

    public void Play(){
        Board board = new Board();


            board.printboard();
            do {
                board.uncover();
            } while (!finish);
    }
}