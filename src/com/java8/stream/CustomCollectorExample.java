package com.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;

import com.java8.Person;

public class CustomCollectorExample {
	public static void main(String[] args) {

		List<Person> personList = new ArrayList<>();
		personList.add(new Person(30, "a", "BB"));
		personList.add(new Person(33, "b", "BK"));
		personList.add(new Person(40, "c", "BC"));
		personList.add(new Person(45, "d", "BD"));
		personList.add(new Person(65, "e", "BG"));
		personList.add(new Person(50, "f", "BH"));

		Supplier<List<Person>> supplier = () -> new ArrayList();

		// array list add new person instance to list is accumator step

		BiConsumer<Person, List<Person>> accumulator = (p, list) -> list.add(p);
		
		//BiConsumer<String, List<String>> accumulator = (p, list) -> list.add(p);

		// merging partila field arraylist
		// combine step

		BinaryOperator<List<Person>> combiner = (list1, list2) -> {
			list1.addAll(list2);
			return list1;
		};

		
		/*
		 * BinaryOperator<List<String>> combiner = (list1, list2) -> {
		 * list1.addAll(list2); return list1; };
		 */

		// Collector.Characteristics.IDENTITY_FINISH
		// Collector.Characteristics.CONCURRENT //parallel execution
		// Collector.Characteristics.UNORDERED //order not consider
		List<Person> list  = personList.stream().collect(
				// Collectors.groupingBy(Person::getName,
//				Collectors.mapping(Person::getName, Collectors.toList());
				Collectors.groupingBy(Person::getName,
						Collector.of(new ArrayList<Person>()
								, accumulator
,								combiner, 
								Collector.Characteristics.IDENTITY_FINISH)));
				/*Collector.of(() -> new ArrayList<Person>(), accumulator, combiner,
						Collector.Characteristics.IDENTITY_FINISH));*/
		// );
		// Collector collector = Collector.of(supplier,accumulator, combiner,
		// Collector.Characteristics.IDENTITY_FINISH);
	}
}
