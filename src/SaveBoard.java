public class SaveBoard {
    private Board savedboard;

    public SaveBoardState createState(){
        return new SaveBoardState(savedboard);
    }

    public void restore(SaveBoardState saveBoard){
        savedboard = saveBoard.getBoard();
    }

    public Board getSavedboard(){
        return savedboard;
    }
}