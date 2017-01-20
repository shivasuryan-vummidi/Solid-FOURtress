public abstract class Player {

    protected int tokens;
    protected String name;
    protected char token_name;
    protected int _lastRow;
    protected int _lastColumn;

    public void drop_token(int column,Woo w){
	w.drop(column, this);
	tokens -= 1;
    }

    public boolean is_win(Woo w){
	String win = "";
	for (int x = 0; x < 4;x++) {
	    win += token_name;
	}
	System.out.println("DIAGNOSTIC");
	System.out.println("Last Row: " + getLastRowString(w));
	System.out.println("Last Column: " + getLastColumnString(w));
	System.out.println("Last Right Diag: " + getLastRightDiagonalString(w));
	System.out.println("Last Left Diag: " + getLastLeftDiagonalString(w));
	return hasSubString(getLastRowString(w),win) ||
	    hasSubString(getLastColumnString(w),win) ||
	    hasSubString(getLastRightDiagonalString(w),win) ||
	    hasSubString(getLastLeftDiagonalString(w),win);
    }

    public boolean hasSubString(String str, String lookingFor) {
	return str.indexOf(lookingFor) != -1;
    }

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

    public String getLastRowString(Woo w){
	return getRowString(w, _lastRow);
    }

    public String getColumnString(Woo w, int column) {
	String s = "";
	for (int x = 0; x < w.numRows; x++){
	    s += w._board[x][column];
	}
	return s;
    }

    public String getLastColumnString(Woo w){
	return getColumnString(w, _lastColumn);
    }
    
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

    public String getLastRightDiagonalString(Woo w){
	return getRightDiagonalString(w, _lastRow, _lastColumn);
    }

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

    public String getLastLeftDiagonalString(Woo w){
	return getLeftDiagonalString(w, _lastRow, _lastColumn);
    }

    public String toString() {
	return name;
    }

    abstract int pick_column(Woo w,Player p);
}
