package tracker;


public class TimeCounter {

	//total number of hours, minutes and seconds.
	//format - hours:minutes:seconds
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
		int minute_overflow = 0;
		int hour_overflow = 0;
		if(value.contains(":")){
			String[] values = value.split(":");
			values[1] = values[1].replace(":","");
			values[2] = values[2].replace(":","");
			int minutes = Integer.parseInt(values[1]);
			int seconds = Integer.parseInt(values[2]);
			this.hours += Integer.parseInt(values[0]);
			if ( seconds > 60) {
				minute_overflow = seconds/60;
				seconds = seconds%60;
			}
			minutes += minute_overflow;
			if ( minutes > 60){
				hour_overflow = minutes/60;
				minutes = minutes%60;
			}
			hours += hour_overflow;
			this.minutes += minutes;
			this.seconds += seconds; 
			return true;
		}else{
			return false;
		}
	}
	
	public String totalTime(){
		String hours = String.valueOf(this.hours);
		String minutes = String.valueOf(this.minutes);
		String seconds = String.valueOf(this.seconds);
		String total = hours + ":" + minutes + ":" + seconds;
		return total;
	}
	
}
