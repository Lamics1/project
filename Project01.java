import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Project01 {
    //Method to print array
    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j]);
                if (j < 2) System.out.print(" |");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }

    //method to check who is winner ?
    public static char checkWinner(char[][] b) {
        //Check from row and colum

        for (int i = 0; i < 3; i++) {
            if (b[i][0] != ' ' && b[i][0] == b[i][1] && b[i][1] == b[i][2])//Check Rows
                return b[i][0];

            if (b[0][i] != ' ' && b[0][i] == b[1][i] && b[1][i] == b[2][i])//Check column
                return b[0][i];
        }
        // Check The diagonals
        if (b[0][0] != ' ' && b[0][0] == b[1][1] && b[1][1] == b[2][2])//UP left to D right
            return b[0][0];

        if (b[0][2] != ' ' && b[0][2] == b[1][1] && b[1][1] == b[2][0])//UP right to D left
            return b[0][2];

        // No one winner
        return ' ';
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random random = new Random();
        int round = 1;
        int playerWins = 0;
        int computerWins = 0;

        System.out.println("Do you want to play ( 1 ) round or ( 3 ) rounds?\n Enter 1 or 3: ");

        while (true) {

            try {
                round = s.nextInt();
                s.nextLine();//In order to solve the infinite loop problem

                if (round != 1 && round != 3) {
                    System.out.println("Invalid input , try again");

                    continue;
                } else {
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter valid number");
                s.nextLine();//In order to solve the infinite loop problem
            } catch (ArithmeticException e) {
                System.out.println(e.fillInStackTrace());
            }

        }
        System.out.println("Instructions :\n This is the numbering of the squares in the game of tic-tac-toe");

        int count = 1;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(" " + count);
                if (j < 2) System.out.print(" |");
                count++;
            }
            System.out.println();

            if (i < 2) System.out.println("---+---+---");
        }

        System.out.println("Enter your name to start the game ");
        String playerName = s.nextLine();


        for (int game = 1; game <= round; game++) {
            System.out.println("Starting Game [ " + game + " ]");
            char[][] board = new char[3][3];


            // fill in the array with blanks
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    board[i][j] = ' ';

            char winner = ' ';
            int turn = 0;

            while (turn < 9 && winner == ' ') {
                printBoard(board);

                if (turn % 2 == 0) {
                    // Turn the player
                    System.out.println("it’s your turn :" + playerName);
                    int position;
                    int row, col;

                    while (true) {
                        try {
                            System.out.print("\n Choose a number from 1 to 9 :");
                            position = s.nextInt();

                            if (position < 1 || position > 9) {
                                System.out.println("Invalid number , try again ");
                                continue;
                            }

                            row = (position - 1) / 3;
                            col = (position - 1) % 3;

                            if (board[row][col] == ' ') {
                                board[row][col] = 'X';
                                break;
                            } else {
                                System.out.println("\n The place is taken , choose another number");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter valid number");
                            s.nextLine();//In order to solve the infinite loop problem
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        } catch (IllegalStateException e) {
                            System.out.println(e.fillInStackTrace());
                        }
                    }
                } else {
                    //Turn computer
                    System.out.println("Turn computer");
                    int row, col;

                    while (true) {
                        int position = random.nextInt(9) + 1;
                        row = (position - 1) / 3;
                        col = (position - 1) % 3;

                        if (board[row][col] == ' ') {
                            board[row][col] = 'O';
                            break;
                        }
                    }
                }
                //After each move , check if anyone has won.
                winner = checkWinner(board);
                turn++;
            }

            printBoard(board);

            if (winner == 'X') {
                System.out.println("Congratulations " + playerName + " you’re the winner");
                playerWins++;
            } else if (winner == 'O') {
                System.out.println("Computer wins , game over!");
                computerWins++;
            } else {
                System.out.println("The match ended in a draw !");
            }

            System.out.println("\n--- Results after the game (" + game + ") ---");
            System.out.println(playerName + " won (" + playerWins + ") rounds");
            System.out.println("Computer won (" + computerWins + ") rounds");

        }
    }
}