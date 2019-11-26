//Chentao Zhou 2457388
public class Test1 {

	   public static void main(String[] args) {
//		   Player p1 = new Player( "Clive" , 'x' );
//	  	   Counter c = new Counter(p1);
//	  	   System.out.println(c.getPlayer().toString() + ", " + c.toString());
//		   Column col = new Column( 4 );
//		   for ( int i= 0 ;i<5 ;i++) {
//		   Boolean result = col.add( new Counter(p1));
//		   System.out.println(result);
//		   }
//		   Column col = new Column( 6 );
//		   Player p1 = new Player( "Clive" , 'o' );
//		   Player p2 = new Player( "Sharon" , 'x' );
//		   for ( int i= 0 ;i< 3 ;i++) {
//		   col.add( new Counter(p1));
//		   col.add( new Counter(p2));
//		   }
//		   col.display();
		   Board board = new Board( 6 , 7 );
		   Player p1 = new Player( "Clive" , 'o' );
		   Player p2 = new Player( "Sharon" , 'x' );
		   board.add( new Counter(p2), 6 );
		   board.add( new Counter(p2), 3 );
		   board.add( new Counter(p2), 4 );
		   board.add( new Counter(p1), 4 );
		   board.add( new Counter(p2), 5 );
		   board.add( new Counter(p1), 5 );
		   board.add( new Counter(p2), 6 );
		   board.add( new Counter(p1), 5 );
		   board.add( new Counter(p2), 6 );
		   board.add( new Counter(p1), 6 );
		  // System.out.println(board.getWinner(board.getCols()[6].getCounters(), 4) + " wins");
		   System.out.println(board);
		  board.checkWinner();
	   }

}
