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
	for (int x = 0; x < w.numColumns;x++) {
	    for (int y = 0; y < w.numRows;y++) {
		String rDiag = p.getRightDiagonalString(w,x,y);
		String underRDiag = p.getRightDiagonalString(w,x,y+1);
		String lDiag = p.getLeftDiagonalString(w,x,y);
		String underLDiag = p.getLeftDiagonalString(w,x,y-1);
		if(hasSubString(rDiag,almost1)) {
		    int missingSlot = rDiag.indexOf(almost1);
		    if (underRDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		    else return super.pick_column(w, p);
		}
		else if (hasSubString(rDiag,almost2)) {
		    int missingSlot = rDiag.indexOf(almost2) + 1;
		    System.out.println(missingSlot);
		    if (underRDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		    else return super.pick_column(w, p);
		}
		else if (hasSubString(rDiag,almost3)) {
		    int missingSlot = rDiag.indexOf(almost3) + 2;
		    if (underRDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		    else return super.pick_column(w, p);
		}
		else if(hasSubString(rDiag,almost4)) {
		    int missingSlot = rDiag.indexOf(almost4) + 3;
		    if (underRDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		    else return super.pick_column(w, p);
		}
		if(hasSubString(lDiag,almost1)) {
		    int missingSlot = lDiag.indexOf(almost1);
		    if (underLDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		    else return super.pick_column(w, p);
		}
		else if (hasSubString(lDiag,almost2)) {
		    int missingSlot = lDiag.indexOf(almost2) + 1;
		    System.out.println(missingSlot);
		    if (underLDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		    else return super.pick_column(w, p);
		}
		else if (hasSubString(lDiag,almost3)) {
		    int missingSlot = lDiag.indexOf(almost3) + 2;
		    if (underLDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		    else return super.pick_column(w, p);
		}
		else if(hasSubString(lDiag,almost4)) {
		    int missingSlot = lDiag.indexOf(almost4) + 3;
		    System.out.println(missingSlot);
		    if (underLDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		    else return super.pick_column(w, p);
		}
	    }
	}
	return super.pick_column(w, p);
    }
}
	
