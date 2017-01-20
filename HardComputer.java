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

    //first checks for a possible horizontal win to block, then vertical, otherwise random slot
    public int pick_column(Woo w, Player p) {
	String almost1 = "_" + p.token_name + p.token_name + p.token_name;
	String almost2 = p.token_name + almost1.substring(0,3);
	String almost3 = p.token_name + almost2.substring(0,3);
	String almost4 = p.token_name + almost3.substring(0,3);
	for (int x = 0; x < w.numRows; x++) {
	    String Row = p.getRowString(w,x);
	    String underRow = p.getRowString(w,x+1);
	    if(hasSubString(Row,almost1)) {
		int missingSlot = Row.indexOf(almost1);
		if (underRow.charAt(missingSlot) != '_') {
		    return missingSlot;
		}
		else return super.pick_column(w, p);
	    }
	    else if (hasSubString(Row,almost2)) {
		int missingSlot = Row.indexOf(almost2) + 1;
		System.out.println(missingSlot);
		if (underRow.charAt(missingSlot) != '_') {
		    return missingSlot;
		}
		else return super.pick_column(w, p);
	    }
	    else if (hasSubString(Row,almost3)) {
		int missingSlot = Row.indexOf(almost3) + 2;
		if (underRow.charAt(missingSlot) != '_') {
		    return missingSlot;
		}
		else return super.pick_column(w, p);
	    }
	    else if(hasSubString(Row,almost4)) {
		int missingSlot = Row.indexOf(almost4) + 3;
		if (underRow.charAt(missingSlot) != '_') {
		    return missingSlot;
		}
		else return super.pick_column(w, p);
	    }
	}
	return super.pick_column(w, p);
    }
}
