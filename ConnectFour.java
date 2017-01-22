public interface ConnectFour {
    
    //Creates board with rows # of rows and columns # of columns
    void create_board(int rows, int columns);

    //calls is_win on the first input & checks for a draw    
    String check_winner(Player p1, Player p2);

    //checks if the top slot is empty or not
    boolean is_column_full(int column);

    //helper method to set a slot on the board
    void set(int row, int column, char x);

    //checks for the lowest empty spot to drop a token    
    void drop(int column, Player p);

    //string representation of the board
    String printBoard();

    //starts a newgame    
    void newGame();
	
}
