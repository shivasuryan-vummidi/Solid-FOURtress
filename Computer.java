public class Computer extends Player {

    public Computer(){
	tokens = 32;
	name = "Computer";
	token_name = 'C';
    }

    public void drop_token(int column, Woo w){
	if (w.is_column_full(column)){
	    System.out.println("ERROR: Please try again. Column " + column + " is full.");
	}
	else {
	    w.drop(column, this);
	}
    }

    public boolean is_win(Woo w){
	String win = "CCCC";
	return hasSubString(getLastRowString(w),win) ||
	    hasSubString(getLastColumnString(w),win) ||
	    hasSubString(getLastRightDiagonalString(w),win) ||
	    hasSubString(getLastLeftDiagonalString(w),win);
    }
    public boolean hasSubString(String str, String lookingFor) {
	return str.indexOf(lookingFor) != -1;
    }
    public String getLastRowString(Woo w){
	String s = "";
	for (int x = 0; x < 8; x++){
	    s += w._board[_lastRow][x];
	}
	return s;
    }

    public String getLastColumnString(Woo w){
	String s = "";
	for (int x = 0; x < 8; x++){
	    s += w._board[x][_lastColumn];
	}
	return s;
    }

    public String getLastRightDiagonalString(Woo w){
	int startingRow = _lastRow;
	int startingColumn = _lastColumn;
	for (int x = 0; x < 8; x++){
	    if (startingRow != 7 && startingColumn != 0){
		startingRow += 1;
		startingColumn -= 1;
	    }
	}
	String s = "";
	for (int x = 0; x < 8; x++){
	    if (startingRow != 0 && startingColumn != 7){
		s += w._board[startingRow][startingColumn];
		startingRow -= 1;
		startingColumn += 1;
	    }
	}
	return s;
    }

    public String getLastLeftDiagonalString(Woo w){
	int startingRow = _lastRow;
	int startingColumn = _lastColumn;
	for (int x = 0; x < 8; x++){
	    if (startingRow != 0 && startingColumn != 0){
		startingRow -= 1;
		startingColumn -= 1;
	    }
	}
	String s = "";
	for (int x = 0; x < 8; x++){
	    if (startingRow != 7 && startingColumn != 7){
		s += w._board[startingRow][startingColumn];
		startingRow += 1;
		startingColumn += 1;
	    }
	}
	return s;
    }

    //SMART DEPLOYMENT

    public boolean isTriple(Woo w){
	
    }

    //Horizontal Triple Check
    public boolean isHorizontalTriple(Woo w){
	for (int x = 0; x < w._board.length; x++){
	    for (int y = 0; y < w._board[x].length - 2; y++){
		if (w._board[x][y] ==
		    w._board[x][y+1] && w._board[x][y+1] ==
		    w._board[x][y+2]){
		    return true;
		}
	    }
	}
	return false;
    }

    //Vertical Triple Check
    public boolean isVerticalTriple(Woo w){
	for (int y = 0; y < w._board[0].length; y++){
	    for (int x = 0; x < w._board.length - 2; x++){
		if (w._board[x][y] ==
		    w._board[x+1][y] && w._board[x+1][y] ==
		    w._board[x+2][y]){
		    return true;
		}
	    }
	}
	return false;
    }

    //Left Diagonal Triple Check
    public boolean isLDTriple(Woo w){
	for (int x = 0; x < 5; x++){
	    for (int y = 0; y < 5; y++){
		if (w._board[x][y] ==
		    w._board[x+1][y+1] && w._board[x+1][y+1] ==
		    w._board[x+2][y+2]){
		    return true;
		}
	    }
	}
        return false;
    }

    //Right Diagonal Triple Check
    public boolean isRDTriple(Woo w){
	for (int x = 0; x < 5; x++){
	    for (int y = 7; y > 2; y++){
		if (w._board[x][y] == 
		    w._board[x+1][y-1] && w._board[x+1][y-1] ==
		    w._board[x+2][y-2]){
		    return true;
		}
	    }
	}
	return false;
    }
    
}
