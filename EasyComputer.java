public class EasyComputer extends Player {

    //Default constructor for Computer class with easy difficulty
    public EasyComputer(){
	name = "EasyComputer";
	token_name = 'E';
    }

    //Overloaded constructor to set a different name and char that is not default for EasyComputer
    public EasyComputer(String userName, char tokenName){
	name = userName;
	token_name = tokenName;
    }

    //Pick a column to drop the token in
    //Computer with easy difficulty should select the column randomly regardless of the situation
    public int pick_column(Woo w, Player p) {
	int column = -1;
	boolean incomplete = true;
	while (incomplete) {
	    column = (int)(Math.random() * w.numColumns);
	    if (!w.is_column_full(column)) {
		incomplete = false;
	    }
	    else { }
	}
	return column;
    }
}
