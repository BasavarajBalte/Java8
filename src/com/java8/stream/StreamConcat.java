package com.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.java8.Person;

public class StreamConcat {
	public static void main(String[] args) throws IOException {
		Path people = Paths.get("people.txt");
		Path general = Paths.get("general.txt");

		Stream<String> peopleStream = Files.lines(people);
		Stream<String> generalStream = Files.lines(general);
		

		//Stream<String> concatStream = Stream.concat(peopleStream, generalStream);

		// more stream concat

		Stream<String> concatStreamMoreThenTwo = Stream.concat(Stream.concat(peopleStream, generalStream),
				Stream.of(new String("test Concat")));

		//concatStream.forEach(System.out::println);
		concatStreamMoreThenTwo.forEach(System.out::println);

	}
}
