public class Game {
    private Board board;
    boolean finish = false;
    boolean win = false;
    int turn = 0;

    public void Jogo(){
        board = new Board();
        Play(board);
    }

    public void Play(Board board){
        board.show();
    }
}
