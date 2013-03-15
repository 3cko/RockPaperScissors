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
        int round = 0;
        int pc_score = 0;
        int npc_score = 0;
        int tie_score = 0;

        String [] options = getChoices();
        String npc = getNpcChoice(options);

        System.out.println(getScoreBoard(pc_score, npc_score, 
                                         tie_score, round));

        String choice = "false";
        while ("false".equals(choice))
        {
            choice = getUserInput(options);
        }
        
        int score = getScore(doBattle(options, choice, npc));
        
        if (score == 0)
        {
            tie_score += 1;
        } else if (score == 1) {
            pc_score += 1;
        } else {
            npc_score += 1;
        }

    }

    public static String getScoreBoard(int pc_score, int npc_score, 
                                       int tie_score, int round)
    {
        String prep = "| Round: %d | Player Score: %d "
                    + "| Comp Score: %d | Ties: %d |";
        String formatted = String.format(prep, round, pc_score, 
                                         npc_score, tie_score);

        return formatted;

    }

    public static String getNpcChoice(String[] choices)
    {
        Random roll = new Random();
        int r = roll.nextInt(choices.length);
        return choices[r];
    }

    public static String parseChoice(String[] choices, String choice)
    {
        if (choice.length() == 1)
        {
            for (int x = 0; x < choices.length; x++)
            {
                String to_match = choices[x].substring(0,1);
                if (choice.equals(to_match)) return choices[x];
            }
        } else {
            for (int x = 0; x < choices.length; x++)
            {
                if (choice.equals(choices[x])) return choice;
            }
        }

        return "false";
    }

    public static int getScore(String score)
    {
        if ("tie".equals(score)) return 0;
        int winner = ("pc".equals(score)) ? 1 : 2;
        return winner;
    }

    public static String doBattle(String[] choices, String pc, String npc)
    {
        // Winner is +1, Loser is -1
        if (pc.equals(npc)) return "tie";

        for (int x = 0; x < choices.length; x++)
        {
            //if pc matches choices[x]
            if (pc.equals(choices[x]))
            {
                // if x == 0
                if (x == 0)
                {
                    // if npc == choices[choices.length]
                    if (npc.equals(choices[choices.length - 1])) return "pc";
                    // if npc == choices[x + 1]
                    if (npc.equals(choices[x + 1])) return "npc";
                // if x == (choices.length - 1)
                } else if (x == (choices.length - 1)) {
                    // if npc == choices[x - 1]
                    if (npc.equals(choices[x - 1])) return "pc";
                    // if npc == choices[0]
                    if (npc.equals(choices[0])) return "npc";
                } else {
                    // if npc == choices[x-1]
                    if (npc.equals(choices[x - 1])) return "pc";
                    // if npc == choices[x+1]
                    if (npc.equals(choices[x + 1])) return "npc";
                }
            }
        }
        return "wrong";
    }

    public static String getUserInput(String[] valid)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("[R]ock, [P]aper, [S]cissors (Choose One): ");
        String choice = input.next();
        
        choice = choice.toLowerCase();
        choice = parseChoice(valid, choice);
        // close scanner
        input.close();
        if (choice.equals("false"))
        {
            System.out.println("Invalid choice! Try again.");
            return "false";
        }
        
        return choice;
    }

    public static String[] getChoices()
    {
        String[] choices = {"rock", "paper", "scissors"};
        return choices;
    }
}
