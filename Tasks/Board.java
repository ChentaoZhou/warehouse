//Chentao Zhou 2457388
public class Board {
	Column[] cols;
	int columns;
	int rows;
	int zCounters = 4;		// The number decides how many counters will Win.
	
	//constructor
	public Board(int rows, int columns) {
		this.columns = columns;
		this.rows = rows;
		cols = new Column[columns];
		for(int i=0;i<columns;i++) {
			cols[i]=new Column(rows);
		}
		
	}
	
	public Column[] getCols() {
		return cols;
	}
	
	//The Big Check method contains three winning situations(horizontal, vertical, and diagonal)
	public boolean checkWinner() {
		if(verticalCheck()) {				//Check the vertical situation first, then horizontal , finally diagonal.
			return true;
		}
		if(horizontalCheck()) {
			return true;
		}
		if(diagonalCheck()) {
			return true;
		}

		return false;
		
	}
	
    //The verticalCheck: Check if any Column contains a winning situation. like "|" chart.
	public boolean verticalCheck() {
		int columnSize = cols.length;
		for(int i=0;i<columnSize;i++) {								//Put each column into a Counter[] array and call getWinner() method to check
			Counter[] eachCounters = new Counter[rows];				//Such as the Column[0]Counter[0] to Column[0]Counter[5]
			
			eachCounters = cols[i].getCounters();
			Player winner = getWinner(eachCounters, zCounters);		//Check if there are zCounters(4 here) numbers counter in a line to get the wining situation
			if(winner==null) {	continue; }
			else {
				System.out.println("We have a Winner!!!");
				System.err.println("Vertical Win!!! "+winner);
				return true;
			}
		}	
		return false;
	}
	
	//the HorizontalCheck: Check if any Z counters in a horizontal line. like "----" chart.
	public boolean horizontalCheck() {
		for(int i=0;i<rows;i++) {
			Counter[] eachCounters = new Counter[columns];			//put the Counters which locate in horizontal line in to a new Counter[] array
			for(int j=0;j<columns;j++) {							//Such as the Column[0]Counter[0] to Column[6]Counter[0]
				eachCounters[j] = cols[j].getCounters()[i];
			}
			Player winner = getWinner(eachCounters, zCounters);
			if(winner==null) {	continue; }
			else {
				System.out.println("We have a Winner!!!");
				System.err.println("Horizontal Win!!! "+winner);
				return true;
			}
		}
		return false;
	}
	
	
	//Check if a diagonal line for Z Counters in a row. It can be divided into four parts according to the variation of the figure
	//The most complex Check in this task.
	public boolean diagonalCheck() {
		/*
		 * Check if there is a wining situation like "/" chart. 
		 * First part: Length increases part
		 */		
		for(int k=0;k<rows-zCounters+1;k++) {						//k represent the number of check time in this part.
		    Counter[] eachCounters = new Counter[columns];			//Generate a new Counter[] array to carry the examined Counters 
		    int calculater = 0;										//The counter of the new Counter[] Array
		    int j = zCounters-1+k;									//j is the location of each Counter in its Column, i is the location of Column in a board
		    for(int i=0;i<zCounters+k;i++) {						//A loop to put the Counters which locate in diagonal line in to a new Counter[] array
			   eachCounters[calculater] = cols[i].getCounters()[j];	//Such as the Column[0]Counter[3] to Column[3]Counter[0]
			   calculater++;										
			   j--;	
		    }   
		    Player winner = getWinner(eachCounters, zCounters);		//Check the new Counter[]
		    if(winner==null) {	continue; }
		    else {
			System.out.println("We have a Winner!!!");
			System.err.println("Diagonal Win!!! "+winner);
			return true;
		    }
		 }
		
		//Second part: Length decreases part
		for(int k=0;k<columns-zCounters;k++) {
			Counter[] eachCounters = new Counter[columns];
			int calculater = 0;
			int j = rows-1;
			for(int i=1+k; i<columns;i++) {
				
				eachCounters[calculater] = cols[i].getCounters()[j];	//Such as the Column[2]Counter[5] to Column[6]Counter[1]
				calculater++;
				j--;
			}	 
			  Player winner = getWinner(eachCounters, zCounters);		//Check the new Counter[]
			    if(winner==null) {	continue; }
			    else {
				System.out.println("We have a Winner!!!");
				System.err.println("Diagonal Win!!! "+winner);
				return true;
			    }
		}
		
		//Check if there is a wining situation like "\" chart.
		//Third part:Length increases part
		for(int k=0; k<rows-zCounters+1;k++) {
			Counter[] eachCounters = new Counter[columns];
			int calculater = 0;
			int j = rows-zCounters-k;
			for(int i=0;i<zCounters+k;i++) {
				
				eachCounters[calculater] = cols[i].getCounters()[j];	//Such as the Column[0]Counter[2] to Column[3]Counter[5]
				calculater++;
				j++;
			}	 
			 Player winner = getWinner(eachCounters, zCounters);		//Check the new Counter[]
			    if(winner==null) {	continue; }
			    else {
				System.out.println("We have a Winner!!!");
				System.err.println("Diagonal Win!!! "+winner);
				return true;
			    }
		}
		
		//Fourth part: Length decreases part
		for(int k=0;k<columns-zCounters;k++) {
			Counter[] eachCounters = new Counter[columns];
			int calculater = 0;
			int j=0;
			for(int i =1+k;i<columns;i++) {
				
				eachCounters[calculater] = cols[i].getCounters()[j];	//Such as the Column[2]Counter[0] to Column[6]Counter[4]
				calculater++;
				j++;
			}		
			 Player winner = getWinner(eachCounters, zCounters);		//Check the new Counter[]
			    if(winner==null) {	continue; }
			    else {
				System.out.println("We have a Winner!!!");
				System.err.println("Diagonal Win!!! "+winner);
				return true;
			    }
		}	
		return false;
	}

	/*
	 * This is the core method to check if a array have Z counters in a row. The
	 * input are Counter[] Array and the number Z. In different situation(either
	 * horizontal, vertical, or diagonal), counters in a straight line will put into
	 * a new Counter[] and use this method to check
	 */	
	public Player getWinner(Counter[] c, int z) {
		for(int i= 0;i<c.length-(z-1);i++) {               // This is the number of check time that a container should have
			boolean flag = true;                             // A mark that check if there is a winner
			for(int j=1;j<=z-1;j++) {                     // To check if the Z counters have the same symbol				
				if(c[i]!=null && c[i+j]!=null) {
					flag = c[i].equals(c[i+j]);      //Check whether the following Z-1 counters are same to the first one.
				}else {flag=false;}                           
				if(!flag) {break;}                           //if there is a different symbol, check following 4 counters.
			}
			if(flag) {                                       // got the winner, return the Player object
				return c[i].getPlayer();                   
			}
		}
		return null;
	}
	
	

	public boolean add(Counter n, int columnNum ) {
		boolean result = cols[columnNum].add(n);
		return result;
	}

	public boolean isFull() {
		for(int i=0;i<columns;i++) {
			if(cols[i].isFull()) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	
	/*
	 * Contains a String in this method, when toString method is called, the whole
	 * board will be put into this String, and in Main() method Can print this Whole
	 * Board out.
	 */
	public String toString() {
		    String thisBoard = "|";
		for(int i=0;i<cols.length;i++) {	
			thisBoard+=i+"|";
		}
		    thisBoard+="\n";
		    for(int i = 0; i < columns; i++) thisBoard+="--";
		    thisBoard+="\n";
		    
		 for(int i=0;i<rows;i++) {
			 thisBoard+="|";
			 for(int j=0;j<columns;j++) {
				 thisBoard+=(cols[j].displayRow(i)+"|");
			 }
			 thisBoard+="\n";
		 }	
		return thisBoard;
	}
	
	
}
