import cs1.Keyboard;
public class Woo {
    
    public char[][] _board;
    private boolean gameOver;
    public int numRows, numColumns;
    private Player p1, p2;
    
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
	s = "Welcome to Connect Four!\n";
	s += "\nChoose Your Board size: \n";
	s += "\t1. 6 rows by 7 Columns\n";
	s += "\t2. 7 rows by 8 Columns\n";
	s += "\t3. 7 rows by 10 Columns\n";
	s += "\t4. 8 rows by 8 Columns \n";
	s += "Selection: ";
	System.out.print(s);
       	int boardSize = -1;
	boardSize = Keyboard.readInt();
	while (boardSize < 0 || boardSize > 4) {
	    System.out.println("Invalid Option. Try Again!");
	    boardSize = Keyboard.readInt();
	}

	if (boardSize == 1) create_board(6,7);
	else if (boardSize == 2) create_board(7,8);
	else if (boardSize == 3) create_board(7,10);
	else if (boardSize == 4) create_board(8,8);

	s = "What should Player 1 be?\n";
	s += "\t1. a real person\n";
	s += "\t2. an EasyComputer (random AI)\n";
	s += "\t3. a MediumComputer (can block vertical wins)\n";
	s += "\t4. a HardComputer (can block vertical and horizontal wins)\n";
	s += "\t5. a TBM (can block vertical, horizontal, and diagonal wins)\n";
	s += "Selection: ";
	System.out.print(s);
	
	int firstPlayer = -1;
	firstPlayer = Keyboard.readInt();
	while (firstPlayer < 0 || firstPlayer > 5) {
	    System.out.print("Invalid Option. Please try Again: ");
	    firstPlayer = Keyboard.readInt();
	}

	String name1 = "p1";
	char char1 = '*';
	if (firstPlayer == 1) {
	    System.out.print("Player 1: Please enter your name: ");
	    name1 = Keyboard.readWord();
	    while (name1.equals("EasyComputer") || name1.equals("MediumComputer") || name1.equals("HardComputer") || name1.equals("TBM") ||
		   name1.equals("EasyComputer2") || name1.equals("MediumComputer2") || name1.equals("HardComputer2") || name1.equals("TBM2")) {
		System.out.print("The name you have choosen is reserved for AI. Please Try Again: ");
		name1 = Keyboard.readWord();
	    }
	    System.out.println("Please enter what char you want to use in the game. It cannot be C, E, M, H, T, -, or _ and can only be 1 letter.");
	    char1 = Keyboard.readChar();
	    while (char1 == 'C' || char1 == 'E' || char1 == 'M' || char1 == 'H' || char1 == 'T' || char1 == '-' || char1 == '_' ){
		System.out.print("You cannot use C, E, M, H, T, -, or _ as your token name! Please try again: ");
		char1 = Keyboard.readChar();
	    }
	    p1 = new User(name1, char1);
	}
	else if (firstPlayer == 2) {
	    p1 = new EasyComputer();
	}
	else if (firstPlayer == 3) {
	    p1 = new MediumComputer();
	}
	else if (firstPlayer == 4) {
	    p1 = new HardComputer();
	}
	else if (firstPlayer == 5) {
	    p1 = new TBM();
	}

	s = "What should Player 2 be?\n";
	s += "\t1. a real person\n";
	s += "\t2. an EasyComputer (random AI)\n";
	s += "\t3. a MediumComputer (can block vertical wins)\n";
	s += "\t4. a HardComputer (can block vertical and horizontal wins)\n";
	s += "\t5. a TBM (can block vertical, horizontal, and diagonal wins)\n";
	s += "Selection: ";
	System.out.print(s);

	int secondPlayer = -1;
	secondPlayer = Keyboard.readInt();
	while (secondPlayer < 0 || secondPlayer > 5) {
	    System.out.print("Invalid Option. Please try Again: ");
	    secondPlayer = Keyboard.readInt();
	}

	String name2 = "p2";
	char char2 = '#';
	if (secondPlayer == 1) {
	    System.out.print("Player 2: Please enter your name: ");
	    name2 = Keyboard.readWord();
	    while (name2.equals("EasyComputer") || name2.equals("MediumComputer") || name2.equals("HardComputer") || name2.equals("TBM") ||
		   name2.equals("EasyComputer2") || name2.equals("MediumComputer2") || name2.equals("HardComputer2") || name2.equals("TBM2")) {
		System.out.print("The name you have choosen is reserved for AI. Please Try Again: ");
		name2 = Keyboard.readWord();
	    }
	    while (name1.equals(name2)){
		System.out.print("Your name cannot be the same as Player 1! Please try again: ");
		name2 = Keyboard.readWord();
	    }
	    System.out.println("Please enter what char you want to use in the game. It cannot be C, E, M, H, T, -, or _ and can only be 1 letter.");
	    char2 = Keyboard.readChar();
	    while (char2 == 'C' || char2 == 'E' || char2 == 'M' || char2 == 'H' || char2 == 'T' || char2 == '-' || char2 == '_' ){
		System.out.print("You cannot use C, E, M, H, T, -, or _ as your token name! Please try again: ");
		char2 = Keyboard.readChar();
	    }
	    while (char2 == char1) {
		System.out.print("Your token name cannot be the same as Player 1! Please Try again: ");
		char2 = Keyboard.readChar();
	    }
	    p2 = new User(name2, char2);
	}
	else if (secondPlayer == 2) {
	    if (firstPlayer == 2) p2 = new EasyComputer("EasyComputer2",'C');
	    else p2 = new EasyComputer();
	}
	else if (secondPlayer == 3) {
	    if (firstPlayer == 3) p2 = new MediumComputer("MediumComputer2",'C');
	    else p2 = new MediumComputer();
	}
	else if (secondPlayer == 4) {
	    if (firstPlayer == 4) p2 = new HardComputer("HardComputer2",'C');
	    else p2 = new HardComputer();
	}
	else if (secondPlayer == 5) {
	    if (firstPlayer == 5) p2 = new TBM("TBM2",'C');
	    else p2 = new TBM();
	}
	
	p1.tokens = (numRows * numColumns) / 2;
	p2.tokens = (numRows * numColumns) / 2;
	while (!gameOver) {
	    int col1 = -1;
	    boolean incomplete = true;
	    while (incomplete) {
		col1 = p1.pick_column(this, p2);
		if(is_column_full(col1)){
		    System.out.println("ERROR: Please try again. Column " + col1 + " is full.");
		}
		else {
		    p1.drop_token(col1,this);
		    incomplete = false;
		}
	    }
	    if (firstPlayer != 1) {
		System.out.println(p1 + " is currently thinking...");
		try {
		    Thread.sleep(1000 + (int) Math.random()*2000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	    }
	    System.out.println(printBoard());
	    System.out.println("DIAGNOSTIC");
	    System.out.println("Player 1 last row #: " + p1._lastRow);
	    System.out.println("Player 1 last column #: " + p1._lastColumn);
	    check_winner(p1,p2);
	    if (gameOver == true) break;
	    int col2 = -1;
	    incomplete = true;
	    while (incomplete) {
		col2 = p2.pick_column(this, p1);
		if(is_column_full(col2)){
		    System.out.println("ERROR: Please try again. Column " + col2 + " is full.");
		}
		else {
		    p2.drop_token(col2,this);
		    incomplete = false;
		}
	    }
	    if (secondPlayer != 1) {
		System.out.println(p2 + " is currently thinking...");
		try {
		    Thread.sleep(1000 + (int) Math.random()*2000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	    }
	    System.out.println(printBoard());
	    System.out.println("DIAGNOSTIC");
	    System.out.println("Player 2 last row #: " + p2._lastRow);
	    System.out.println("Player 2 last column #: " + p2._lastColumn);
	    check_winner(p2,p1);
	}
    }

    //////////////////////////////////////////////////////
	
    public static void main(String[] args){
	Woo a = new Woo();
    }
}
