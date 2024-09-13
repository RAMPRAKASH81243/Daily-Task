package java8program;

import java.util.Random;
import java.util.Scanner;

public class WeekdayGenerator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter any number: ");
        int userInput = sc.nextInt();
        
        int dayNumber = random.nextInt(7) + 1; 
        
        String weekday = getWeekday(dayNumber);
        
        System.out.println("Generated number: " + dayNumber);
        System.out.println("Corresponding day: " + weekday);
        sc.close();
    }
 
    public static String getWeekday(int day) {
        switch(day) {
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
            case 7: return "Sunday";
            default: return "Invalid day";
        }

	}

}
