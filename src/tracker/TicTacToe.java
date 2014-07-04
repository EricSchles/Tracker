package tracker;

import java.util.Scanner;

class Board{
	protected boolean[][] isPlaced = {{false,false,false},{false,false,false},{false,false,false}};
	protected String[][] hasValue = {{" "," "," "},{" "," "," "},{" "," "," "}};
	
	Board(){
		this.isPlaced[0][0] = false;  
		this.isPlaced[0][1] = false;
		this.isPlaced[0][2] = false;
		this.isPlaced[1][0] = false;
		this.isPlaced[1][1] = false;
		this.isPlaced[1][2] = false;
		this.isPlaced[2][0] = false;
		this.isPlaced[2][1] = false;
		this.isPlaced[2][2] = false;
		
		this.hasValue[0][0] = " ";
		this.hasValue[0][1] = " ";
		this.hasValue[0][2] = " ";
		this.hasValue[1][0] = " ";
		this.hasValue[1][1] = " ";
		this.hasValue[1][2] = " ";
		this.hasValue[2][0] = " ";
		this.hasValue[2][1] = " ";
		this.hasValue[2][2] = " ";
	}
	
	public boolean playMove(String location,String value){
		String[] loc = location.split(",");
		int xLoc = Integer.parseInt(loc[0]);
		int yLoc = Integer.parseInt(loc[1]);
		
		if(xLoc >=0 && xLoc < 3){
			if(yLoc >= 0 && yLoc < 3){
				if(this.isPlaced[xLoc][yLoc] == false){
					this.hasValue[xLoc][yLoc] = value;
					this.isPlaced[xLoc][yLoc] = true;
				}else{
					System.out.println("Sorry!  This square isn't open");
					return false;
				}
			}
		}else{
			System.out.println("Sorry, there is no square in this range!");
			return false;
		}
		return true;
	}
	
	public String checkForWinner(){
		String result = "";
		for(int x= 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				//horizontal check 
				if( this.isPlaced[x][0] && this.isPlaced[x][1] && this.isPlaced[x][2]){
					if(this.hasValue[x][0] == this.hasValue[x][1] && this.hasValue[x][1] == this.hasValue[x][2]){
						result = this.hasValue[x][0];
						return result;
					}
				}
				//vertical check 
				if( this.isPlaced[0][y] && this.isPlaced[1][x] && this.isPlaced[2][x]){
					if(this.hasValue[0][x] == this.hasValue[1][x] && this.hasValue[1][x] == this.hasValue[2][x]){
						result = this.hasValue[0][x];
						return result;
					}
				}
				
				if( this.isPlaced[0][0] && this.isPlaced[1][1] && this.isPlaced[2][2]){
					if(this.hasValue[0][0] == this.hasValue[1][1] && this.hasValue[1][1] == this.hasValue[2][2]){
						result = this.hasValue[0][0];
						return result;
					}
				}
				
				if( this.isPlaced[0][2] && this.isPlaced[1][1] && this.isPlaced[2][0]){
					if(this.hasValue[0][2] == this.hasValue[1][1] && this.hasValue[1][1] == this.hasValue[2][0]){
						result = this.hasValue[0][2];
						return result;
					}
				}
			}
		}
		return result;
		
	}
	
	public void printBoard(){
		
		for(int x = 0; x < 3;x++){
			for(int y = 0; y < 3;y++){
				System.out.print(" "+this.hasValue[x][y]+" ");
				if( y == 2){
					System.out.println("");
				}
			}
		}
		
	}
	
}

public class TicTacToe {

	private Board playerBoard;
	private String player1;
	private String player2;
	private boolean winCondition;
	private int winner;
	private boolean computerPlayer;
	
	TicTacToe(){
		this.playerBoard = new Board();
		this.winCondition = false;
		this.computerPlayer = false;
	}
	
	//false means the player did not choose X or O, true means they did.
	public boolean chooseSides(){
		Scanner in = new Scanner(System.in);
		System.out.println("Player1 please choose whether you'd like to be X or O");
		this.player1 = in.nextLine();
		
		if( !this.player1.equals("X") && !this.player1.equals("O")){
			System.out.println("You must choose a valid token, X or O");
			in.close();
			return false;
		}else{
			if(this.player1.equals("X")){
				this.player2 = "O";
			}else{
				this.player2 ="X";
			}
		}
		in.close();
		return true;
	}
	
	public boolean chooseOpponent(){
		Scanner in = new Scanner(System.in);
		System.out.println("Player1 please choose whether you'd like to play against a human or computer");
		String choice = in.nextLine();
		
		if( !choice.equals("human") && !choice.equals("computer")){
			System.out.println("You must choose a valid choice, human or computer");
			in.close();
			return false;
		}else{
			if(choice.equals("computer")){
				this.computerPlayer = true;
			}else{
				this.computerPlayer = false;
			}
		}
		in.close();
		return true;
	}

	public boolean playMove(int player,String location){
		String value;
		
		if(player == 1){
			value = this.player1;
		}else if( player == 2){
			value = this.player2;
		}else{
			System.out.println("did not enter a valid player");
			return false;
		}
		playerBoard.playMove(location, value);
		String win = playerBoard.checkForWinner();
		if(win != ""){
			this.winCondition = true;
			if(win == this.player1){
				this.winner = 1;
			}else{
				this.winner = 2;
			}
		}
		if(this.winCondition == true){
			System.out.println("The game is over, player "+this.winner+" wins");
		}
		return true;
	}
	
	public void printBoard(){
		this.playerBoard.printBoard();
	}
	//To Do: Fix errors in play
}
