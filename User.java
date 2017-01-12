import java.io.*;
import java.util.*;

public class User extends Player{

    
    private InputStreamReader isr;
    private BufferedReader in;

    public User(){
	tokens = 32;
    }
    public User(String name, char token_name){
        this();
	this.name = name;
	this.token_name = token_name;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
    }
    public void drop_token(int column,Woo w){
	if(w.is_column_full(column)){
	  System.out.println("ERROR: Please try again. Column " + column + " is full.");
	}
	else{
	    w.drop(column, this);
	}
    }
    public int pick_column() {
	int column = 0;
	try {
	    System.out.println("Please enter what column you want to drop your token.");
	    column = Integer.parseInt(in.readLine());
	}
	catch(IOException e){ }
    	return column;
    }
    public boolean is_win(Woo w){
	int counter_column = 0;
	String a = getLastColumnString(w);
	for(int x = 0; x < a.length() - 1; x++){
	    if(token_name == a.charAt(x) && token_name == a.charAt(x + 1)){
		counter_column++;
	    }
	}
	if(a.charAt(7) == token_name){
	    counter_column++;
	}
	//DEBUG
	System.out.println(a);
	System.out.println(counter_column);
        int counter_row = 0;
	a = getLastRowString(w);
	for(int x = 0; x < a.length() - 1; x++){
	    if(token_name == a.charAt(x) && token_name == a.charAt(x + 1)){
		counter_row++;
	    }
	}
	if(a.charAt(7) == token_name){
	    counter_row++;
	}
	// DEBUG
	System.out.println(a);
	System.out.println(counter_row);

	int counter_diag_right = 0;
	//DOES NOT WORK YET, please add diagonals
	/*a = getLastRightDiagonalString(w);
	for(int x = 0; x < a.length() - 1; x++){
	    if(token_name == a.charAt(x) && token_name == a.charAt(x + 1)){
	        counter_diag_right++;
	    }
	}
	if(a.charAt(7) == token_name){
	    counter_diag_right++;
	}
	// DEBUG
	System.out.println(a);
	System.out.println(counter_row);
	*/
	
	//KEEP SEPARATE FROM THE OTHERS, checks if any algorithms pop up a win
	if(counter_column >= 4 || counter_row >= 4 || counter_diag_right >= 4){
	    return true;
	}
	return false;
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
	String s = "";
	int newX = 0;
	int newY = 0;
	for (int y = _lastColumn; y < 8  ; y++){
	    newX = _lastRow--;
	    newY = _lastColumn++;
	}
	for (int x = newX; x < 8; x++){
	    s += w._board[(_lastRow + newX)  % 7][(_lastColumn - newY) % 7];
	}
	return s;
    }
    public String getLastLeftDiagonalString(Woo w){
	String s = "";
	for (int x = 0; x < 8; x++){
	    s += w._board[0][0];
	}
	return s;
    }
}
