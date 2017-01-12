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
    public boolean is_win(){
	return true;
    }
    
    public String getLastRowString() {
	return "a";
    }

    public String getLastColumnString() {
	return "a";
    }

    public String getLastDiagonalString() {
	return "a";
    }
}
