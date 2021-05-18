public class Field {
    public char X;
    public char Y;
    public boolean isBomb = false;
    private char fieldsymbol = '_';

    public void SetX(char X){
        this.X = X;
    }

    public char GetX(){
        return X;
    }

    public void SetY(char Y){
        this.Y = Y;
    }

    public char GetY(){
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
