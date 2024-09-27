import java.util.Scanner;
import java.util.Random;

public class GuessNumber{
    public static void main(String[] args){    // main methid is defined
         
        int randomnumber, guess, attempts, Score, limitattempts;   // instance of the class is defined
        Scanner scanner = new Scanner(System.in);  // reads data from the player
        Random gen = new Random(); // initializing a gen object
        boolean playagain = true;  // sets playagain value to true so that loops can be created

        Score = 0;  // initial score of the player


        while(playagain){      // using while loop until the playagain value is true
            randomnumber = gen.nextInt(100) + 1;  //generated a random number between 1 to 100
            guess = 0;   //initial value for number of guess of the player  is defined as 0 
            limitattempts = 10;   // limiting player to try again
            boolean hasWon = false;   // determing the state of the user if he has won or not intially it is set to false

            System.out.println("Welcome to the guessing game");
            System.out.println("A number has been selected between 1 and 100.");
            System.out.println("You need to guess the number\nYou have " + limitattempts + " attempts.");   // representing the number of guess for the player

            while (guess < limitattempts  ){ // creats a loop so that thet user is ablel to try againn and again until the players reaches its limit  
                System.out.print("Enter your guess: "); 
                attempts = scanner.nextInt();   // used to read the players input
                guess++; // increase the attempts of the player after each try

                if(attempts == randomnumber){  // if attempted value by the player is same as the random numbber generated then haswon value is set to true  
                    hasWon = true;
                    break;

                }else if(attempts > randomnumber){
                    System.err.println("the input is to high!!");  //if the attempted value is too high by the players 
                }else{
                    System.err.println("the input is to low!!");//if the attempted value is too low by the players 
                }
            }
            if (hasWon == true) {  // if players as won then the follwing output is given
                System.out.println("Congratulations! You Won\n Numbers of attempts by the user " + guess );
                Score += limitattempts - guess;  // calculates the score gained by the player subtracting the numger of guesses attempted by the user and the number of guess left for theh player
                System.out.println("Your current score is: " + Score);
            }else {   // if the haswon value is false then following output is displayed
                System.out.println("All Attempts used, The correct number was " + randomnumber + ".");
                System.out.println("Your current score is: " + Score);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine();
            String responce = scanner.nextLine(); //to ask the user if the player wants  to play the game again

            if (responce.equalsIgnoreCase("no")){
                playagain = false;
                System.out.println("Thank You for playing"); // the value of play again is set to false if the player says no to the rematch
            }  
    }
    scanner.close();
}
}