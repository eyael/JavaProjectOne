import java.util.*;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner keyboard = new Scanner(System.in);
/*
            System.out.println("You are in a land full of dragons. In front of you,\n" +
                    "\n" +
                    "you see two caves. In one cave, the dragon is friendly\n" +
                    "\n" +
                    "and will share his treasure with you. The other dragon\n" +
                    "\n" +
                    "is greedy and hungry and will eat you on sight.\n" +
                    "\n" +
                    "Which cave will you go into? (1 or 2)");

            int userGuess = keyboard.nextInt();

            if (userGuess == 1) {
                System.out.println("You approach the cave...\n" +
                        "\n" +
                        "It is dark and spooky...\n" +
                        "\n" +
                        "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                        "\n" +
                        "Gobbles you down in one bite!");

            } else if (userGuess == 2) {
                System.out.println(" Congratulation" + "\n" + "You approch the cave and meet friendly dragon");
            } else
                System.out.println("You entered incorreect value");


    }
}

    // Assignment Two


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        String userResponse = "";
        System.out.println("Hello! What is your name?");
        String name = input.nextLine();
        while (true) {

            System.out.println("Well, " + name + "  I am thinking of a number between 1 and 20.\n" +
                    "\n" +
                    "Take a guess.");

            Random rand = new Random();
            int random = rand.nextInt(20);

            int userGuess = input.nextInt();

            if (userGuess == random) {
                System.out.println("Good job, !" + name + "  You guessed my number in guesses");
            } else if (userGuess < random) {
                System.out.println("Your guess is too low");
            } else if (userGuess > random) {
                System.out.println("Your guess is too high");
            } else {
                break;
            }
                System.out.println("Would you like to play again? (y or n)");
                userResponse = input.next();

                if (userResponse.equalsIgnoreCase("Yes") || userResponse.equalsIgnoreCase("Y")) {
                } else break;


            }
            System.out.println("Good bye");

        }


    }

*/

        ArrayList<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("bear");
        words.add("bird");
        words.add("car");
        words.add("plane");

        String hidden_text = words.get((int)(Math.random()* words.size()));

        char [] textArray = hidden_text.toCharArray();
        char [] answers = new char [textArray.length];

        System.out.println("Wellcome to Hangman");
        for (int i = 0; i < textArray.length; i++) {
            answers[i] = '?';
        }

        boolean finished = false;
        while(finished == false) {
            System.out.println("***************************");
            String letter = keyboard.next();
            // check for the valid input
            while(letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Error input try again");
                letter = keyboard.next();
            }
            // checks if the letter is in the word
            boolean found = false;
            int lives = 6;
            for(int i = 0; i< textArray.length; i++) {
                if(letter.charAt(0) == textArray[i]) {
                    answers[i] = textArray[i];
                    found = true;
                }
            }

            if(!found) {
                lives--;
                System.out.println("wrong letter");
            }

            boolean done = true;
            for(int i = 0; i< answers.length; i++){
                if(answers[i] == '?') {
                    System.out.println("_");
                    done = false;
                }
                else {
                    System.out.println("" + answers[i]);
                }
            }
            System.out.println("\n" + "lives left" + lives);
            drawHangman(lives);

            //checks if the game ends
            if(done) {
                System.out.println("Congrats you found the word");
                finished = true;
            }

            if (lives <= 0) {
                System.out.println("you are dead! study your English");
                finished = true;
            }
        }
    }

    public static void drawHangman(int i){
        if (i == 6) {
            System.out.println("+---+\n" +
                    "\n" +
                    "      |\n" +
                    "\n" +
                    "      |\n" +
                    "\n" +
                    "      |\n" +
                    "\n" +
                    "    ===");
        }

        if (i ==5) {
            System.out.println("+---+\n" +
                    "\n" +
                    " O" + "    |\n" +
                    "\n" +
                    "      |\n" +
                    "\n" +
                    "      |\n" +
                    "\n" +
                    "    ===");
        }

        if (i ==4) {
            System.out.println("+---+\n" +
                    "\n" +
                    " O " + "    |\n" +
                    "\n" +
                    "  | " + "   |\n" +
                    "\n" +
                    "      |\n" +
                    "\n" +
                    "    ===");
        }

        if (i ==3) {
            System.out.println("+---+\n" +
                    "\n" +
                    " O" + "    |\n" +
                    "\n" +
                    " |" + "     |\n" +
                    "\n" +
                    " |" +  "    |\n" +
                    "\n" +
                    "    ===");
        }

        if (i ==2) {
            System.out.println("+---+\n" +
                    "\n" +
                    " O" + "    |\n" +
                    "\n" +
                    "      |\n" +
                    "\n" +
                    "      |\n" +
                    "\n" +
                    "    ===");
        }

        if (i ==1 ) {
            System.out.println("+---+\n" +
                    "\n" +
                    " O" + "    |\n" +
                    "\n" +
                    "      |\n" +
                    "\n" +
                    "      |\n" +
                    "\n" +
                    "    ===");
        }

    }
}





