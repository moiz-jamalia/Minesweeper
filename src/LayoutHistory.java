import java.util.ArrayList;
import java.util.List;

public class LayoutHistory {
    private List<SaveBoardState> states = new ArrayList<>();

    public void save(SaveBoardState state){
        states.add(state);
    }

    public SaveBoardState undo(){
        int lastIndex = states.size() - 1;
        SaveBoardState lastState = states.get(lastIndex);

        states.remove(lastState);

        return lastState;
    }
}