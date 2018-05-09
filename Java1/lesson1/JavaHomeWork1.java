/**
* GeekBrains Java1 HomeWork 1
* @author Suchkov Denis
* @version dated Jan 27, 2018
*/
public class JavaHomeWork1 {
	public static void main(String[] args) {
		// Task 1 : Create project in IntelliJ IDEA - passed

		// Task 2 : Create variables
		byte i=16;
		short j = 1024;
		int year = 2014;
		long k = 64000;
		boolean agrFlg = true;
		final double e = 2.718281828459045;
		final float pi = 3.14f;
		char symbol='z';

		// Task 3 : a * (b + (c / d))
		System.out.println(computeExpresion(2, 1, 9, 3));
		
		// Task 4 : between 10 and 20
		System.out.println(checkSum(12,4));

		// Task 5 : print Sign of number
		printSign(-6);

		// Task 6 : is Negative or not?
		System.out.println(isNegative(3));

		// Task 7 : say Hellow
		sayHello("Сергей Ирюпин");

		// Task 8 : check on leap-year
		checkOnLeapYear(2100);
	}

	public static double computeExpresion(double a, double b, double c, double d)
	{
		return a * (b + (c / d));
	}

	public static boolean checkSum(int a, int b) {
		boolean result = false;
		if ((a+b>=10)&&(a+b<=20))
			result = true;
		return result;
	}

	public static void printSign(int a) {
		if (a>=0)
			System.out.println("Number " + a + " is positive");
		else
			System.out.println("Number " + a + " is negative");
	}

	public static boolean isNegative(int a) {
		boolean result = false;
		if (a<0)
			result = true;
		return result;
	}

	public static void sayHello(String name){
		System.out.println("Здравствуйте, " + name + "!");
	}

	public static void checkOnLeapYear(int n) {
		boolean leap = false;
		if (n % 4 == 0)
			if (n % 100 == 0)
				if (n % 400 == 0)
					leap = true;
				else
					leap = false;
			else
				leap = true;
		if (leap)
			System.out.println(n + " is a leap-year");
		else
			System.out.println(n + " is not a leap-year");
	} 
} 