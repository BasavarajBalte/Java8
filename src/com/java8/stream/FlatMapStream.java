package com.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapStream {
	public static void main(String[] args) throws IOException {
		Path people = Paths.get("people.txt");
		Path general = Paths.get("general.txt");

		Stream<String> peopleStream = Files.lines(people);
		Stream<String> generalStream = Files.lines(general);
		
		Stream<Stream<String>> stream =  Stream.of(peopleStream,generalStream);
		Stream<String> flatStream = stream.flatMap(Function.identity());
		//flatStream.forEach(System.out::println);
		
		//build stream of word using stream of line
		Function<String, Stream<String>> splitInWord = lines -> Stream.of(lines.split(" "));
		flatStream.flatMap(splitInWord)
		.filter(word -> word.length() > 4)
		.map(word -> word.toLowerCase())
		.distinct()
		.forEach(System.out::println);
		
	} 
}


