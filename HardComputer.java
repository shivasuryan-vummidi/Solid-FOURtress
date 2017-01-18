public class HardComputer extends Player {

    private int vertTripleLocation, horzTripleLocation;

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
	horzTripleLocation = -1;
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
	vertTripleLocation = -1;
	for (int y = 0; y < w.numColumns; y++){
	    for (int x = 0; x < w.numRows - 2; x++){
		if (w._board[x][y] ==
		    w._board[x+1][y] && w._board[x+1][y] ==
		    w._board[x+2][y]){
		    tripleLocation = y;
		    return true;
		}
	    }
	}
	return false;
    }
  
}
