public abstract class Player {

    protected int tokens;//number of tokens that a player gets
    protected String name;//the name of the Player
    protected char token_name;//the token that the Player is going to use
    protected int _lastRow;//the last row that the Player has dropped the token inx
    protected int _lastColumn;//the last column that the Player has dropped the token in

    //Any player can drop a token in desired column
    public void drop_token(int column,Woo w){
	w.drop(column, this);
    }

    //Checks if the Player has won the game
    public boolean is_win(Woo w){
	String win = "";
	for (int x = 0; x < 4;x++) {
	    win += token_name;
	}
	return hasSubString(getLastRowString(w),win) ||
	    hasSubString(getLastColumnString(w),win) ||
	    hasSubString(getLastRightDiagonalString(w),win) ||
	    hasSubString(getLastLeftDiagonalString(w),win);
    }

    //Helper method for win check algorithm
    public boolean hasSubString(String str, String lookingFor) {
	return str.indexOf(lookingFor) != -1;
    }

    //Get the String version of all the tokens in the desired row
    public String getRowString(Woo w, int row) {
	String s = "";
	if (row > w.numRows-1) {
	    for (int x = 0; x < w.numColumns; x++) {
		s += "-";
	    }
	    return s;
	}
	else {
	    for (int x = 0; x < w.numColumns; x++){
		s += w._board[row][x];
	    }
	}
	return s;
    }

    //Get the String version of all the tokens in the last row that the Player has placed the token in
    public String getLastRowString(Woo w){
	return getRowString(w, _lastRow);
    }

    //Get the String version of all the tokens in the desired column
    public String getColumnString(Woo w, int column) {
	String s = "";
	for (int x = 0; x < w.numRows; x++){
	    s += w._board[x][column];
	}
	return s;
    }

    //Get the String version of all the tokens in the last column that the Player has placed the token in
    public String getLastColumnString(Woo w){
	return getColumnString(w, _lastColumn);
    }
    
    //Get the String version of all the tokens for the right diagonal that is associated with the desired row and column
    public String getRightDiagonalString(Woo w, int row, int column) {
	String s = "";
	int z = 0;
        for (int x = 0; x < w.numRows; x++) { //start from top right of diag
	    z = column + row - x;     //go to bottom left of diag
            if (0 <= z && z < w.numColumns) { //make sure z is still in range
		s = w._board[x][z] + s;
            }
        }
	for (int y = column + row + 1; y < w.numColumns; y++) {
	    s += "-";
	}
	for (int y = z; y > 0; y--) {
	    s = "-" + s;
	}
	return s;
    }

    //Get the String version of all the tokens for the right diagonal that is associated with the row and column of the token that was last placed by the Player
    public String getLastRightDiagonalString(Woo w){
	return getRightDiagonalString(w, _lastRow, _lastColumn);
    }

    //Get the String version of all the tokens for the left diagonal that is associated with the desired row and column
    public String getLeftDiagonalString(Woo w, int row, int column){
	String s = "";
	int z = 0;
        for (int x = 0; x < w.numRows; x++) { //start from top left of diag
            z = column - row + x;     //go to bottom right of diag
            if (0 <= z && z < w.numColumns) { //make sure z is still in range
		s += w._board[x][z];
            }
        }
	for (int y = z + 1 ;y < w.numColumns; y++) {
	    s += "-";
	}
	for (int y = column - row; y > 0; y--) {
	    s = "-" + s;
	}
	return s;
    }

    //Get the String version of all the tokens for the left diagonal that is associated with the row and column of the token that was last placed by the Player
    public String getLastLeftDiagonalString(Woo w){
	return getLeftDiagonalString(w, _lastRow, _lastColumn);
    }

    //overwritten toString method to return the name of the Player
    public String toString() {
	return name;
    }

    //the pick column algorithm will be defined by the subclasses based on their difficulties
    abstract int pick_column(Woo w,Player p);
}
