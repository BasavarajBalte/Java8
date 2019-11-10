package com.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.java8.Person;

public class CollectorsExample {
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(30, "a", "BB"));
		personList.add(new Person(33, "b", "BK"));
		personList.add(new Person(40, "c", "BC"));
		personList.add(new Person(45, "d", "BD"));
		personList.add(new Person(65, "e", "BG"));
		personList.add(new Person(50, "f", "BH"));

		Optional<Person> oldest = personList.stream().collect(Collectors.maxBy(Comparator.comparing(p -> p.getAge())));
		System.out.println(oldest.toString());

		double average = personList.stream().collect(Collectors.averagingDouble(p -> p.getAge()));

		System.out.println(average);

		String name = personList.stream().map(p -> p.getName()).collect(Collectors.joining(","));
		System.out.println(name);

		Set<String> names = personList.stream().map(p -> p.getName()).collect(Collectors.toSet());
		System.out.println(names);

		TreeSet<String> namesObj = personList.stream().map(p -> p.getName())
				.collect(Collectors.toCollection(() -> new TreeSet()));
		System.out.println(namesObj);

		Map<Boolean, List<Person>> pepoleByAge = personList.stream()
				.collect(Collectors.partitioningBy(p -> p.getAge() > 30));
		System.out.println(pepoleByAge);

		Map<Integer, List<Person>> pepoleAvrg = personList.stream().collect(Collectors.groupingBy(p -> p.getAge()));
		System.out.println(pepoleAvrg);

		/*
		 * Map<Integer, Long> peopleByAge = personList.stream().collect(
		 * Collectors.groupingBy(p -> p.getAge()), Collectors.counting() );
		 */
		
		Map<Integer,List<String>> namesByAge = personList.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
		System.out.println(namesByAge);

	}

}
