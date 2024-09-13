package java8program;


import java.util.Scanner;

public class Weekday {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);     
        System.out.print("Enter the Day  number: ");
        int day = sc.nextInt();
        String weekday = getWeekday(day);
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
