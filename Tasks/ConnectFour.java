//Chentao Zhou 2457388

import java.util.Random;
public class ConnectFour {
	

	public static void main(String[] args) {
	    randomPlay();
    }	
	
	
	public static void randomPlay() {
		Board board = new Board( 6 , 7 );
		Player p1 = new Player( "Clive" , 'o' );
		Player p2 = new Player( "Sharon" , 'x' );
		Random r=new Random();
		int firstNum;
	    int secondNum;
	    boolean firstP=true;
	    boolean secondP=true;
	    //The automatic Counters putter
		while(true) {
			
			firstP=true;
		    secondP=true;
		    
			while(firstP) {										//The first player put the Counter, if success, change player
			  firstNum=r.nextInt(7);
			     if(board.add( new Counter(p2), firstNum )) {
				     firstP=false;
			     }
			}
			System.out.println(board);							//After each player put Counter, print the board so that we can see the situation 
			// To check if there is a winner.					  if there is something wrong, we can check the bug by this step board map.
			if(board.checkWinner()) {							//After each player put Counter, check if there is a winner, if so ,stop the loop and game over
				System.out.println(board);
				return;}	
			if(board.isFull()) {
				break;
			}
			
			while(secondP) {									//The second player put the Counter, if success, change player
			  secondNum=r.nextInt(7);
			   if(board.add( new Counter(p1), secondNum )) {
				secondP=false;
			   }
		    }
			System.out.println(board);							//After each player put Counter, print the board so that we can see the situation 
			// To check if there is a winner.
			if(board.checkWinner()) {
				System.out.println(board);
				return;}		
			
			if(board.isFull()) {								//if the board is full, game over
				break;
			}
		}
		System.out.println(board);
		System.out.println("There is no Winner... Pity");
	}
	
}
