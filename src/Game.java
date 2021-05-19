public class Game {
    public Board board = new Board();
    boolean finish = false;
    int turn = 0;

    public void Minesweeper(){
        Play(board);
    }

    public void Play(Board board){
        do {
            turn++;
            System.out.println("\nturn: "+turn);
            board.show();
            finish = board.setPosition();
            board.showNeighbour(board);

            if (!finish){
               finish = board.win();
            }

        }while (!finish);

        if(board.win()){
            System.out.println("Congratulations, you let the "+ Board.Xboard +"x" + Board.Yboard + " fields with the mines in " + turn + " turns");
        } else {
            System.out.println("Mine! You lost!");
        }
    }
}
