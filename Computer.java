public class Computer extends Player {

    public Computer(){
	name = "Computer";
	token_name = 'C';
    }

    public int pick_column(Woo w) {
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
