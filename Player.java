public abstract class Player {

    protected int tokens;
    protected String name;
    protected char token_name;

    abstract void drop_token(int column,Woo w);

    abstract void is_win();

}
