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
    public int pick_column(Woo w) {
	int column = 0;
	boolean incomplete = true;
	while (incomplete) {
	    try {
		System.out.println(name + ", please enter what column you want to drop your token.");
		column = Integer.parseInt(in.readLine());
	    }
	    catch(IOException e){ }
	    if (column < 0 || column >= w._board[0].length) {
		System.out.println("Out of Range. Try again!");
	    }
	    else {
		incomplete = false;
	    }
	}
    	return column;
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
        for (int x = 0; x < w._board.length; x++) { //start from top right of diag
            int z = _lastColumn + _lastRow - x;     //go to bottom left of diag
            if (0 <= z && z < w._board[0].length) { //make sure z is still in range
		s += w._board[x][z];
            }
        }
	return s;
    }
    public String getLastLeftDiagonalString(Woo w){
	String s = "";
        for (int x = 0; x < w._board.length; x++) { //start from top left of diag
            int z = _lastColumn - _lastRow + x;     //go to bottom right of diag
            if (0 <= z && z < w._board[0].length) { //make sure z is still in range
		s += w._board[x][z];
            }
        }
	return s;
    }

    public String toString() {
	return name;
    }
}
