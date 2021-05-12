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
        do {
            turn++;
            System.out.println("Turn: " +turn);

            if (!finish){

                finish = board.win();
            }

        }while (!finish);

        if (board.win()){
            System.out.println("Congrats, you let the" + board.board.length + "x" + board.board[0].length + "with the mines in" + turn + "turns");
            board.showMines();
        }else{
            System.out.println("you're looser try again next time");
        }
        board.showMines();


    }
}
