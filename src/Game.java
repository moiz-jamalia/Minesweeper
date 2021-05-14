public class Game {
    private Board board;
    boolean finish = false;
    boolean win = true;
    int turn = 0;

    public int Xboard = Board.Xboard;
    public int Yboard = Board.Yboard;

    public void Jogo(){
        board = new Board();
        Play(board);
        System.out.println("\nY-Achse: " +Yboard);
        System.out.println("X-Achse: " +Xboard);
    }

    public void Play(Board board){
        do{
            turn++;
            System.out.println("Turn "+turn);
            board.show();


            if(!finish){
                board.showNeighbors();
                finish = board.win();
            }

        }while(!finish);

        if(board.win()){
            System.out.println("Congratulations, you let the 10 fields with the mines in "+turn+" turns");
            board.showMines();
        } else {
            System.out.println("Mine! You lost!");
            board.showMines();
        }
    }
}
