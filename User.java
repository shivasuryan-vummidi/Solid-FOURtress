import cs1.Keyboard;

public class User extends Player{

    public User(){
	tokens = 32;
    }

    public User(String name, char token_name){
        this();
	this.name = name;
	this.token_name = token_name;
    }

    public int pick_column(Woo w) {
	int column = 0;
	boolean incomplete = true;
	while (incomplete) {
	    System.out.println(name + ", please enter what column you want to drop your token.");
	    column = Keyboard.readInt();
	    if (column < 0 || column >= w.numColumns) {
		System.out.println("Out of Range or Invalid. Try again!");
	    }
	    else {
		incomplete = false;
	    }
	}
    	return column;
    }
}
