import java.io.*;
import java.util.*;
public class Woo {
    
    private char[][] _board;
    private boolean gameOver;

    private InputStreamReader isr;
    private BufferedReader in;

    public void create_board() {
	_board = new char[8][8];
	for (int x = 0; x < _board[0].length;x++) {
	    for (int y = 0; y < _board.length;y++) {
		_board[x][y] = '_';
	    }
	}
    }

    public void check_winner(){
	
    }

    //DEFAULT CONSTRUCTOR
    public Woo(){
        create_board();
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }

    public boolean is_column_full(int column){
        return(_board[0][column] != '_');
    }

    public void set(int row, int column, char x) {
	_board[row][column] = x;
    }
    
    public void drop(int column, char token_name){
	int row = 0;
	for (int x = 0; x < _board[column].length; x++) {
	    if (_board[x][column] == '_') {
		row = x;
	    }
	}
	set(row,column,token_name);
    }

    public String printBoard(){
	String s = "╔═╦═╦═╦═╦═╦═╦═╦═╗\n";
	for (int x = 0; x < _board[0].length;x++) {
	    s += "║";
	    for (int y = 0; y < _board.length;y++) {
    		s += _board[x][y];
		if (y < _board.length-1) {
		    s += "║";
		}
		else {
		    if (y % 2 == 0) {
			s += "╣";
		    }
		    else {
			s += "║";
		    }
		}
	    }
	    if (x < _board[0].length-1) {
		s += "\n╠-╬-╬-╬-╬-╬-╬-╬-╣\n";
	    }
	    else {
		s += "\n╚═╩═╩═╩═╩═╩═╩═╩═╝\n"; 
	    }
	}
	return s;
    }

    public void newGame(){
	System.out.println("Hello, player! ");
	String name1 = "player1";
	char char1 = '&';
	try{
	    System.out.println("Please enter your name.");
	    name1 = in.readLine();
	}
	catch(IOException e){ }
	try {
	    System.out.println("Please enter what character you want to use in the game.     ");
	    char1 = in.readLine().charAt(0);
	}
	catch(IOException e){ }
	User player1 = new User(name1, char1);
	int col1 = player1.pick_column();
	for(int x = 0; x < 9; x++){
	    player1.drop_token(col1,this);
	}
	System.out.println(printBoard());
    }
    public static void main(String[] args){
	Woo a = new Woo();
    }
}
