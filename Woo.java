import java.io.*;
import java.util.*;
public class Woo {
    
    private char[][] _board;
    private boolean gameOver;

    private InputStreamReader isr;
    private BufferedReader in;

    public void create_board() {
	_board = new char[8][8];
    }

    public void check_winner(){
	
    }

    //DEFAULT CONSTRUCTOR
    public Woo(){
        create_board();
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
    }

    public boolean is_column_full(int column){
        return(_board[column][0] != ' ');
    }
    
    public void drop(int column, char token_name){
	for(int x = 7; x > 0; x--){
	    if(_board[column][x] == ' '){
		_board[column][x] = token_name;
		return;
	    }
	}
    }
    public String printBoard(){
	String s = "";
	for(int y = 0; y < 7; y++){
	    for(int x = 0; x < 7; x++){
		s += _board[y][x] + " ";
	    }
	    s+= "\n";
	}
	return s;
    }
    public static void main(String[] args){
	Woo a = new Woo();
	System.out.println( a.printBoard());
	
    }
}
