public class HardComputer extends MediumComputer {

    //default constructor for HardComputer
    public HardComputer(){
	name = "HardComputer";
	token_name = 'H';
    }

    //overloaded constructor for HardComputer that takes userName and tokenName input
    public HardComputer(String userName, char tokenName){
	name = userName;
	token_name = tokenName;
    }


    //stragecially decides where to defensively place a token
    //checks for a possible horizontal win to block    
    public int defense(Woo w, Player p) {
	String almost1 = "_" + String.valueOf(p.token_name) + String.valueOf(p.token_name) + String.valueOf(p.token_name); //_***
	String almost2 = String.valueOf(p.token_name) + "_" + String.valueOf(p.token_name) + String.valueOf(p.token_name); //*_**
	String almost3 = String.valueOf(p.token_name) + String.valueOf(p.token_name) + "_" + String.valueOf(p.token_name); //**_*
	String almost4 = String.valueOf(p.token_name) + String.valueOf(p.token_name) + String.valueOf(p.token_name) + "_"; //***_
	for (int x = 0; x < w.numRows; x++) {
	    String Row = getRowString(w,x);
	    String underRow = getRowString(w,x+1);
	    if(hasSubString(Row,almost1)) {
		int missingSlot = Row.indexOf(almost1);
		if (underRow.charAt(missingSlot) != '_') {
		    return missingSlot;
		}
	    }
	    if (hasSubString(Row,almost2)) {
		int missingSlot = Row.indexOf(almost2) + 1;
		if (underRow.charAt(missingSlot) != '_') {
		    return missingSlot;
		}
	    }
	    if (hasSubString(Row,almost3)) {
		int missingSlot = Row.indexOf(almost3) + 2;
		if (underRow.charAt(missingSlot) != '_') {
		    return missingSlot;
		}
	    }
	    if(hasSubString(Row,almost4)) {
		int missingSlot = Row.indexOf(almost4) + 3;
		if (underRow.charAt(missingSlot) != '_') {
		    return missingSlot;
		}
	    }
	}
	return -1;
    }

    //stragecially decides where to defensively place a token
    //inherits vertical defense from MediumComputer
    public int secondaryDefense(Woo w, Player p) {
	return super.defense(w,p);
    }
    
    //first checks for horizontal defense, then vertical defense, then horizontal offense, then vertical offense
    public int pick_column(Woo w, Player p) {
	int choice = defense(w, p); //horizontal defense
	if (choice == -1) choice = secondaryDefense(w, p); //vertical defense
	if (choice == -1) choice = offense(w, p); //horizontal defense, vertical defense
	if (choice == -1) choice = super.pick_column(w, p); //no other option
	return choice;
    }
}
