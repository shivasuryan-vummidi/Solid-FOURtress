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
}
