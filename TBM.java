public class TBM extends HardComputer {

    //default constructor for TBM
    public TBM(){
	name = "TBM";
	token_name = 'T';
    }

    //overloaded constructor for TBM that takes userName and tokenName input
    public TBM(String userName, char tokenName){
	name = userName;
	token_name = tokenName;
    }
    
    //stragecially decides where to defensively place a token
    //checks for a possible diagonal win to block    
    public int defense(Woo w, Player p) {
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
		}
		if (hasSubString(rDiag,almost2)) {
		    int missingSlot = rDiag.indexOf(almost2) + 1;
		    if (underRDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
		if (hasSubString(rDiag,almost3)) {
		    int missingSlot = rDiag.indexOf(almost3) + 2;
		    if (underRDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
		if(hasSubString(rDiag,almost4)) {
		    int missingSlot = rDiag.indexOf(almost4) + 3;
		    if (underRDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
		if(hasSubString(lDiag,almost1)) {
		    int missingSlot = lDiag.indexOf(almost1);
		    if (underLDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
		if (hasSubString(lDiag,almost2)) {
		    int missingSlot = lDiag.indexOf(almost2) + 1;
		    if (underLDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
		if (hasSubString(lDiag,almost3)) {
		    int missingSlot = lDiag.indexOf(almost3) + 2;
		    if (underLDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
		if(hasSubString(lDiag,almost4)) {
		    int missingSlot = lDiag.indexOf(almost4) + 3;
		    if (underLDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }
	}
	return -1;
    }

    //stragecially decides where to defensively place a token
    //inherits horizontal defense from HardComputer
    public int secondaryDefense(Woo w, Player p) {
	return super.defense(w,p);
    }

    //stragecially decides where to offensively place a token
    //diagonal offense, horizontal, vertical
    public int offense(Woo w, Player p) {
	String poss1 = "_" + String.valueOf(token_name) + String.valueOf(token_name) + String.valueOf(token_name); //_***
	String poss2 = String.valueOf(token_name) + "_" + String.valueOf(token_name) + String.valueOf(token_name); //*_**
	String poss3 = String.valueOf(token_name) + String.valueOf(token_name) + "_" + String.valueOf(token_name); //**_*
	String poss4 = String.valueOf(token_name) + String.valueOf(token_name) + String.valueOf(token_name) + "_"; //***_
	String poss5 = "_" + "_" + String.valueOf(token_name) + String.valueOf(token_name);  //__**
	String poss6 = "_" + String.valueOf(token_name) + "_" + String.valueOf(token_name);  //_*_*
	String poss7 = "_" + String.valueOf(token_name) + String.valueOf(token_name) + "_";  //_**_
	String poss8 = String.valueOf(token_name) + "_" + "_" + String.valueOf(token_name);  //*__*
	String poss9 = String.valueOf(token_name) + "_" + String.valueOf(token_name) + "_";  //*_*_
	String poss10 = String.valueOf(token_name) + String.valueOf(token_name) + "_" + "_"; //**__
	String poss11 = "_" + "_" + "_" + String.valueOf(token_name); //___*
	String poss12 = "_" + "_" + String.valueOf(token_name) + "_"; //__*_
	String poss13 = "_" + String.valueOf(token_name) + "_" + "_"; //_*__
	String poss14 = String.valueOf(token_name) + "_" + "_" + "_"; //*___
	for (int x = w.numColumns; x > 0;x--) {
	    for (int y = w.numRows; y > 0;y--) {
		String rDiag = p.getRightDiagonalString(w,x,y);
		String underRDiag = p.getRightDiagonalString(w,x,y+1);
		//RIGHT DIAGONAL
		if(hasSubString(rDiag,poss1)) {
		    int missingSlot = rDiag.indexOf(poss1);
		    if (underRDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
		if(hasSubString(rDiag,poss2)) {
		    int missingSlot = rDiag.indexOf(poss2) + 1;
		    if (underRDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
		if(hasSubString(rDiag,poss3)) {
		    int missingSlot = rDiag.indexOf(poss3) + 2;
		    if (underRDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
		if(hasSubString(rDiag,poss4)) {
		    int missingSlot = rDiag.indexOf(poss4) + 3;
		    if (underRDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }
	}
	for (int x = w.numColumns; x > 0;x--) {
	    for (int y = w.numRows; y > 0;y--) {
		String lDiag = p.getLeftDiagonalString(w,x,y);
		String underLDiag = p.getLeftDiagonalString(w,x,y-1);
		//LEFT DIAGONAL
		if(hasSubString(lDiag,poss1)) {
		    int missingSlot = lDiag.indexOf(poss1);
		    if (underLDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
		if(hasSubString(lDiag,poss2)) {
		    int missingSlot = lDiag.indexOf(poss2) + 1;
		    if (underLDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
		if(hasSubString(lDiag,poss3)) {
		    int missingSlot = lDiag.indexOf(poss3) + 2;
		    if (underLDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
		if(hasSubString(lDiag,poss4)) {
		    int missingSlot = lDiag.indexOf(poss4) + 3;
		    if (underLDiag.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }
	}
	for (int x = w.numRows; x > 0; x--) {
	    String Row = p.getRowString(w,x);
	    String underRow = p.getRowString(w,x+1);
	    if(hasSubString(Row,poss1)) {
		int missingSlot = Row.indexOf(poss1);
		if (underRow.charAt(missingSlot) != '_') {
		    return missingSlot;
		}
	    }
	    if(hasSubString(Row,poss2)) {
		int missingSlot = Row.indexOf(poss2) + 1;
		if (underRow.charAt(missingSlot) != '_') {
		    return missingSlot;
		}
	    }
	    if(hasSubString(Row,poss3)) {
		int missingSlot = Row.indexOf(poss3) + 2;
		if (underRow.charAt(missingSlot) != '_') {
		    return missingSlot;
		}
	    }
	    if(hasSubString(Row,poss4)) {
		int missingSlot = Row.indexOf(poss4) + 3;
		if (underRow.charAt(missingSlot) != '_') {
		    return missingSlot;
		}
	    }
	}
	for (int x = 0; x < w.numColumns;x++) {
	    String Col = getColumnString(w,x);
	    if (hasSubString(Col, poss1)) {
		return x;
	    }
	}
	for (int x = w.numColumns; x > 0;x--) {
	    for (int y = w.numRows; y > 0;y--) {
		String rDiag = p.getRightDiagonalString(w,x,y);
		String underRDiag = p.getRightDiagonalString(w,x,y+1);
		//RIGHT DIAGONAL
		if(hasSubString(rDiag,poss5)) {
		    int[] missingSlots = new int[2];
		    missingSlots[0] = rDiag.indexOf(poss5);
		    missingSlots[1] = rDiag.indexOf(poss5) + 1;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underRDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(rDiag,poss6)) {
		    int[] missingSlots = new int[2];
		    missingSlots[0] = rDiag.indexOf(poss6);
		    missingSlots[1] = rDiag.indexOf(poss6) + 2;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underRDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(rDiag,poss7)) {
		    int[] missingSlots = new int[2];
		    missingSlots[0] = rDiag.indexOf(poss7);
		    missingSlots[1] = rDiag.indexOf(poss7) + 3;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underRDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(rDiag,poss8)) {
		    int[] missingSlots = new int[2];
		    missingSlots[0] = rDiag.indexOf(poss8) + 1;
		    missingSlots[1] = rDiag.indexOf(poss8) + 2;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underRDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(rDiag,poss9)) {
		    int[] missingSlots = new int[2];
		    missingSlots[0] = rDiag.indexOf(poss9) + 1;
		    missingSlots[1] = rDiag.indexOf(poss9) + 3;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underRDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(rDiag,poss10)) {
		    int[] missingSlots = new int[2];
		    missingSlots[0] = rDiag.indexOf(poss10) + 2;
		    missingSlots[1] = rDiag.indexOf(poss10) + 3;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underRDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}	    
	    }
	}
	for (int x = w.numColumns; x > 0;x--) {
	    for (int y = w.numRows; y > 0;y--) {
		String lDiag = p.getLeftDiagonalString(w,x,y);
		String underLDiag = p.getLeftDiagonalString(w,x,y+1);
		//LEFT DIAGONAL
		if(hasSubString(lDiag,poss5)) {
		    int[] missingSlots = new int[2];
		    missingSlots[0] = lDiag.indexOf(poss5);
		    missingSlots[1] = lDiag.indexOf(poss5) + 1;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underLDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}		
		if(hasSubString(lDiag,poss6)) {
		    int[] missingSlots = new int[2];
		    missingSlots[0] = lDiag.indexOf(poss6);
		    missingSlots[1] = lDiag.indexOf(poss6) + 2;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underLDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(lDiag,poss7)) {
		    int[] missingSlots = new int[2];
		    missingSlots[0] = lDiag.indexOf(poss7);
		    missingSlots[1] = lDiag.indexOf(poss7) + 3;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underLDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(lDiag,poss8)) {
		    int[] missingSlots = new int[2];
		    missingSlots[0] = lDiag.indexOf(poss8) + 1;
		    missingSlots[1] = lDiag.indexOf(poss8) + 2;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underLDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(lDiag,poss9)) {
		    int[] missingSlots = new int[2];
		    missingSlots[0] = lDiag.indexOf(poss9) + 1;
		    missingSlots[1] = lDiag.indexOf(poss9) + 3;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underLDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(lDiag,poss10)) {
		    int[] missingSlots = new int[2];
		    missingSlots[0] = lDiag.indexOf(poss10) + 2;
		    missingSlots[1] = lDiag.indexOf(poss10) + 3;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underLDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}	    
	    }
	}
	for (int x = w.numRows; x > 0; x--) {
	    String Row = p.getRowString(w,x);
	    String underRow = p.getRowString(w,x+1);
	    if(hasSubString(Row,poss5)) {
		int[] missingSlots = new int[2];
		missingSlots[0] = Row.indexOf(poss5);
		missingSlots[1] = Row.indexOf(poss5) + 1;
		missingSlots = randomizeArray(missingSlots);
		for (int missingSlot : missingSlots) {
		    if (underRow.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }
	    if(hasSubString(Row,poss6)) {
		int[] missingSlots = new int[2];
		missingSlots[0] = Row.indexOf(poss6);
		missingSlots[1] = Row.indexOf(poss6) + 2;
		missingSlots = randomizeArray(missingSlots);
		for (int missingSlot : missingSlots) {
		    if (underRow.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }
	    if(hasSubString(Row,poss7)) {
		int[] missingSlots = new int[2];
		missingSlots[0] = Row.indexOf(poss7);
		missingSlots[1] = Row.indexOf(poss7) + 3;
		missingSlots = randomizeArray(missingSlots);
		for (int missingSlot : missingSlots) {
		    if (underRow.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }
	    if(hasSubString(Row,poss8)) {
		int[] missingSlots = new int[2];
		missingSlots[0] = Row.indexOf(poss8) + 1;
		missingSlots[1] = Row.indexOf(poss8) + 2;
		missingSlots = randomizeArray(missingSlots);
		for (int missingSlot : missingSlots) {
		    if (underRow.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }
	    if(hasSubString(Row,poss9)) {
		int[] missingSlots = new int[2];
		missingSlots[0] = Row.indexOf(poss9) + 1;
		missingSlots[1] = Row.indexOf(poss9) + 3;
		missingSlots = randomizeArray(missingSlots);
		for (int missingSlot : missingSlots) {
		    if (underRow.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }
	    if(hasSubString(Row,poss10)) {
		int[] missingSlots = new int[2];
		missingSlots[0] = Row.indexOf(poss10) + 2;
		missingSlots[1] = Row.indexOf(poss10) + 3;
		missingSlots = randomizeArray(missingSlots);
		for (int missingSlot : missingSlots) {
		    if (underRow.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }	    
	}
	for (int x = w.numColumns; x > 0;x--) {
	    for (int y = w.numRows; y > 0;y--) {
		String rDiag = p.getRightDiagonalString(w,x,y);
		String underRDiag = p.getRightDiagonalString(w,x,y+1);
		//RIGHT DIAGONAL
		if(hasSubString(rDiag,poss11)) {
		    int[] missingSlots = new int[3];
		    missingSlots[0] = rDiag.indexOf(poss11);
		    missingSlots[1] = rDiag.indexOf(poss11) + 1;
		    missingSlots[2] = rDiag.indexOf(poss11) + 2;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underRDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(rDiag,poss12)) {
		    int[] missingSlots = new int[3];
		    missingSlots[0] = rDiag.indexOf(poss12);
		    missingSlots[1] = rDiag.indexOf(poss12) + 1;
		    missingSlots[2] = rDiag.indexOf(poss12) + 3;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underRDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(rDiag,poss13)) {
		    int[] missingSlots = new int[3];
		    missingSlots[0] = rDiag.indexOf(poss13);
		    missingSlots[1] = rDiag.indexOf(poss13) + 2;
		    missingSlots[2] = rDiag.indexOf(poss13) + 3;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underRDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(rDiag,poss14)) {
		    int[] missingSlots = new int[3];
		    missingSlots[0] = rDiag.indexOf(poss14) + 1;
		    missingSlots[1] = rDiag.indexOf(poss14) + 2;
		    missingSlots[2] = rDiag.indexOf(poss14) + 3;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underRDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
	    }
	}
	for (int x = w.numColumns; x > 0;x--) {
	    for (int y = w.numRows; y > 0;y--) {
		String lDiag = p.getLeftDiagonalString(w,x,y);
		String underLDiag = p.getLeftDiagonalString(w,x,y+1);
		//LEFT DIAGONAL
		if(hasSubString(lDiag,poss11)) {
		    int[] missingSlots = new int[3];
		    missingSlots[0] = lDiag.indexOf(poss11);
		    missingSlots[1] = lDiag.indexOf(poss11) + 1;
		    missingSlots[2] = lDiag.indexOf(poss11) + 2;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underLDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(lDiag,poss12)) {
		    int[] missingSlots = new int[3];
		    missingSlots[0] = lDiag.indexOf(poss12);
		    missingSlots[1] = lDiag.indexOf(poss12) + 1;
		    missingSlots[2] = lDiag.indexOf(poss12) + 3;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underLDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(lDiag,poss13)) {
		    int[] missingSlots = new int[3];
		    missingSlots[0] = lDiag.indexOf(poss13);
		    missingSlots[1] = lDiag.indexOf(poss13) + 2;
		    missingSlots[2] = lDiag.indexOf(poss13) + 3;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underLDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}
		if(hasSubString(lDiag,poss14)) {
		    int[] missingSlots = new int[3];
		    missingSlots[0] = lDiag.indexOf(poss14) + 1;
		    missingSlots[1] = lDiag.indexOf(poss14) + 2;
		    missingSlots[2] = lDiag.indexOf(poss14) + 3;
		    missingSlots = randomizeArray(missingSlots);
		    for (int missingSlot : missingSlots) {
			if (underLDiag.charAt(missingSlot) != '_') {
			    return missingSlot;
			}
		    }
		}		
	    }
	}
	for (int x = w.numRows; x > 0; x--) {
	    String Row = p.getRowString(w,x);
	    String underRow = p.getRowString(w,x+1);
	    if(hasSubString(Row,poss11)) {
		int[] missingSlots = new int[3];
		missingSlots[0] = Row.indexOf(poss11);
		missingSlots[1] = Row.indexOf(poss11) + 1;
		missingSlots[2] = Row.indexOf(poss11) + 2;
		missingSlots = randomizeArray(missingSlots);
		for (int missingSlot : missingSlots) {
		    if (underRow.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }
	    if(hasSubString(Row,poss12)) {
		int[] missingSlots = new int[3];
		missingSlots[0] = Row.indexOf(poss12);
		missingSlots[1] = Row.indexOf(poss12) + 1;
		missingSlots[2] = Row.indexOf(poss12) + 3;
		missingSlots = randomizeArray(missingSlots);
		for (int missingSlot : missingSlots) {
		    if (underRow.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }
	    if(hasSubString(Row,poss13)) {
		int[] missingSlots = new int[3];
		missingSlots[0] = Row.indexOf(poss13);
		missingSlots[1] = Row.indexOf(poss13) + 2;
		missingSlots[2] = Row.indexOf(poss13) + 3;
		missingSlots = randomizeArray(missingSlots);
		for (int missingSlot : missingSlots) {
		    if (underRow.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }
	    if(hasSubString(Row,poss14)) {
		int[] missingSlots = new int[3];
		missingSlots[0] = Row.indexOf(poss14) + 1;
		missingSlots[1] = Row.indexOf(poss14) + 2;
		missingSlots[2] = Row.indexOf(poss14) + 3;
		missingSlots = randomizeArray(missingSlots);
		for (int missingSlot : missingSlots) {
		    if (underRow.charAt(missingSlot) != '_') {
			return missingSlot;
		    }
		}
	    }
	    
	}
	for (int x = 0; x < w.numColumns;x++) {
	    String Col = getColumnString(w,x);
	    if (hasSubString(Col, poss5) || hasSubString(Col, poss11)) {
		return x;
	    }
	}
	return -1;
    }
    
    //first checks for diagonal defense, then horizontal defense, then vertical defense, then diag offense, then horizontal offense, then vertical offense
    public int pick_column(Woo w, Player p) {
	int choice = defense(w, p); //diagonal defense
	if (choice == -1) choice = secondaryDefense(w, p); //horizontal defense
	if (choice == -1) choice = super.secondaryDefense(w, p); //vertical defense
	if (choice == -1) choice = offense(w, p); //diagonal offense, horizontal offense, vertical offense
	if (choice == -1) choice = super.pick_column(w, p); //no other option
	return choice;
    }
}
	
