/*
 * Kurt Kangas
 * CIS 2212 Java Software Development I
 * Credit Card Validation
 */

import java.util.Scanner;

public class CreditCardValidation {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("This program validates a credit card if it is valid or invalid.");

			boolean again = true;
			do
			{
				System.out.println("Enter a credit card number: ");
				String number = input.nextLine();
				if (isValid(number))
				{
					String CreditCardCompany = getCreditCardCompany(number);
					System.out.println(number + " is a valid " + CreditCardCompany + " card.");
				}
				else
				{
					System.out.println(number + " is invalid.");	
				}	
				System.out.println("Validate another number? (Y/N) ");
				String repeat = input.nextLine();
				if (repeat.equalsIgnoreCase("y"))
				{
					again = true;
				}
				else if (repeat.equalsIgnoreCase("n"))
				{
					System.out.println("Bye!");
					again = false;
				}
				else
				{
					System.out.println("Invalid input.");
					System.out.println("Bye!");
					again = false;
				}	
			} while(again);
		}
	}
	public static boolean isValid(String number)
	{
		if (number.length() >= 13 && number.length() <= 16)
		{
			if (number.matches("[0-9]+"))
			{
				int sum = 0;
				sum += sumOfDoubleEvenPlaces(number);
				sum += sumOfOddPlaces(number);
				if (sum % 10 == 0)
				{
					return true;
				} else {return false;}
			} else {return false;}
		} else {return false;}
	}
	public static int sumOfDoubleEvenPlaces(String number)
	{
		int sum = 0;
		int length = number.length() - 1;
		for (int i = 0; i < length; i++)
		{
			length -= 1;
			char ch = number.charAt(i);
			int temporarySum = ch - '0';
			temporarySum *= 2;
			if (temporarySum > 9)
			{
				temporarySum -= 9;
			}
			sum += temporarySum;
			i++;
		}
		return sum;
	}
	public static int sumOfOddPlaces(String number)
	{
		int sum = 0;
		int length = number.length() - 1;
		for (int i = 0; i < length; i++)
		{
			length += 0;
			char ch = number.charAt(i);
			int temporarySum = ch - '0';
			temporarySum *= 2;
			if (temporarySum > 9)
			{
				temporarySum -= 9;
			}
			sum += temporarySum;
			i++;
		}
		return sum;
	}
	public static String getCreditCardCompany(String number)
	{
		if (number.charAt(0) == '4')
		{
			return "Visa";
		}
		else if (number.charAt(0) == '5')
		{
			return "MasterCard";
		}
		else if (number.charAt(0) == '6')
		{
			return "Discover";
		}
		else if (number.charAt(0) == '3' && number.charAt(1) == '7')
		{
			return "American Express";
		}
		else {
			return " ";
		}
	}
}

