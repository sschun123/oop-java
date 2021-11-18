import java.util.InputMismatchException;
import java.util.Scanner;

public class Battleship {
    static final protected char EMPTY = '-';
    static final protected char SHIP = '@';
    static final protected char HIT = 'X';
    static final protected char MISS = 'O';

    static final protected int MAX_PLAYERS = 2;
    static final protected int MAX_SHIPS = 5;

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
        System.out.println("Welcome to Battleship!");
        Scanner input = new Scanner(System.in);

        Battleship.initGame(input);

        // do {
        //     int[] playerOneCoordinates = Battleship.getCoordinates();

        // } while (Battleship.gameActive);
    }

    // private static int[] getCoordinates() {
        
    // }

    private static int countHits(char[][] board) {
        return 3;
    }

    private static void initGame(Scanner input) {
        for (int j = 0; j < MAX_SHIPS; j++) {
            boolean validInput = false;
            System.out.println("PLAYER X, ENTER YOUR SHIPS' COORDINATES");
            do {
                System.out.printf("Enter ship %d location:\n", j + 1);

                try {
                    int row = input.nextInt();
                    int column = input.nextInt();

                    if (row >= MAX_SHIPS || column >= MAX_SHIPS) {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                    }
                    else if (Battleship.playerOneBoard[row][column] == Battleship.SHIP) {
                        System.out.println("You already have a ship there. Choose different coordinates.");
                    }
                    else {
                        validInput = true;
                        Battleship.playerOneBoard[row][column] = Battleship.SHIP;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                }
            } while (!validInput);
        }
        printBattleShip(playerOneBoard);
        // for loop 2 players
            // for loop 5 ships
                // prompt for ship coordinates ex: "1 5"
                // error invalid coordinates "Invalid coordinates. Choose different coordinates."
                // error coordinates are occupied "You already have a ship there. Choose different coordinates."
                // addShip
            // printBattleShip
            // print 100 new lines
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

    public static void addShip() {}
}
