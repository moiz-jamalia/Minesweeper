import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Field {
    private int X;
    private int Y;
    public boolean isBomb = false;
    public static char fieldsymbol = '_';

    public Field(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public void SetX(int X){
        this.X = X;
    }

    public int getX(){
        return X;
    }

    public void setY(int Y){
        this.Y = Y;
    }

    public int getY(){
        return Y;
    }

    public static char getFieldsymbol(){
        return fieldsymbol;
    }

    public void setIsBomb(boolean Bomb){
        this.isBomb = Bomb;
    }

    public boolean getIsBomb(){
        return isBomb;
    }
}
