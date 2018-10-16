import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class P10 implements Interface{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instantiate student code
	    P10 p10 = new P10();
	    
	    // Test readTemperatures
	    Temperature[] data = p10.readTemperatures(args[0]);
	    
	    // Test findMinimum
	    Date start = Temperature.createDate("04-Jul-2008", "06:00");
	    Date end = Temperature.createDate("17-Aug-2010", "23:00");
	    System.out.println("Verifying findMinimum method:");
	    System.out.println("Start date: " + start.toString());
	    System.out.println("End date: " + end.toString());
	    System.out.printf("Minimum = %.1f degrees\n", p10.findMinimum(start, end, data));

	    // Test findMaximum 
	    start = Temperature.createDate("19-Sep-2011", "07:00");
	    end = Temperature.createDate("23-Mar-2015", "13:00");
	    System.out.println("Verifying findMaximum method:");
	    System.out.println("Start date: " + start.toString());
	    System.out.println("End date: " + end.toString());
	    System.out.printf("Maximum = %.1f degrees\n", p10.findMaximum(start, end, data));

	    // Test findAverage
	    start = Temperature.createDate("09-Apr-2006", "19:00");
	    end = Temperature.createDate("31-Oct-2013", "10:00");
	    System.out.println("Verifying findAverage method:");
	    System.out.println("Start date: " + start.toString());
	    System.out.println("End date: " + end.toString());
	    System.out.printf("Average = %.1f degrees\n", p10.findAverage(start, end, data));

	    // Test findHighest
	    start = Temperature.createDate("01-Jan-2015", "00:00");
	    end = Temperature.createDate("31-Dec-2015", "23:00");
	    System.out.println("Verifying findHighest method:");
	    System.out.println("Start date: " + start.toString());
	    System.out.println("End date: " + end.toString());
	    System.out.printf("Highest windspeed = %.1f\n", p10.findHighest(start, end, data));

	}
	int size;

	@Override
	public Temperature[] readTemperatures(String filename) {
		// TODO Auto-generated method stub
		try {
			Scanner inputFile = new Scanner(new File(filename));
			size=inputFile.nextInt();
			Temperature temperature[]=new Temperature[size];
			for(int i=0;i<size;i++) {
				String dayMonthYear=inputFile.next();
				String hour = inputFile.next();
				double degrees = inputFile.nextDouble();
				double speed = inputFile.nextDouble();
				temperature[i] = new Temperature(dayMonthYear,hour,degrees,speed);
			}
			return temperature;
			
		} catch (FileNotFoundException ex) {
			Logger.getLogger(P10.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public double findMinimum(Date start, Date end, Temperature[] data) {
		// TODO Auto-generated method stub
		double min=Double.MAX_VALUE;
		int i=0, j = 0;
		while (!start.equals(data[i].date))
			i++;
		while(!end.equals(data[j].date))
			j++;
		for(;i<j;i++) {
			if(data[i].temperature<min)
				min=data[i].temperature;
		}
		return min;
	}

	@Override
	public double findMaximum(Date start, Date end, Temperature[] data) {
		// TODO Auto-generated method stub
		double[] big = new double[data.length];
		int j=0;
		for(int i=0;i<data.length;i++){
			Temperature t=(Temperature)data[i];
			if(t.inInterval(start, end)){
				big[j]=t.temperature;
				j++;
				
			}
		}
		double max = big[0];
		 for(j=1;j<big.length;j++){
			 if(big[j]>max){
				 max = big[j];
				 
			 }
		 }
		 return max;

	}

	@Override
	public double findAverage(Date start, Date end, Temperature[] data) {
		// TODO Auto-generated method stub
		double avg = 0;
		int i=0,j=0;
		while(!start.equals(data[i].date))
			i++;
		while(!end.equals(data[j].date))
			j++;
		for(;i<=j;i++){
			avg+=data[i].temperature;
		}
		return avg/j+1;
	}

	@Override
	public double findHighest(Date start, Date end, Temperature[] data) {
		// TODO Auto-generated method stub
		double[] big = new double[data.length];
		int j=0;
		for(int i=0;i<data.length;i++){
			Temperature t=(Temperature)data[i];
			if(t.inInterval(start, end)){
				big[j]=t.windspeed;
				 j++;
			}
		}
		double max = big[0];
		for(j=1;j<big.length;j++){
			if(big[j]>max){
				max = big[j];
			}
		}
		return max;
	}

}
