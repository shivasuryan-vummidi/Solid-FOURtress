import cs1.Keyboard;
public class Woo {
    
    public char[][] _board;
    private boolean gameOver;
    public int numRows, numColumns;
    
    public void create_board(int rows, int columns) {
	numRows = rows;
	numColumns = columns;
	_board = new char[rows][columns];
	for (int x = 0; x < numRows;x++) {
	    for (int y = 0; y < numColumns;y++) {
		_board[x][y] = '_';
	    }
	}
    }

    public void check_winner(Player p1, Player p2){
	if(p1.is_win(this)){
	    System.out.println("Player " + p1 + " has won!");
	    gameOver = true;
	}
	else if (p1.tokens == 0 && p2.tokens == 0) {
	    System.out.println("Draw. Nobody Wins!");
	    gameOver = true;
	}
	else{
	    System.out.println("Nobody has yet to win, continue playing.");
	}
    }

    //DEFAULT CONSTRUCTOR
    public Woo(){
        create_board(8,8);
	gameOver = false;
	newGame();
    }

    public Woo(int rows, int columns) {
	create_board(rows, columns);
	gameOver = false;
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
	for (int x = 0; x < numRows; x++) {
	    if (_board[x][column] == '_') {
		row = x;
	    }
	}
	p._lastRow = row;
	p._lastColumn = column;
	set(row,column,p.token_name);
    }

    public String printBoard(){
	String s = "  ";
	for (int x = 0; x < numColumns; x++ ) {
	    s += x + " ";
	}
	s += "\n ╔";
	for (int y = 0; y < numColumns-1; y++) {
	    s += "═╦";
	}
	s += "═╗\n";	
	for (int x = 0; x < numRows; x++) {
	    s += x;
	    for (int y = 0; y < numColumns; y++) {
		s += "║" + _board[x][y];
	    }
	    s += "║";
		
	    if (x < numRows-1) {
		s += "\n ╠";
		for (int y = 0; y < numColumns-1; y++) {
		    s += "═╬";
		}
		s += "═╣\n";
	    }
	}
	s += "\n ╚";
	for (int y = 0; y < numColumns-1; y++) {
	    s += "═╩";
	}
	s += "═╝\n"; 
	return s;
    }
    

    public void newGame(){
	String s = "";
	System.out.println("Hello, player! ");
	String name1 = "player1";
	char char1 = '&';
	String name2 = "player2";
	char char2 = '$';
	int gameMode = 0;

	s = "Player 1: Please enter your name: ";
	System.out.println(s);
        name1 = Keyboard.readWord();

	s = "Please enter what char you want to use in the game. It cannot be C or underscore and can only be 1 letter.";
	System.out.println(s);
	char1 = Keyboard.readChar();
	while (char1 == 'C' || char1 == '_'){
	    s = "You cannot use C or _ as your token name! Please try again: ";
	    System.out.println(s);
	    char1 = Keyboard.readChar();
	}
	/////////////////////////////////////////////////////////

	s = "Would you like a 2-player game or a 1 vs computer game?\nEnter 0 for 2-Player\nEnter 1 for Computer";
	System.out.println(s);
	boolean mode = true;
	while (mode) {
	    gameMode = Keyboard.readInt();
	    if(gameMode == 0){
		mode = false;
		s = "Player 2: Please enter your name: ";
		System.out.println(s);
		name2 = Keyboard.readWord();
		s = "Please enter what char you want to use in the game. It can only be 1 letter and cannot be underscore.";
		System.out.println(s);
		char2 = Keyboard.readChar();
		while (char2 == '_'){
		    s = "You cannot use _ as your token name! Please try again: ";
		    System.out.println(s);
		    char2 = Keyboard.readChar();
		}

		User player1 = new User(name1, char1);
		player1.tokens = (numRows * numColumns) / 2;
		User player2 = new User(name2, char2);
		player2.tokens = (numRows * numColumns) / 2;
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
		    check_winner(player1,player2);
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
		    check_winner(player2,player1);
		}
	    }

	    /////
	    //Player vs computer - EASY
	    /////
	    else if(gameMode == 1){
		mode = false;
		User player1 = new User(name1, char1);
		player1.tokens = (numRows * numColumns) / 2;
		Computer computer1  = new Computer();
		computer1.tokens = (numRows * numColumns) / 2;
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
		    check_winner(player1,computer1);
		    if (gameOver == true) break;
		    col2 = computer1.pick_column(this);
		    computer1.drop_token(col2,this);
		    System.out.println(printBoard());
		    System.out.println("Computer last row #: " + computer1._lastRow);
		    System.out.println("Computer last column #: " + computer1._lastColumn);
		    check_winner(computer1,player1);
		}
	    }
	    else{
		System.out.println("This gamemode is nonexistent. Try Again");
	    }
	}
    }
    //////////////////////////////////////////////////////
	
    public static void main(String[] args){
	Woo a = new Woo(6,7);
    }
}
