/* John Martin
 * CS55
 * Rock Paper Scissors
 */

import java.util.Scanner;

public class RPC
{
    public static void main(String[] args)
    {
    	String [] choices = getChoices();
		String choice = "false";
		while ("false".equals(choice))
		{
			choice = getUserInput(choices);
		}
		System.out.println(choice);

    }

//    public static String getNpcChoice()
//    {
//    }
//
//    public static String doBattle(String PC, String NPC)
//    {
//    }

    public static String getUserInput(String[] valid)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("[R]ock, [P]aper, [S]cissors (Choose One): ");
        String choice = input.next();
		choice = choice.toLowerCase();
		for (int x = 0; x < valid.length; x++)
		{
			if (choice.equals(valid[x]))
			{
				return choice;
			}
		}
		System.out.println("Invalid choice! Try again.");
		return "false";
    }

    public static String[] getChoices()
    {
        String[] choices = {"r", "rock", "p", "paper", "s", "scissors"};
        return choices;
    }
}
