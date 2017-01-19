public class HardComputer extends Computer {

    private int vertTripleLocation, horzTripleLocation;
    private int playerVTL, playerHTL;

    public HardComputer(){
	name = "HardComputer";
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
	    else if(isVerticalTriple(w)){
	        return vertTripleLocation;
	    }
	    else if(isVerticalTriple(w)){
		int a = -1;
		//Basically, this checks either side of the triple to see whether there is a vacancy in the area to the left of the board. It then looks for whether or not the tile 1 left and 1 down is filled or not. 
		if(w._board[(vertTripleLocation + a) % w.numColumns][(horzTripleLocation - 1) & w.numRows] != '_'){
		    column = vertTripleLocation + a;
		}
		else{
		    a = 1;
		    column = (vertTripleLocation + a ) % w.numColumns;
		}
	    }
	    else { }
	}
	return column;
    }
    
    //SMART DEPLOYMENT

    /*public boolean isTriple(Woo w){
	return (isHorizontalTriple(w) && isVerticalTriple(w));
	}*/

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
		    vertTripleLocation = y;
		    return true;
		}
	    }
	}
	return false;
    }
}
