package java8program;

import java.util.*;
import java.util.stream.Collectors;

public class SecondSmallestLargest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the list of integers separated by space:");
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());
        Optional<Integer> secondSmallest = numbers.stream()
                                                  .distinct()  
                                                  .sorted()    
                                                  .skip(1)     
                                                  .findFirst(); 
        Optional<Integer> secondLargest = numbers.stream()
                                                 .distinct()  
                                                 .sorted(Comparator.reverseOrder())  
                                                 .skip(1)     
                                                 .findFirst(); 
        secondSmallest.ifPresentOrElse(
            value -> System.out.println("Second smallest element: " + value),
            () -> System.out.println("Not enough elements for second smallest.")
        );
        secondLargest.ifPresentOrElse(
            value -> System.out.println("Second largest element: " + value),
            () -> System.out.println("Not enough elements for second largest.")
        );
        sc.close();
	}

}
