
public class TimeCounter {

	//total number of hours, minutes and seconds.
	//format - hours:minutes::seconds
	private int hours;
	private int minutes;
	private int seconds;
	//The above format is how the user is expected to input the numbers.
	
	TimeCounter(){
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
	}
	
	public boolean addTime(String value){
		
		if(value.contains(":") && value.contains("::")){
			String[] values = value.split(":");
			values[1] = values[1].replace(":","");
			values[2] = values[2].replace(":","");
			this.hours += Integer.parseInt(values[0]);
			this.minutes += Integer.parseInt(values[1]);
			this.seconds += Integer.parseInt(values[2]); 
			return true;
		}else{
			return false;
		}
	}
	
	public String totalTime(){
		String hours = String.valueOf(this.hours);
		String minutes = String.valueOf(this.minutes);
		String seconds = String.valueOf(this.seconds);
		String total = hours + ":" + minutes + "::" + seconds;
		return total;
	}
	
}
