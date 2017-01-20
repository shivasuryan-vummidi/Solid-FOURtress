public class MediumComputer extends EasyComputer {

    public MediumComputer(){
	name = "Computer";
	token_name = 'M';
    }

    public MediumComputer(String userName, char tokenName){
	name = userName;
	token_name = tokenName;
    }

    public int pick_column(Woo w, Player p) {
	String almost1 = "_" + p.token_name + p.token_name + p.token_name;
	String lastCol = p.getLastColumnString(w);
	if (hasSubString(lastCol, almost1)) {
	    return p._lastColumn;
	}
	else return super.pick_column(w, p);
    }
}
