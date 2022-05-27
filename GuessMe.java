
/**
Author: William Tristan Olano
Program: simple guessing game based on binary search
Abstract: Create a simple guessing game that allows the player to select an upper bound of numbers that could be randomly selected,
        the player then guesses a number (ideally within that range) and the program gives them simple guidance to find the random number,
         */
import java.util.Scanner;
public class GuessMe 
{

public int getLogBase2(int n)
{
    int toReturn = (int)(Math.log(n) / Math.log(2));
    return toReturn;
}


public int getSecretNumber(int upperBound)
{
    int secretNumber = (int) Math.floor(Math.random() * upperBound) + 1;
    return secretNumber;
}


public int getUpperBound()
{
    Scanner keyboard = new Scanner(System.in);
    System.out.println("\n\nWelcome to the GuessMe Game!\n");
    System.out.print("What is your upper bound? ");      
    int upperBound = keyboard.nextInt();
    System.out.println("You chose: " + upperBound);
    return upperBound;
}


public void evaluateRange(int iter, int upperBound, int log2)
{
    int upperRange = log2 + 2;
    int lowerRange = log2 - 2;
    if (iter == 1)
        System.out.println("Bro you guessed that don't lie.");
    else if (iter >= lowerRange && iter <= upperRange)
        System.out.println("Wow! you got the answer within our range of a binary search, Good Job!");
    else if (iter > upperRange)
        System.out.println("Darn! unlucky, you were a little slower than a binary search :(");
    else if (iter < lowerRange)
        System.out.println("Wow, you did better than a binary search! you must be really smart :)");

    System.out.println("Our range of binary search is from: " + lowerRange + " to: " + upperRange + " iterations.");
    System.out.println("You solved the game in: " + iter + " iterations");
}


public void runGame(int secretNumber, int upperBound, int log2)
{
    Scanner keyboard = new Scanner(System.in);
    // set up booleans to keep track of whether user gets the right answer or quits
        boolean correct = false;
        boolean quit = false;
        boolean exit = false;
        int iter = 0;
        // as long as this boolean is false, user has not quit or gotten the correct number
        while (!exit)
        {
            System.out.print("Please choose a number, or zero (0) to quit: ");
            int userInput = keyboard.nextInt();
            if (userInput == secretNumber)
            {
                iter++;
                correct = true;
                exit = true;
            }
            if (userInput < secretNumber)
            {
                iter++;
                System.out.println("Number input by user is too low, try a higher number");
            }
            if (userInput > secretNumber)
            {
                iter++;
                System.out.println("Number input by user is too high, try a lower number");
            }
            if (userInput == 0)
            {
                quit = true;
                exit = true;
            }
        }
        if (correct)
        {
            evaluateRange(iter, upperBound, log2);
        }
        else
        {
            System.out.println("Better Luck Next time!");
        }
}

   public static void main(String[] args) 
   {
        GuessMe gm = new GuessMe();
        int upperBound = gm.getUpperBound();
        int secretNumber = gm.getSecretNumber(upperBound);
        int logBase2 = gm.getLogBase2(upperBound);
        gm.runGame(secretNumber, upperBound, logBase2);
   }
}

