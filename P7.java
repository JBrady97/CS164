import java.util.Arrays;
public class P7 {
	
	public static int[] createIntegers() {
		int[] result = {16, 21, 34, 49, 55, 60, 72, 83, 101};
		return result;
	}
	public static double[] createDoubles() {
		double[] doubles = new double[7];
		int c = 0;
		for (double i = 10.0; i<= 13.0; i+=0.5) {
			doubles[c] = i*i;
			c++;
		}
		return doubles;
	}
	public static String[] createStrings(String s) {
		String[] result = new String[4];
		result[0] = s;
		result[1] = s.toUpperCase();
		result[2] = s.toLowerCase();
		result[3] = s.substring(0, 0) + s.substring(0 + 1);
		
		
		return result;
	}
	public static char[] createChars(String str) {
		char[] result = str.toCharArray();
		return result;
	}
	public static int sumArray(int[] result) {
		int sum = 0;
		for (int i: result) {
			sum += i;
		}
		return sum;
	}
	
	public static double findlargest(double[] result) {
		double largest = result[0];
		for (int i = 0; i < result.length; i++) {
			if (result[i] > largest) {
				largest = result[i];
			}
		}
		return largest;
	}
	public static int charFrequency(String[] result, char c) {
		int count = 0;
		for (int i = 0; i < result.length;i++) {
			String textValue = result[i];
			for (int j=0; j < textValue.length();j++) {
				if (textValue.charAt(j) == (c)) {
					count++;
				}
			}
		}
		return count;
	}
	public static int[] translateChars(char [] result) {
		int [] arr = new int[result.length];
		for (int i = 0; i < result.length; i++) {
			arr[i] = result[i];
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Create arrays
        int[] integerArray = createIntegers();
        System.out.println(Arrays.toString(integerArray));
        double[] doubleArray = createDoubles();
        System.out.println(Arrays.toString(doubleArray));
        String[] stringArray = createStrings("Hello There");
        System.out.println(Arrays.toString(stringArray));
        char[] charArray = createChars("Java1234!&");
        System.out.println(Arrays.toString(charArray));

        // Test processing
        System.out.println("Sum of integer array = " + sumArray(integerArray));
        System.out.println("Largest of double array = " + findlargest(doubleArray));
        System.out.println("Frequency of 'e' = " + charFrequency(stringArray, 'e'));
        System.out.println("Translated characters = " + Arrays.toString(translateChars(charArray)));

	}

}
