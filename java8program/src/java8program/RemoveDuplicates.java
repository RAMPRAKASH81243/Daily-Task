package java8program;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter elements separated by space: ");
		List<String> listWithDuplicates = Arrays.asList(sc.nextLine().split(" "));
		Set<String> seen = new HashSet<>();
		List<String> listWithoutDuplicates = listWithDuplicates.stream()
															   .filter(element -> seen.add(element))
															   .collect(Collectors.toList());
		System.out.println("List without Duplicates: " + listWithoutDuplicates);
		sc.close();
	}

}
