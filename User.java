import cs1.Keyboard;

public class User extends Player{

    //default constructor for User
    public User(){
	name = "User";
	token_name = 'U';
    }

    //overloaded constructor for User that takes userName and tokenName input
    public User(String userName, char tokenName){
	name = userName;
	token_name = tokenName;
    }

    //asks for slot to drop, asks again if invalid
    public int pick_column(Woo w, Player p) {
	int column = 0;
	boolean incomplete = true;
	System.out.print(name + ", please enter what column you want to drop your token: ");
	while (incomplete) {
	    column = Keyboard.readInt();
	    if (column < 0 || column >= w.numColumns) {
		System.out.print("Out of Range or Invalid. Please try again: ");
	    }
	    else {
		incomplete = false;
	    }
	}
    	return column;
    }
}
