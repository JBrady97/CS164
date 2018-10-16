import java.util.Scanner;

public class P4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		double grossSalary;
		double interestIncome;
		double capitalGains;
		int numExemptions;
		double totalIncome;
		double adjustedIncome;
		double federalTax;
		double stateTax;
		System.out.print("Salary: ");
		grossSalary = keyboard.nextDouble();
		System.out.print("Exemptions: ");
		numExemptions = keyboard.nextInt();
		System.out.print("Interest: ");
		interestIncome = keyboard.nextDouble();
		System.out.print("Gains: ");
		capitalGains = keyboard.nextDouble();
		totalIncome = grossSalary + interestIncome + capitalGains - 5000.00;
		adjustedIncome = totalIncome - (numExemptions * 1500.00);
		if (adjustedIncome >= 0 && adjustedIncome < 20000) {
			federalTax = 0 * (20000 - 0);
		}
		else if (adjustedIncome >= 20000 && adjustedIncome < 35000) {
			federalTax = 0.13 * (35000 - 20000);
		}
		else if (adjustedIncome >= 35000 && adjustedIncome < 50000) {
			federalTax = 0.23 * (50000 - 35000);
		}
		else { 
			federalTax = 0.28 * (adjustedIncome - 50000);
		}
			
		
		stateTax = adjustedIncome * 0.065;
		
		System.out.printf("Total Income: $%.2f" , totalIncome);
		System.out.println("");
		System.out.printf("Adjusted Income:$%.2f" , adjustedIncome);
		System.out.println("");
		System.out.printf("Total Tax: $%.2f" , federalTax);
		System.out.println("");
		System.out.printf("State Tax: $%.2f" , stateTax);
		
		
		

	}

}
