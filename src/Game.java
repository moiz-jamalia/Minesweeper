public class Game {
    private Board board;
    boolean finish = false;
    boolean win = true;
    int turn = 0;

    public void Jogo(){
        board = new Board();
        Play(board);

    }

    public void Play(Board board){
        board.startBoard();
        board.show();
        board.showMines();
        board.showNeighbors();
    }
}
