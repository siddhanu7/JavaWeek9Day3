package com.tts;

import java.util.Locale;

import java.util.Random;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text = "Hello World";
        System.out.println(text);

        // runs the functions from the Ascii.java file
        AsciiChars.printNumbers();
        AsciiChars.printLowerCase();
        AsciiChars.printUpperCase();

        // Allows us to use scanner (and therefore use user-input)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String yourName = scanner.next();
        System.out.println("Hello " + yourName);

        //Must print "yes" or "Y" to continue the questions.
        System.out.println("Do you wish to continue (y or n)?");
        //String promptAnswer = "y";
        String promptAnswer = scanner.next().toLowerCase();

        // if a user responds yes, it will proceed with the survey. If not, it will terminate the interview
        if (promptAnswer.equals("y") || promptAnswer.equals("yes")) {
            System.out.println("Let's Continue! Do you have a red car (y or n)?");
            String promptAnswer2 = scanner.next().toLowerCase();
            boolean redCar;
            // if the user responds yes, it changes the value of the boolean and returns a specific response
            if (promptAnswer2.equals("y") || promptAnswer2.equals("yes")) {
                redCar = true;
                System.out.println("That's a nice red car!");
            } else {
                redCar = false;
                System.out.println("Ah okay...");
            }

            System.out.println("What is your favorite pet's name?");
            scanner.next();

            System.out.println("What is your favorite pet's age?");
            int petAge = scanner.nextInt();

            System.out.println("What is your lucky number?");
            int luckyNumber = scanner.nextInt();

            System.out.println("Do you have a favorite quarterback (y or n)?");
            String promptAnswer3 = scanner.next().toLowerCase();

            // if the user responds yes, it will ask an additional question with a custom response.
            if (promptAnswer3.equals("y") || promptAnswer3.equals("yes")) {
                System.out.println("What is their jersey number?");
                int qbNumber = scanner.nextInt();
                System.out.println(qbNumber + " is a fitting number for the QB!");
            } else {
                int qbNumber = 0;
                System.out.println("Who needs a favorite QB anyway! I have " + qbNumber + " favorite quarterbacks!");
            }

            System.out.println("What is the two digit model year of your car? (e.g. 99, 05, 11)");
            int carYear = scanner.nextInt();

            System.out.println("What is the first name of your favorite actor or actress?");
            String favAct = scanner.next().toUpperCase();
            // toUpperCase is here so that when I pull from the first character, it will return a number later

            System.out.println("Enter a random number between 1 and 50 (If you don't, we'll pick one for you!).");
            int myNumber = scanner.nextInt();
            // if the value entered is less than 0, it subtracts the value from itself and adds 1.
            // This will always return "1" without hard-coding the value to equal 1 and potentially throwing an error since the statement will then always be false
            if (myNumber < 0) {
                do {
                    myNumber = (myNumber - myNumber) + 1;
                } while (myNumber < 0);
            }

            // if the value is greater than 50, it'll continue to subtract 50 from the value until it is less than 50.
            if (myNumber > 50) {
                do {
                    myNumber = myNumber - 50;
                } while (myNumber > 50);
            }
            // after going through the loops, it prints the value. If it was greater than 0 and less than 50, the value will be what you put
            System.out.println("Your number: " + myNumber);

            // allows me to use the random number generator function
            Random random = new Random();

            // the upperbounds will be what our maximum number can be for our random generator
            int upperbound1 = 10;
            int upperbound2 = 51;

            // the 3 required random number values defined by different maximums (upperbounds previously defined)
            // the "+1" is there so that the values are always at least 1 (because the random function has a minimum of 0)
            int randomNumber1 = random.nextInt(upperbound1) + 1;
            int randomNumber2 = random.nextInt(upperbound1) + 1;
            int randomNumber3 = random.nextInt(upperbound2) + 1;
            // required magic ball
            int magicBall = luckyNumber * randomNumber1;

            // function serves as a means to make the magic ball is 75 or less
            if (magicBall > 75) {
                do {
                    magicBall = magicBall - 75;
                } while (magicBall > 75);
            }

            // required Power Balls based off of specific values previously entered

            int powerBall1 = petAge + carYear;
            int powerBall2 = luckyNumber + carYear;
            int powerBall3 = randomNumber3 - randomNumber2;
            // Power Ball 4's value is based off of the first letter, and its value comes from the ASCII chart
            int powerBall4 = favAct.charAt(0);
            // Power Ball 4's value is based off of the last letter, and its value comes from the ASCII chart
            // to get the last letter since different entries will have a different amount of letters,
            // I set the charAt to take in the value of the length of whatever word was entered.
            // -1 is there so that the charAT value reads it correctly since it starts from 0, whereas length starts at 1
            // meaning that if a word is 5 letters long, the charAt value would equal 5 (which means that it is looking for 6 total letters)
            int powerBall5 = favAct.charAt(favAct.length()-1);

            // defines the maximum for the Power Balls to be 65 as requested from the instructions
            if (powerBall1 > 65) {
                do {
                    powerBall1 = powerBall1 - 65;
                } while (powerBall1 > 65);
            }
            if (powerBall2 > 65) {
                do {
                    powerBall2 = powerBall2 - 65;
                } while (powerBall2 > 65);
            }
            if (powerBall3 > 65) {
                do {
                    powerBall3 = powerBall3 - 65;
                } while (powerBall3 > 65);
            }
            if (powerBall4 > 65) {
                do {
                    powerBall4 = powerBall4 - 65;
                } while (powerBall4 > 65);
            }
            if (powerBall5 > 65) {
                do {
                    powerBall5 = powerBall5 - 65;
                } while (powerBall5 > 65);
            }

            // prints out the Power Balls and the Magic Ball values
            System.out.println("Lottery Numbers: " + powerBall1 + "," + powerBall2 + "," + powerBall3 + "," + powerBall4 + "," + powerBall5 + ". Magic Ball: " + magicBall);

            System.out.println("Play again (y or n)?");
            String playResponse = scanner.next().toLowerCase();

            // if the user chooses yes, this launches our function and the process starts over again
            if (playResponse.equals("y") || playResponse.equals("yes")) {
                main(new String[0]);
            } else {
                System.out.println("Adios!!!");
            }

        } else {
            System.out.println("Please return later to complete the survey.");
        }
    }
}