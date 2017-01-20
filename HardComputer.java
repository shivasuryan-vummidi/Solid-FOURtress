public class HardComputer extends MediumComputer {

    public HardComputer(){
	name = "HardComputer";
	token_name = 'H';
    }

    public HardComputer(String userName, char tokenName){
	name = userName;
	token_name = tokenName;
    }

    public int pick_column(Woo w, Player p) {
	String almost1 = "_" + p.token_name + p.token_name + p.token_name;
	String almost2 = p.token_name + almost1.substring(0,3);
	String almost3 = p.token_name + almost2.substring(0,3);
	String almost4 = p.token_name + almost3.substring(0,3);
	String lastRow = p.getLastRowString(w);
	String underLastRow = p.getRowString(w, p._lastRow + 1);
	if(hasSubString(lastRow,almost1)) {
	    int missingSlot = lastRow.indexOf(almost1);
	    if (underLastRow.charAt(missingSlot) != '_') {
		return missingSlot;
	    }
	    else return super.pick_column(w, p);
	}
	else if (hasSubString(lastRow,almost2)) {
	    int missingSlot = lastRow.indexOf(almost2) + 1;
	    System.out.println(missingSlot);
	    if (underLastRow.charAt(missingSlot) != '_') {
		return missingSlot;
	    }
	    else return super.pick_column(w, p);
	}
	else if (hasSubString(lastRow,almost3)) {
	    int missingSlot = lastRow.indexOf(almost3) + 2;
	    if (underLastRow.charAt(missingSlot) != '_') {
		return missingSlot;
	    }
	    else return super.pick_column(w, p);
	}
	else if(hasSubString(lastRow,almost4)) {
	    int missingSlot = lastRow.indexOf(almost4) + 3;
	    if (underLastRow.charAt(missingSlot) != '_') {
		return missingSlot;
	    }
	    else return super.pick_column(w, p);
	}
	else return super.pick_column(w, p);
    }
}
