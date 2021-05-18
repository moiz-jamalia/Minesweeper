public class Field {
    public static int X;
    public static int Y;
    public boolean isBomb = false;
    private final char fieldsymbol = '_';

    public static void SetX(char X){
        Field.X = X;
    }

    public static int GetX(){
        return X;
    }

    public static void SetY(char Y){
        Field.Y = Y;
    }

    public static int GetY(){
        return Y;
    }

    public void SetIsBomb(boolean Bomb){
        this.isBomb = Bomb;
    }

    public boolean GetIsBomb(){
        return isBomb;
    }

    public char GetFieldSymbol(){
        return fieldsymbol;
    }
}
