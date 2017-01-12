public class User extends Player{
    public User(){
	tokens = 32;
    }
    public User(String name, char token_name){
        this();
	this.name = name;
	this.token_name = token_name;
    }
    public void drop_token(int column){
	if(Woo.is_column_full(column)){
	    System.out.println("ERROR: Please try again. Column " + column + " is full.");
	}
	else{
	    Woo.drop(column, token_name);
	}
    }
    public void is_win(){

    }
}
