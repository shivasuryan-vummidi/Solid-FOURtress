public class MediumComputer extends EasyComputer {

    public MediumComputer(){
	name = "MediumComputer";
	token_name = 'M';
    }

    public MediumComputer(String userName, char tokenName){
	name = userName;
	token_name = tokenName;
    }

    public int pick_column(Woo w, Player p) {
	String almost1 = "_" + p.token_name + p.token_name + p.token_name;
	for (int x = 0; x < w.numColumns;x++) {
	    String Col = p.getColumnString(w,x);
	    if (hasSubString(Col, almost1)) {
		return p._lastColumn;
	    }
	}
	return super.pick_column(w, p);
    }
}
