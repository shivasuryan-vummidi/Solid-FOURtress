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
	newGame();
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
	String s = "|";
	for(int y = 0; y < 8; y++){
	    for(int x = 0; x < 8; x++){
		s += _board[y][x] + "|";
	    }
	    s+= "\n-----------------\n|";
	}
	s = s.substring(0, s.length() - 1);
	return s;
    }

    public void newGame(){
	System.out.println("Hello, player! Please enter your name.     ");
	try{
	    String name1 = in.readLine();
	    System.out.println("Please enter what character you want to use in the game.     ");
	    char char1 = in.readLine().charAt(0);
	    User player1 = new User(name1, char1);
	    System.out.println("Please enter what column you want to drop your token.");
	    int col1 = Integer.parseInt(in.readLine());
	    player1.drop_token(col1);
	}catch(IOException e){}
	printBoard();
    }
    public static void main(String[] args){
	Woo a = new Woo();
	
    }
}
