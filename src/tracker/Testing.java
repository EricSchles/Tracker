package tracker;

public class Testing {
	public static void main(String[] args){
		//empty for now, fill in tracker classes here
		/*String x = "wurp:weee:blah";
		String[] arr = x.split(":");
		for (String i : arr){
			System.out.print(i+" ");
		}
		String thing = "thing;";
		thing = thing.replace(";","");
		System.out.println(thing);
		int stuff = 80/60;
		System.out.println(stuff);
		thing = "blah";
		System.out.println(thing.contains("h"));
		TimeCounter clock = new TimeCounter();
		clock.addTime("52:126:102372");
		String total = clock.totalTime();
		System.out.println(total);
		
		
		BasketballStats bulls = new BasketballStats();
		bulls.shoot(2, true);
		bulls.shoot(3, false);
		bulls.shoot(3, false);
		bulls.shoot(3, true);
		bulls.shoot(3, false);
		
		bulls.statistics();
		*/
		//int thing[][] = {{1,2},{3,4},{5,6}};
		TicTacToe game = new TicTacToe();
		game.chooseSides();
		game.chooseOpponent();
		game.printBoard();
		game.playMove(1, "0,0");
		game.printBoard();
		game.playMove(2, "1,0");
		game.printBoard();
		game.playMove(1, "1,1");
		game.printBoard();
		game.playMove(2, "1,2");
		game.printBoard();
		game.playMove(1, "2,2");
		game.printBoard();
	}
	
}
