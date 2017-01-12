public abstract class Player {

    protected int tokens;
    protected String name;
    protected char token_name;
    protected int _lastRow;
    protected int _lastColumn;

    abstract void drop_token(int column,Woo w);

    abstract boolean is_win(Woo w);

    abstract String getLastRowString(Woo w);

    abstract String getLastColumnString(Woo w);

    abstract String getLastRightDiagonalString(Woo w); //diagonals move in 2 different directions

    abstract String getLastLeftDiagonalString(Woo w);
}
