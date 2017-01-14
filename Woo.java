import java.io.*;
import java.util.*;
public class Woo {
    
    public char[][] _board;
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

    public void check_winner(Player p){
	if(p.is_win(this)){
	    System.out.println("Player " + p + " has won!");
	    gameOver = true;
	}
	else{
	    System.out.println("Nobody has yet to win, continue playing.");
	}
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
    
    public void drop(int column, Player p){
	int row = 0;
	for (int x = 0; x < _board[column].length; x++) {
	    if (_board[x][column] == '_') {
		row = x;
	    }
	}
	p._lastRow = row;
	p._lastColumn = column;
	set(row,column,p.token_name);
    }

    public String printBoard(){
	String s = "╔";
	for (int z = 0; z < _board[0].length-1;z++) {
	    s += "═╦";
	}
	s += "═╗\n";
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
		s += "\n╠";
		for (int w = 0; w < _board[0].length-1;w++) {
		    s += "═╬";
		}
		s += "═╣\n";
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
	String name2 = "player2";
	char char2 = '$';
	int gameMode = 0;
	try{
	    System.out.println("Player 1: Please enter your name.");
	    name1 = in.readLine();
	}
	
	catch(IOException e){ }
	try {
	    System.out.println(name1 + ": Please enter what char you want to use in the game. It can only be 1 letter     ");
	    char1 = in.readLine().charAt(0);
	}
	catch(IOException e){ }
	//////////////////////////////////////////////////////
	try{
	    System.out.println("Would you like a 2-player game or a 1 vs computer game?\nEnter 0 for 2 player\nEnter 1 for computer");
	    try{
		gameMode = Integer.parseInt(in.readLine());
	    }
	    catch(IOException e){}
	    if(gameMode == 0){
		try{
		    System.out.println("Player 2: Please enter your name.");
		    name2 = in.readLine();
		}
		catch(IOException e){ }
		try {
		    System.out.println(name2 + ": Please enter what char you want to use in the game. It can only be 1 letter.     ");
		    char2 = in.readLine().charAt(0);
		}
		catch(IOException e){ }
		User player1 = new User(name1, char1);
		User player2 = new User(name2, char2);
		int col1 = -1;
		int col2 = -1;
		while (!gameOver) {
		    boolean incomplete = true;
		    while (incomplete) {
			col1 = player1.pick_column(this);
			if(is_column_full(col1)){
			    System.out.println("ERROR: Please try again. Column " + col1 + " is full.");
			}
			else {
			    player1.drop_token(col1,this);
			    incomplete = false;
			}
		    }
		    System.out.println(printBoard());
		    System.out.println("Player 1 last row #: " + player1._lastRow);
		    System.out.println("Player 1 last column #: " + player1._lastColumn);
		    check_winner(player1);
		    if (gameOver == true) break;
		    incomplete = true;
		    while (incomplete) {
			col2 = player2.pick_column(this);
			if(is_column_full(col2)){
			    System.out.println("ERROR: Please try again. Column " + col2 + " is full.");
			}
			else {
			    player2.drop_token(col2,this);
			    incomplete = false;
			}
		    }
		    System.out.println(printBoard());
		    System.out.println("Player 2 last row #: " + player2._lastRow);
		    System.out.println("Player 2 last column #: " + player2._lastColumn);
		    check_winner(player2);
		}
	    }

	    /////
	    //Player vs computer - EASY
	    /////
	    else if(gameMode == 1){
		User player1 = new User(name1, char1);
		Computer computer1  = new Computer();
		int col1 = -1;
		int col2 = -1;
		while (!gameOver) {
		    boolean incomplete = true;
		    while (incomplete) {
			col1 = player1.pick_column(this);
			if(is_column_full(col1)){
			    System.out.println("ERROR: Please try again. Column " + col1 + " is full.");
			}
			else {
			    player1.drop_token(col1,this);
			    incomplete = false;
			}
		    }
		    System.out.println(printBoard());
		    System.out.println("Player 1 last row #: " + player1._lastRow);
		    System.out.println("Player 1 last column #: " + player1._lastColumn);
		    check_winner(player1);
		    if (gameOver == true) break;
		    incomplete = true;
		    while (incomplete) {
			col2 = (int)(Math.random() * 7);
			if(is_column_full(col2)){
			    System.out.println("ERROR: Please try again. Column " + col2 + " is full.");
			}
			else {
			    computer1.drop_token(col2,this);
			    incomplete = false;
			}
		    }
		    System.out.println(printBoard());
		    System.out.println("Computer last row #: " + computer1._lastRow);
		    System.out.println("Computer last column #: " + computer1._lastColumn);
		    check_winner(computer1);
		}
	    }
	    else{
		System.out.println("This gamemode is nonexistent.");
	    }
	}
	catch(Exception e){};
	//////////////////////////////////////////////////////
	
    }
    public static void main(String[] args){
	Woo a = new Woo();
    }
}
