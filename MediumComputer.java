public class MediumComputer extends EasyComputer {

    //default constructor for MediumComputer
    public MediumComputer(){
	name = "MediumComputer";
	token_name = 'M';
    }

    //overloaded constructor for MediumComputer that takes userName and tokenName input
    public MediumComputer(String userName, char tokenName){
	name = userName;
	token_name = tokenName;
    }

    public int[] randomizeArray(int[] array){
	for (int i=0; i<array.length; i++) {
	    int randomPosition = (int) (Math.random() * array.length);
	    int temp = array[i];
	    array[i] = array[randomPosition];
	    array[randomPosition] = temp;
	}
	return array;
    }

    //stragecially decides where to defensively place a token
    //checks for a possible vertical win to block    
    public int defense(Woo w, Player p) {
	String almost1 = "_" + String.valueOf(p.token_name) + String.valueOf(p.token_name) + String.valueOf(p.token_name); //_***
	for (int x = 0; x < w.numColumns;x++) {
	    String Col = getColumnString(w,x);
	    if (hasSubString(Col, almost1)) {
		return x;
	    }
	}
	return -1;
    }

    //stragecially decides where to offensively place a token
    //horizontal offense, then vertical offense
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

    //first checks for vertical defense, then horizontal offense, then vertical offense
    public int pick_column(Woo w, Player p) {
	int choice = defense(w, p); //vertical defense
	if (choice == -1) choice = offense(w, p); //horizontal offense, vertical offense
	if (choice == -1) choice = super.pick_column(w, p); //no other option
	return choice;
    }
}
