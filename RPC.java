/* John Martin
 * CS55
 * Rock Paper Scissors
 */

import java.util.Scanner;
import java.util.Random;


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
        System.out.println(getNpcChoice(choices));
        System.out.println(parseChoice(choices, choice));
    }

    public static int getNpcChoice(String[] range)
    {
        Random roll = new Random();
        int r = roll.nextInt(range.length);
        return r;
    }

    public static String parseChoice(String[] choices, String choice)
    {
        if (choice.length() == 1)
        {
            return "True";
        }
        return "false";
    }
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
