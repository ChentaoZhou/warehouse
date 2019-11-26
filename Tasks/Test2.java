//Chentao Zhou 2457388

import java.util.Random;
public class Test2 {
	

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
		while(true) {
			
			firstP=true;
		    secondP=true;
		    
			while(firstP) {
			  firstNum=r.nextInt(7);
			     if(board.add( new Counter(p2), firstNum )) {
				     firstP=false;
			     }
			}
			System.out.println(board);
			// To check if there is a winner.
			if(board.checkWinner()) {			
				System.out.println(board);
				return;}		
			
			while(secondP) {
			  secondNum=r.nextInt(7);
			   if(board.add( new Counter(p1), secondNum )) {
				secondP=false;
			   }
		    }
			System.out.println(board);
			// To check if there is a winner.
			if(board.checkWinner()) {
				System.out.println(board);
				return;}		
			
			if(board.isFull()) {
				break;
			}
		}
		System.out.println(board);
		System.out.println("There is no Winner... Pity");
	}
	
}
