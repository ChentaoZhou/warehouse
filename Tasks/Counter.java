//Chentao Zhou 2457388
public class Counter {
 
	private Player player;
	
	//constructor
	public Counter(Player player) {
    	 this.player =player;
    	
    }
	    
    //getter for Player object
	public Player getPlayer() {
		return player;
	}
	public String toString() {
		String playerSymbol = String.valueOf(player.getSymbol());
		return playerSymbol;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Counter) {                  //Determine whether it is an Counter object
			Counter other = (Counter) o;            //Give a reference to use
			if((other.getPlayer()== player)) {
				return true;
			}	
		}
		return false;
	}
 


}
