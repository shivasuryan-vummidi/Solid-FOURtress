public class EasyComputer extends Player {

    public EasyComputer(){
	name = "EasyComputer";
	token_name = 'E';
    }

    public EasyComputer(String userName, char tokenName){
	name = userName;
	token_name = tokenName;
    }

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
