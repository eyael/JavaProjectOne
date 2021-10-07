import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();


    public static void main(String[] args) {
        TicTacToe tic = new  TicTacToe();

        Scanner keyboard = new Scanner(System.in);

      System.out.println("Welcome to Tic-Tac-Toe!"
              );

    char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {' ', '+', ' ', '+', ' '},
            {' ', '|', ' ', '|', ' '},
            {' ', '+', ' ', '+', ' '},
            {' ', '|', ' ', '|', ' '}};

        while (true) {


        System.out.println("Print your number ");
        int pos = keyboard.nextInt();
        while(playerPosition.contains(playerPosition)||cpuPosition.contains(pos)) {
            System.out.println("position taken enter a correrct position ");
            pos = keyboard.nextInt();
        }

        switchGame(gameBoard, pos, "player");

        Random rand = new Random();
        int cpuPos = rand.nextInt(9) + 1;

        while(playerPosition.contains(playerPosition)||cpuPosition.contains(pos)){
            System.out.println("position taken enter a correrct position ");
            cpuPos = rand.nextInt(9) + 1;
        }
        switchGame(gameBoard, cpuPos, "cpu");


        printGameBoard(gameBoard);
        String result = checkWinner();
        System.out.println(result);
    }
}

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public static void switchGame(char[][] gameBoard, int pos, String user) {

        char symbol = 'X';

        if (user.equals("player")) {
            symbol = 'X';
            playerPosition.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPosition.add(pos);
        }


        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }

    }

    public static String checkWinner() {


        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List diagonal = Arrays.asList(1,5,9);
        List rightCOl = Arrays.asList(1,4,7);
        List leftRow = Arrays.asList(2,6,8);
        List midcRow = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<List>();

        winning.add(topRow);
        winning.add(midRow);
        winning.add(bottomRow);
        winning.add(diagonal);
        winning.add(rightCOl);
        winning.add(leftRow);
        winning.add(midcRow);


        for(List l: winning){
            if(playerPosition.containsAll(l)){
                return  "Congratulations you won ";
            }
            else if (cpuPosition.containsAll(l)) {
                return "The computer beat you up";
            } else if (playerPosition.size() + cpuPosition.size() == 9)
            {
                return "CAT";
            }
        }


        return "";
    }
}


