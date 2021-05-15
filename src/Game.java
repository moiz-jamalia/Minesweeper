public class Game {
    public Board board;
    boolean finish = false;
    int turn = 0;

    public void Minesweeper(){
        board = new Board();
        Play(board);

    }

    public void Play(Board board){
        do{
            turn++;
            System.out.println("Turn "+turn);
            board.show();
            finish = board.setPosition();

            if(!finish){
                board.showNeighbors();
                finish = board.win();
            }

        }while(!finish);

        if(board.win()){
            System.out.println("Congratulations, you let the "+ Board.Xboard +"x" + Board.Yboard + " fields with the mines in " + turn + " turns");
            board.showMines();
        } else {
            System.out.println("Mine! You lost!");
            board.showMines();
        }
    }
}
