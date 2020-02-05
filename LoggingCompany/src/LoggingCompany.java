import java.util.Scanner;


public class LoggingCompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final double MAX_WEIGHT = 1100; // Max weight the truck can carry, in kilograms
		final double WEIGHT_PER_METER = 20; // Weight of maple wood per meter, in kilograms
		
		final String banner = 
				" _                       _       _            _ _   _       _                             \r\n" + 
				"| |                     (_)     ( )          (_) | | |     | |                            \r\n" + 
				"| |     ___   __ _  __ _ _ _ __ |/  __      ___| |_| |__   | |     ___   __ _  __ _ _ __  \r\n" + 
				"| |    / _ \\ / _` |/ _` | | '_ \\    \\ \\ /\\ / / | __| '_ \\  | |    / _ \\ / _` |/ _` | '_ \\ \r\n" + 
				"| |___| (_) | (_| | (_| | | | | |    \\ V  V /| | |_| | | | | |___| (_) | (_| | (_| | | | |\r\n" + 
				"\\_____/\\___/ \\__, |\\__, |_|_| |_|     \\_/\\_/ |_|\\__|_| |_| \\_____/\\___/ \\__, |\\__,_|_| |_|\r\n" + 
				"              __/ | __/ |                                                __/ |            \r\n" + 
				"             |___/ |___/                                                |___/             ";
		
		Scanner input = new Scanner(System.in);
		double logSize;
		
		System.out.println(banner);
		
		while (true) {
			
			System.out.print("What is the size of Log that you have? (0.25 , 0.5, 1): ");
			
			if (input.hasNextDouble()) {
				logSize = input.nextDouble();
				
				if (logSize == 0.25 | logSize == 0.5 | logSize == 1.0) {
					break;
				}
				else {
					System.out.println("Fail!");
				}
			}
			else {
				System.out.println("Bad data.");
			}
				
			
			
			
		}
		
		//Math time
		double weight_per_log = WEIGHT_PER_METER * logSize;
		double number_of_logs = MAX_WEIGHT / weight_per_log;
		
		System.out.printf("You can fit %.0f logs on your truck!", number_of_logs);
		
	}

}
