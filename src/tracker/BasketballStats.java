package tracker;

public class BasketballStats {

	private int totalScore;
	private double SuccessfulPercentage;
	private int totalSuccessShots;
	private double totalShots;
	
	BasketballStats(){
		this.totalScore = 0;
		this.SuccessfulPercentage = 0.0;
		this.totalSuccessShots = 0;
		this.totalShots = 0.0;
	}
	
	public void shoot(int num_points,boolean successFail){
		if(successFail == true){
			this.totalScore += num_points;
			this.totalSuccessShots += 1;
		}
		this.totalShots += 1.0;
		
		this.SuccessfulPercentage = this.totalSuccessShots/this.totalShots;
	}
	
	public void statistics(){
		 
		System.out.println("The total score is "+ this.totalScore);
		System.out.println("The percentage of successful shots are "+ this.SuccessfulPercentage);
	}
	
}
