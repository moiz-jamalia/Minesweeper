public class Game {
    public Board board = new Board();
    boolean finish = false;
    int turn = 0;

    public void Minesweeper(){
        Play(board);
    }

    public void Play(Board board){
        do{
            turn++;
            System.out.println("\nTurn "+turn);
            BoardFunction.show();

            if(!finish){
                BoardFunction.showNeighbour(board);
            }

        }while(!finish);

        if(BoardFunction.win()){
            System.out.println("Congratulations, you let the "+ Board.Xboard +"x" + Board.Yboard + " fields with the mines in " + turn + " turns");
        } else {
            System.out.println("Mine! You lost!");
        }
    }
}
