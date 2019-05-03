package com.danielpm1982.JAVASE;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.stream.IntStream;

public class SecureRandomStreamGenerator {
	public static IntStream getSecureRandomIntStream(int inferiorLimit, int superiorLimit, int numberOfElements) {
		try {
			return SecureRandom.getInstanceStrong().ints(inferiorLimit,superiorLimit).limit(numberOfElements);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}

/*
This class has nothing to do with Threads, and is merely a helper class to generate a stream of random integers,
receiving at its static method the inferior and superior limits (the range interval used), as well as the number
of elements produced and returned at stream. The returned numbers are not unique. At this project, it's basically 
for showing some random view at the console and for each thread to have something to write through the custom 
Writer class. It could also have been done some complex operation here for delaying in part the thread execution 
time, instead of using the Thread sleep method.
*/
