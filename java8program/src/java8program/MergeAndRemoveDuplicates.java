package java8program;

import java.util.*;
import java.util.stream.*;

public class MergeAndRemoveDuplicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.println("Enter the elements of the first array separated by space:");
        List<Integer> firstArray = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)  
                .collect(Collectors.toList());
 
        System.out.println("Enter the elements of the second array separated by space:");
        List<Integer> secondArray = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)  
                .collect(Collectors.toList());
 
        List<Integer> mergedAndSortedArray = Stream.concat(firstArray.stream(), secondArray.stream()) 
                .distinct()  
                .sorted() 
                .collect(Collectors.toList());  
 
        System.out.println("Merged and sorted array without duplicates: " + mergedAndSortedArray);
 
        sc.close();

	}

}
