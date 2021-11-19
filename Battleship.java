import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.*;

public class Battleship {
    static final protected char EMPTY = '-';
    static final protected char SHIP = '@';
    static final protected char HIT = 'X';
    static final protected char MISS = 'O';

    static final protected int MAX_PLAYERS = 2;
    static final protected int MAX_SHIPS = 5;
    static final protected int BOARD_SIZE = 5;

    static protected boolean gameActive = true;

    static char[][] playerOneBoard = {
        { Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, },
        { Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, },
        { Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, },
        { Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, },
        { Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, },
    };

    static char[][] playerTwoBoard = {
        { Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, },
        { Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, },
        { Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, },
        { Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, },
        { Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, Battleship.EMPTY, },
    };

    public static void main(String[] args) {
        // System.out.println("Welcome to Battleship!");
        // Scanner input = new Scanner(System.in);

        // Battleship.initGame(input);
        // Battleship.playGame(Battleship.playerOneBoard, Battleship.playerTwoBoard, input);
        int test = 100;
        test++;
        System.out.println("jackets".equals("Jackets"));
        DecimalFormat tForm = new DecimalFormat("##.00");
System.out.println(tForm.format(12682.1));
    }

    private static void playGame(char[][] boardOne, char[][] boardTwo, Scanner input) {
        boolean playerOneWin = false;
        boolean playerTwoWin = false;

        do {
            playerOneWin = Battleship.playTurn("1", "2", boardTwo, input);
            Battleship.printBattleShip(boardTwo);
            System.out.println("");
            if (playerOneWin) {
                break;
            }
            
            playerTwoWin = Battleship.playTurn("2", "1", boardOne, input);
            Battleship.printBattleShip(boardOne);
            System.out.println("");
            if (playerTwoWin) {
                break;
            }
        } while (!(playerOneWin || playerTwoWin));

        String playerName;
        if (playerOneWin) {
            playerName = "1";
        }
        else {
            playerName = "2";
        }

        System.out.printf("PLAYER %s WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!\n", playerName);
        System.out.println("");
        System.out.println("Final boards:");
        System.out.println("");
        Battleship.printBattleShip(boardOne);
        System.out.println("");
        Battleship.printBattleShip(boardTwo);
    }

    private static boolean playTurn(String playerName, String oppName, char[][] board, Scanner input) {
        boolean validInput = false;

        int x = 0;
        int y = 0;
        do {
            try {
                System.out.printf("Player %s, enter hit row/column:\n", playerName);
                x = input.nextInt();
                y = input.nextInt();
                input.nextLine();
                if (x >= Battleship.BOARD_SIZE) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                }
                else if (board[x][y] == Battleship.HIT || board[x][y] == Battleship.MISS) {
                    System.out.println("You already fired on this spot. Choose diffferent coordinates.");
                }
                else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
        } while (!validInput);

        if (board[x][y] == Battleship.SHIP) {
            board[x][y] = Battleship.HIT;
        }
        else if (board[x][y] == Battleship.EMPTY) {
            board[x][y] = Battleship.MISS;
            System.out.printf("PLAYER %s MISSED!\n", playerName);
            return false;
        }

        int hits = Battleship.countHits(board);
        if (hits >= Battleship.MAX_SHIPS) {
            return true;
        }
        System.out.printf("PLAYER %s HIT PLAYER %s's SHIP!\n", playerName, oppName);
        return false;
    }

    private static int countHits(char[][] board) {
        int hits = 0;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == Battleship.HIT) {
                    hits++;
                }
                if (hits >= Battleship.MAX_SHIPS) {
                    break;
                }
            }
        }
        return hits;
    }

    private static void initGame(Scanner input) {
        char[][] boardOne = Battleship.initBoard("PLAYER 1", Battleship.playerOneBoard, input);
        printBattleShip(boardOne);
        Battleship.printLines(100);
        char[][] boardTwo = Battleship.initBoard("PLAYER 2", Battleship.playerTwoBoard, input);
        printBattleShip(boardTwo);
        Battleship.printLines(100);
    }

    private static void printLines(int lines) {
        for (int i = 0; i < lines; i++) {
            System.out.println("");
        }
    }

    private static  char[][] initBoard(String playerName, char[][] board, Scanner input) {
        System.out.printf("%s, ENTER YOUR SHIPS' COORDINATES\n", playerName);
        for (int j = 0; j < MAX_SHIPS; j++) {
            boolean validInput = false;
            do {
                System.out.printf("Enter ship %d location:\n", j + 1);

                try {
                    int row = input.nextInt();
                    int column = input.nextInt();
                    input.nextLine();
                    if (row >= MAX_SHIPS || column >= MAX_SHIPS) {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                    }
                    else if (board[row][column] == Battleship.SHIP) {
                        System.out.println("You already have a ship there. Choose different coordinates.");
                    }
                    else {
                        validInput = true;
                        board[row][column] = Battleship.SHIP;
                    }
                } catch (InputMismatchException e) {
                    input.next();
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                }
            } while (!validInput);
        }
        return board;
    }

    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}
