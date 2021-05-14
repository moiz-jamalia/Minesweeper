public class Game {
    private Board board;
    boolean finish = false;
    boolean win = false;
    int turn = 0;

    public int Xboard = Board.Xboard;
    public int Yboard = Board.Yboard;

    public void Jogo(){
        board = new Board();
        Play(board);
        System.out.println("hello");
        System.out.println(Yboard);
    }

    public void Play(Board board){
        board.show();
    }
}
