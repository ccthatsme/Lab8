package co.grandcircus;

import java.util.Scanner;

public class Lab8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] id = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		// String
		String[] names = { "Chris", "John", "Jim", "Sarah", "Ruth", "Harry", "Kevin", "Brian", "Ashley", "Karen" };
		boolean check = false;
		System.out.println("Welcome to our Java class");
		int student = 0;
		while (!check) {
			student = getInt(scan, "Which student would you like to learn about? type a number 1 through 10", 1, 10);
			System.out.println("Student " + student + " is " + names[student - 1]);
			System.out.println("What would you like to know about " + names[student - 1]);
			System.out.println(getFood(scan, "please enter \"hometown\" or \"favorite food\"", (student - 1)));
			boolean check2 = false;
			while (!check2) {
			System.out.println("would you like to know more about " + names[student - 1] + " (y/n)?");
			String y = scan.next();
				if (y.equalsIgnoreCase("y")) {
				scan.nextLine();
				System.out.println(getFood(scan, "please enter \"hometown\" or \"favorite food\"", (student - 1)));
					check = false;
				} else if (y.equalsIgnoreCase("n")) {
					boolean check3 = false;
					while (!check3) {
					System.out.println("no problem, want to find out about another student (y/n)");
					y = scan.next();
					if (y.equalsIgnoreCase("y")) {
						check2 = true;
						check = false;
							check3 = true;
					} else if (y.equalsIgnoreCase("n")) {
						check2 = true;
						check = true;
							check3 = true;
						} else {
							System.out.println("Invalid");
							check3 = false;
						}

					}
				} else {
					System.out.println("Invalid entry, please enter (y/n) again");
					check2 = false;
				}

			}
		}
		System.out.println("Thanks for playing!");
		while (!check) {
			System.out.println();

		}

	}

	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (i > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return i;
	}

	public static String getFood(Scanner sc, String prompt, int a) {
		boolean isValid = false;
		String[] names = { "Chris", "John", "Jim", "Sarah", "Ruth", "Harry", "Kevin", "Brian", "Ashley", "Karen" };
		String[] x = { "Pizza", "Pizza", "Burgers", "Tacos", "Tuna Salad", "Turkey Sub", "Pasta", "Chicken", "Potatoes",
				"potroast" };
		String[] y = { "Detroit", "Northville", "Birmingham", "Livonia", "Plymouth", "Canton", "ypsilanti", "Ann Arbor",
				"Novi", "Detroit" };
		String s = "";
		while (isValid == false) {
			System.out.print(prompt);
			s = sc.nextLine(); // read user entry, if you type a sentence, it will return only the first word
			if (s.equalsIgnoreCase("favorite food")) {
				s = names[a] + "'s favorite food is " + x[a];
				isValid = true;
			} else if (s.equalsIgnoreCase("hometown")) {
				s = names[a] + "'s hometown is " + y[a];
				isValid = true;
			} else {
				System.out.println("That data does not exist");
				isValid = false;
			}


		}
		return s;
	}

}
