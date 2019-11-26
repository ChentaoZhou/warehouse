//Chentao Zhou 2457388
public class Column {

	private int numRows;
	Counter[] counters;
	int numCounter = 0;
	
	//getter and setter
	public Counter[] getCounters() {
		return counters;
	}

	public int getNumRows() {
		return numRows;
	}
	public int getTheNum() {
		return counters.length;
	}
	
	
	//constructor
	public Column(int numRows) {
		this.numRows = numRows;
		counters = new Counter[numRows];
	}

	//identify whether the column is full or not
	public boolean isFull() {
		if(counters[0]!=null) {
			return true;
		}
		return false;
	}

	//method for adding symbol
	public boolean add(Counter counter) {
		if(isFull()) {
			return false;
		}
		counters[numRows-1-numCounter]= counter;
		numCounter++;
		return true;
	}
	//Display the symbol of this position Counter
	public String displayRow(int n) {
		if(counters[n] instanceof Counter) {
		return counters[n].toString();
		}
		return " ";
	}
	//Display Symbols of Counters in a Column
	public void display() {
		for(int i=1;i<=numRows;i++) {
			System.out.println(displayRow(i));
		}
	}
	
}
