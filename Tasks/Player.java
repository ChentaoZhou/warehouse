//Chentao Zhou 2457388
public class Player {
	//class variables
    private String name;
    private char symbol;
    
    //constructor
	public Player(String name, char symbol) {
		this.name= name;
		this.symbol=symbol;
	}
  
    //getters and setters
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public String toString(){
		return name;
		
	}
	
	
    

	
}
