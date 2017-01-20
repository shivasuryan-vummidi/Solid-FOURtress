public class TBM extends HardComputer {

    public TBM(){
	name = "TBM";
	token_name = 'T';
    }

    public TBM(String userName, char tokenName){
	name = userName;
	token_name = tokenName;
    }
    
    public int pick_column(Woo w, Player p) {
	String almost1 = "_" + p.token_name + p.token_name + p.token_name;
	String almost2 = p.token_name + almost1.substring(0,3);
	String almost3 = p.token_name + almost2.substring(0,3);
	String almost4 = p.token_name + almost3.substring(0,3);
	String lastRDiag = p.getLastRightDiagonalString(w);
	String underLastRDiag = p.getRightDiagonalString(w, p._lastRow, p._lastColumn+1);
	String lastLDiag = p.getLastLeftDiagonalString(w);
	String underLastLDiag = p.getLeftDiagonalString(w, p._lastRow, p._lastColumn-1);
	if(hasSubString(lastRDiag,almost1)) {
	    int missingSlot = lastRDiag.indexOf(almost1);
	    if (underLastRDiag.charAt(missingSlot) != '_') {
		return missingSlot;
	    }
	    else return super.pick_column(w, p);
	}
	else if (hasSubString(lastRDiag,almost2)) {
	    int missingSlot = lastRDiag.indexOf(almost2) + 1;
	    System.out.println(missingSlot);
	    if (underLastRDiag.charAt(missingSlot) != '_') {
		return missingSlot;
	    }
	    else return super.pick_column(w, p);
	}
	else if (hasSubString(lastRDiag,almost3)) {
	    int missingSlot = lastRDiag.indexOf(almost3) + 2;
	    if (underLastRDiag.charAt(missingSlot) != '_') {
		return missingSlot;
	    }
	    else return super.pick_column(w, p);
	}
	else if(hasSubString(lastRDiag,almost4)) {
	    int missingSlot = lastRDiag.indexOf(almost4) + 3;
	    if (underLastRDiag.charAt(missingSlot) != '_') {
		return missingSlot;
	    }
	    else return super.pick_column(w, p);
	}
	if(hasSubString(lastLDiag,almost1)) {
	    int missingSlot = lastLDiag.indexOf(almost1);
	    if (underLastLDiag.charAt(missingSlot) != '_') {
		return missingSlot;
	    }
	    else return super.pick_column(w, p);
	}
	else if (hasSubString(lastLDiag,almost2)) {
	    int missingSlot = lastLDiag.indexOf(almost2) + 1;
	    System.out.println(missingSlot);
	    if (underLastLDiag.charAt(missingSlot) != '_') {
		return missingSlot;
	    }
	    else return super.pick_column(w, p);
	}
	else if (hasSubString(lastLDiag,almost3)) {
	    int missingSlot = lastLDiag.indexOf(almost3) + 2;
	    if (underLastLDiag.charAt(missingSlot) != '_') {
		return missingSlot;
	    }
	    else return super.pick_column(w, p);
	}
	else if(hasSubString(lastLDiag,almost4)) {
	    int missingSlot = lastLDiag.indexOf(almost4) + 3;
	    System.out.println(missingSlot);
	    if (underLastLDiag.charAt(missingSlot) != '_') {
		return missingSlot;
	    }
	    else return super.pick_column(w, p);
	}	
	else return super.pick_column(w, p);
    }
}
