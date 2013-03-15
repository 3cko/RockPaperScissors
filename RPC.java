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
        System.out.print(choices);
    }

//    public static String getNpcChoice()
//    {
//        return;
//    }
//
//    public static String doBattle(String PC, String NPC)
//    {
//        return;
//    }
//
//    public static String getUserInput()
//    {
//        Scanner input = new Scanner(System.in);
//        System.out.print("[R]ock, [P]aper, [S]cissors (Choose One): ");
//        String choice = input.nextLine();
//        return;
//    }

    public static String[] getChoices()
    {
        String[] choices = {"r", "rock", "p", "paper", "s", "scissors"};
        return choices;
    }
}
