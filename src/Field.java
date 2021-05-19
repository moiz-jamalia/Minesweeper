import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Field {
    private int X;
    private int Y;
    public boolean isBomb = false;
    public boolean isShown = false;
    public static char fieldsymbol = '_';

    public Field(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public int getX(){
        return X;
    }

    public int getY(){
        return Y;
    }

    public void setIsShown(boolean shown){
        this.isShown = shown;
    }

    public static char getFieldsymbol(){
        return fieldsymbol;
    }

    public static void setFieldsymbol(char symbol){
        fieldsymbol = symbol;
    }

    public void setIsBomb(boolean Bomb){
        this.isBomb = Bomb;
    }

    public boolean getIsBomb(){
        return isBomb;
    }
}