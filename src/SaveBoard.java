public class SaveBoard {
    private Field savedboard;

    public void setSavedboard(Field field){
        this.savedboard = field;
    }

    public Field getSavedboard(){
        return savedboard;
    }

    public SaveBoardState saveBoard(){
        return new SaveBoardState(savedboard);
    }

    public void restore(SaveBoardState saveBoard){
        savedboard = saveBoard.getBoard();
    }
}