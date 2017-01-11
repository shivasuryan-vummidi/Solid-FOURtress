public class Woo {
    
    private String[][] _board;
    private boolean gameOver;

    private InputStreamReader isr;
    private BufferedReader in;

    public void create_board() {
	_board = new String[8][8];
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

    

}
