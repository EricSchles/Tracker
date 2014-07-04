
public class Testing {
	public static void main(String[] args){
		//empty for now, fill in tracker classes here
		String x = "balh,waah,daah";
		String[] arr = x.split(",");
		for (String i : arr){
			System.out.print(i+" ");
		}
		String thing = "thing;";
		thing = thing.replace(";","");
		System.out.println(thing);
		
		thing = "blah";
		System.out.println(thing.contains("h"));
		TimeCounter clock = new TimeCounter();
		clock.addTime("5:26::72");
		String total = clock.totalTime();
		System.out.println(total);
	}
}
