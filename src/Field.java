public class Field {
    private int x;
    private int y;
    private int amountNeighbourBomb;
    private boolean isBomb = false;
    private boolean isShown = false;
    private String fieldsymbol = "_";

    public Field(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setIsShown(boolean shown){
        isShown = shown;
    }

    public boolean getIsShown(){
        return isShown;
    }

    public void setFieldsymbol(String symbol){
        fieldsymbol = symbol;
    }

    public String getFieldsymbol(){
        return fieldsymbol;
    }

    public void setIsBomb(){
        this.isBomb = true;
        //this.fieldsymbol = "*";
    }

    public boolean getIsBomb(){
        return isBomb;
    }

    public void setAmountNeighbourBomb(int bomb){
        amountNeighbourBomb = bomb;
    }

    public int getAmountNeighbourBomb(){
        return amountNeighbourBomb;
    }
}