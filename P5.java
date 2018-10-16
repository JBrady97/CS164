import java.util.Scanner;

public class P5 {
	public static void main(String[] args) {
		// Preliminary testing
	    printPrimes(1, 50);
	    System.out.println(removeVowels("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
	    double result = evaluateExponent(2.0,16);
	    System.out.println("2.0 to the 16 = " + result);
	    computeStatistics(-1);
	}
	public static boolean isPrime(int number) {

	    // DO NOT CHANGE THIS CODE!
	    for(int i=2;i<=number/2;i++)
	        if(number%i==0)
	            return false;
	    return true;
	}

	// Method to print primes in a specified range
	public static void printPrimes(int start, int end) {
	    // add code here
		for (int i = start; i < end; i++) {
			if (isPrime(i)) {
				System.out.print(i + ", ");
			}
		}
	}

	// Method to remove vowels from a string
	public static String removeVowels(String input) {
	    // add code here
		String s = "";
		int f = 0;
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == 'a' | c == 'A' | c == 'e' | c == 'E' | c == 'i'| c == 'I' | c == 'o' | c == 'O'| c == 'u' | c == 'U') {
				f = 1;
			}
			else {
				s = s + c;
				f = 0;
			}
		}
		return s;
	}

	// Method to generate and print the value of a number raised to an exponent
	public static double evaluateExponent(double number, int exponent) {
	    // add code here
		double result = 1.0;
		int loop  = 1;
		do {
			result = result * number;
			loop++;
		} while (loop < exponent);
		return result;
	}

	// Method to find and print the minimum/maximum/mean of a set of positive numbers
	public static void computeStatistics(int sentinel) {
	    // add code here
		Scanner keyboard = new Scanner(System.in);
		int value = 0;
		int count = 0;
		double mean = 0.0;
		int minimum = Integer.MAX_VALUE;
		int maximum = Integer.MIN_VALUE;
		while (true) {
			value = keyboard.nextInt();
			
			if (value == -1) 
				break;
			else if (value < minimum)
				minimum = value;
			else if (value > maximum)
				maximum = value;
			
			mean = value + mean;
			count++;
			
		}
			mean = mean / count;
			System.out.println("Count: " + count);
			System.out.println("Average: "+ mean);
			System.out.println("Maximum: "+ maximum);
			System.out.println("Minimum: "+ minimum);
			
	}

}
