public class HardComputer extends Player {

    public HardComputer(){
	name = "Computer";
	token_name = 'C';
    }

    public int pick_column(Woo w) {
	int column = -1;
	boolean incomplete = true;
	while (incomplete) {
	    column = (int)(Math.random() * w.numColumns);
	    if (!w.is_column_full(column)) {
		incomplete = false;
	    }
	    else { }
	}
	return column;
    }
    
    //SMART DEPLOYMENT

    public boolean isTriple(Woo w){
	return true;
    }

    //Horizontal Triple Check
    public boolean isHorizontalTriple(Woo w){
	for (int x = 0; x < w.numRows; x++){
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
	for (int y = 0; y < w.numColumns; y++){
	    for (int x = 0; x < w.numRows - 2; x++){
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
