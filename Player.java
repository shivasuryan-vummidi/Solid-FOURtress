public abstract class Player {

    protected int tokens;
    protected String name;
    protected char token_name;
    protected int _lastRow;
    protected int _lastColumn;

    abstract void drop_token(int column,Woo w);

    abstract boolean is_win();

    abstract String getLastRowString();

    abstract String getLastColumnString();

    abstract String getLastDiagonalString();


}
