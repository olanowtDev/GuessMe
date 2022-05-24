
/**
Author: William Tristan Olano
Program: simple guessing game based on binary search
Abstract: Create a simple guessing game that allows the player to select an upper bound of numbers that could be randomly selected,
        the player then guesses a number (ideally within that range) and the program gives them simple guidance to find the random number,
         */
import java.util.Scanner;
public class GuessMe 
{
   public static void main(String[] args) 
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("\n\nWelcome to the GuessMe Game!\n");
      System.out.print("What is your upper bound? ");      
      int upperBound = keyboard.nextInt();
      System.out.println("You chose: " + upperBound);

      int secretNumber = (int) Math.floor(Math.random() * upperBound);
      if (secretNumber == 0)
        secretNumber++;

        // set up booleans to keep track of whether user gets the right answer or quits
        boolean correct = false;
        boolean quit = false;
        boolean exit = false;
        // as long as this boolean is false, user has not quit or gotten the correct number
        while (!exit)
        {
            System.out.print("Please choose a number, or zero (0) to quit: ");
            int userInput = keyboard.nextInt();
            if (userInput == secretNumber)
            {
                correct = true;
                exit = true;
            }
            if (userInput < secretNumber)
            {
                System.out.println("Number input by user is too low, try a higher number");
            }
            if (userInput > secretNumber)
            {
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
            System.out.println("Congragulations! you picked the correct number!");
        }
        else
        {
            System.out.println("Better Luck Next time!");
        }
   }
}

