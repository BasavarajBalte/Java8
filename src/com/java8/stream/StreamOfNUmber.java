package com.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.java8.Person;
import com.java8.PersonSpliterator;

public class StreamOfNUmber {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("people.txt");
		Stream<String> streamLines = Files.lines(path);
		Spliterator<String> spilteratorline = streamLines.spliterator();
		Spliterator<Person> personList = new PersonSpliterator(spilteratorline);

		Stream<Person> personStream = StreamSupport.stream(personList, false);
		//OptionalDouble avergeAge = personStream.map(p -> p.getAge()).filter(a -> a > 33).mapToInt(i -> i).average();
		//OptionalDouble avergeAge = personStream.mapToInt(p -> p.getAge()).filter(a -> a > 33).average();
		OptionalDouble avergeAge = personStream.mapToInt(Person::getAge).filter(a -> a > 33).average();
		System.out.println(avergeAge.getAsDouble());
		

	}
}
