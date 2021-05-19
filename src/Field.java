public class Field {
    public static int X;
    public static int Y;
    public boolean isBomb = false;
    public static char fieldsymbol = '_';

    public static void SetX(int X){
        Field.X = X;
    }

    public static int getX(){
        return X;
    }

    public static void setY(int Y){
        Field.Y = Y;
    }

    public static int getY(){
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
