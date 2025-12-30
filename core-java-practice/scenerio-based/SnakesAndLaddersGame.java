class SnakesAndLaddersUC1 {
	// UC-1 Single-Player At Start Position 0
	public void gameBoard() {
		int playerOne = 0;
	}
}

class SnakesAndLaddersUC2 {
	// UC-2 Roll a dice to get number between 1-6
	public int rollDice() {
		return (int) (Math.random() * 6) + 1;
	}
}

class SnakesAndLaddersUC3 {

	// UC-2 Roll a dice to get number between 1-6
	public int rollDice() {
		return (int) (Math.random() * 6) + 1;
	}

	// UC-3 Check for movement option
	public int moveSteps() {
		// 0- No Play 1-Ladder 2-Snake
		int canMove = (int) (Math.random() * 3);
		if (canMove == 0) {
			return 0;
		}
		int diceRoll = rollDice();
		if (canMove == 1) {
			return diceRoll;
		}
		return -diceRoll;
	}
}

class SnakesAndLaddersUC4 {

	// UC-2 Roll a dice to get number between 1-6
	public int rollDice() {
		return (int) (Math.random() * 6) + 1;
	}

	// UC-3 Check for movement option
	public int moveSteps() {
		// 0- No Play 1-Ladder 2-Snake
		int canMove = (int) (Math.random() * 3);
		if (canMove == 0) {
			return 0;
		}
		int diceRoll = rollDice();
		if (canMove == 1) {
			return diceRoll;
		}
		return -diceRoll;
	}

	// UC-4 Move player till he reaches 100
	public void gameBoard() {
		int currentPosition = 0;
		final int END_POINT = 100;
		while (currentPosition < END_POINT) {
			int movement = moveSteps();
			currentPosition += movement;
			if (currentPosition < 0) {
				currentPosition = 0;
			}
		}
	}
}

class SnakesAndLaddersUC5 {

	// UC-2 Roll a dice to get number between 1-6
	public int rollDice() {
		return (int) (Math.random() * 6) + 1;
	}

	// UC-3 Check for movement option
	public int moveSteps() {
		// 0- No Play 1-Ladder 2-Snake
		int canMove = (int) (Math.random() * 3);
		if (canMove == 0) {
			return 0;
		}
		int diceRoll = rollDice();
		if (canMove == 1) {
			return diceRoll;
		}
		return -diceRoll;
	}

	// UC-4 Move player till he reaches 100
	public void gameBoard() {
		int currentPosition = 0;
		final int END_POINT = 100;

		// UC-4 Move player till he reaches 100
		System.out.println("You are at position " + currentPosition);
		while (currentPosition < END_POINT) {
			int movement = moveSteps();
			if (movement < 0) {
				System.out.println("You are at a snake. You go back by " + movement + " steps");
			} else if (movement == 0) {
				System.out.println("You do not move");
			} else {
				// UC-5 Check that player reaches exactly 100 to win
				if (movement + currentPosition > END_POINT) {
					System.out.println("Sorry! You rolled greater than a " + (END_POINT - currentPosition)
							+ ". You cannot proceed");

					// UC-6 Show the position after each die throw
					System.out.println("You are at position " + currentPosition);
					continue;
				}
				System.out.println("You are at a ladder. You go forward by " + movement + " steps");
			}
			currentPosition += movement;
			if (currentPosition < 0) {
				currentPosition = 0;
			}
			System.out.println("You are at position " + currentPosition);
		}
		System.out.println("Congratulations! You won!");
	}
}

class SnakesAndLaddersUC6 {

	// UC-2 Roll a dice to get number between 1-6
	public int rollDice() {
		return (int) (Math.random() * 6) + 1;
	}

	// UC-3 Check for movement option
	public int moveSteps() {
		// 0- No Play 1-Ladder 2-Snake
		int canMove = (int) (Math.random() * 3);
		if (canMove == 0) {
			return 0;
		}
		int diceRoll = rollDice();
		if (canMove == 1) {
			return diceRoll;
		}
		return -diceRoll;
	}

	public void gameBoard() {
		final int END_POINT = 100;
		int currentPosition = 0;
		int numberOfDiceThrows = 0;

		// UC-4 Move player till he reaches 100
		System.out.println("You are at position " + currentPosition);

		while (currentPosition < END_POINT) {
			int movement = moveSteps();

			// UC-6 Count the number of die was played
			numberOfDiceThrows++;

			if (movement < 0) {
				System.out.println("You are at a snake. You go back by " + movement + " steps");
			} else if (movement == 0) {
				System.out.println("You do not move");
			} else {
				// UC-5 Check that player reaches exactly 100 to win
				if (movement + currentPosition > END_POINT) {
					System.out.println("Sorry! You rolled greater than a " + (END_POINT - currentPosition)
							+ ". You cannot proceed");

					// UC-6 Show the position after each die throw
					System.out.println("You are at position " + currentPosition);
					continue;
				}
				System.out.println("You are at a ladder. You go forward by " + movement + " steps");
			}
			currentPosition += movement;
			if (currentPosition < 0) {
				currentPosition = 0;
			}

			// UC-6 Show the position after each die throw
			System.out.println("You are at position " + currentPosition);
		}
		System.out.println("Congratulations! You won!");

		// UC-6 Report the number of die was played
		System.out.println("You threw the die " + numberOfDiceThrows + " times");
	}
}

class SnakesAndLaddersUC7 {

	// UC-2 Roll a dice to get number between 1-6
	public int rollDice() {
		return (int) (Math.random() * 6) + 1;
	}

	// UC-3 Check for movement option
	public int moveSteps() {
		// 0- No Play 1-Ladder 2-Snake
		int canMove = (int) (Math.random() * 3);
		if (canMove == 0) {
			return 0;
		}
		int diceRoll = rollDice();
		if (canMove == 1) {
			return diceRoll;
		}
		return -diceRoll;
	}

	public int displayTurn(String player, int currentPosition) {
		final int END_POINT = 100;

		int movement = moveSteps();
		if (movement < 0) {
			System.out.println("You are at a snake. You go back by " + movement + " steps");
		} else if (movement == 0) {
			System.out.println("You do not move");
		} else {
			// UC-5 Check that player reaches exactly 100 to win
			if (movement + currentPosition > END_POINT) {
				System.out.println(
						"Sorry! You rolled greater than a " + (END_POINT - currentPosition) + ". You cannot proceed");

				// UC-6 Show the position after each die throw
				System.out.println("You are at position " + currentPosition);
				return currentPosition;
			}

			System.out.println("You are at a ladder. You go forward by " + movement + " steps");
		}
		currentPosition += movement;
		if (currentPosition < 0) {
			currentPosition = 0;
		}

		// UC-6 Show the position after each die throw
		System.out.println(player + " at position " + currentPosition);
		return currentPosition;
	}

	public void gameBoard() {
		final int END_POINT = 100;
		int playerOneCurrentPosition = 0;

		// UC-7 Add Player 2
		int playerTwoCurrentPosition = 0;
		int numberOfDiceThrowsOne = 0;
		int numberOfDiceThrowsTwo = 0;

		System.out.println("Player 1 at position " + playerOneCurrentPosition);
		System.out.println("Player 2 at position " + playerTwoCurrentPosition);
		boolean turn = true;

		// UC-4 Move player till he reaches 100
		while (playerOneCurrentPosition < END_POINT && playerTwoCurrentPosition < END_POINT) {
			if (turn) {
				System.out.println("Player 1's turn");
				numberOfDiceThrowsOne++;
				playerOneCurrentPosition = displayTurn("Player 1", playerOneCurrentPosition);
				turn = !turn;
			} else {
				System.out.println("Player 2's turn");
				numberOfDiceThrowsOne++;
				playerTwoCurrentPosition = displayTurn("Player 2", playerTwoCurrentPosition);
				turn = !turn;
			}
		}
		if (playerOneCurrentPosition == 100) {
			System.out.println("Congratulations! Player 1 Won!");
		} else {
			System.out.println("Congratulations! Player 2 Won!");
		}

		// UC-6 Report the number of die was played
		System.out.println("Player 1 threw the die " + numberOfDiceThrowsOne + " times");
		System.out.println("Player 2 threw the die " + numberOfDiceThrowsTwo + " times");
	}
}

public class SnakesAndLaddersGame {
	// UC-2 Roll a dice to get number between 1-6
	public int rollDice() {
		return (int) (Math.random() * 6) + 1;
	}

	// UC-3 Check for movement option
	public int moveSteps() {
		// 0- No Play 1-Ladder 2-Snake
		int canMove = (int) (Math.random() * 3);
		if (canMove == 0) {
			return 0;
		}
		int diceRoll = rollDice();
		if (canMove == 1) {
			return diceRoll;
		}
		return -diceRoll;
	}

	public int displayTurn(String player, int currentPosition) {
		final int END_POINT = 100;

		int movement = moveSteps();
		if (movement < 0) {
			System.out.println("You are at a snake. You go back by " + movement + " steps");
		} else if (movement == 0) {
			System.out.println("You do not move");
		} else {
			// UC-5 Check that player reaches exactly 100 to win
			if (movement + currentPosition > END_POINT) {
				System.out.println(
						"Sorry! You rolled greater than a " + (END_POINT - currentPosition) + ". You cannot proceed");

				// UC-6 Show the position after each die throw
				System.out.println("You are at position " + currentPosition);
				return currentPosition;
			}

			System.out.println("You are at a ladder. You go forward by " + movement + " steps");
		}
		currentPosition += movement;
		if (currentPosition < 0) {
			currentPosition = 0;
		}

		// UC-6 Show the position after each die throw
		System.out.println(player + " at position " + currentPosition);
		return currentPosition;
	}

	public void gameBoard() {
		final int END_POINT = 100;
		
		//UC-1 Start Position 0
		int playerOneCurrentPosition = 0;

		// UC-7 Add Player 2
		int playerTwoCurrentPosition = 0;
		int numberOfDiceThrowsOne = 0;
		int numberOfDiceThrowsTwo = 0;
		int prevOne = 0;
		int prevTwo = 0;
		
		System.out.println("Player 1 at position " + playerOneCurrentPosition);
		System.out.println("Player 2 at position " + playerTwoCurrentPosition);
		boolean turn = true;
		System.out.println();
		// UC-4 Move player till he reaches 100
		while (playerOneCurrentPosition < END_POINT && playerTwoCurrentPosition < END_POINT) {
			if (turn) {
				prevOne = playerOneCurrentPosition;
				System.out.println("Player 1's turn");
				numberOfDiceThrowsOne++;
				playerOneCurrentPosition = displayTurn("Player 1", playerOneCurrentPosition);
				if(playerOneCurrentPosition == END_POINT) {
					break;
				}
				if(playerOneCurrentPosition > prevOne) {
					System.out.println("Since you got a ladder you can roll again");
					continue;
				}
				turn = !turn;
			} else {
				prevTwo = playerTwoCurrentPosition;
				System.out.println("Player 2's turn");
				numberOfDiceThrowsTwo++;
				playerTwoCurrentPosition = displayTurn("Player 2", playerTwoCurrentPosition);
				if(playerTwoCurrentPosition == END_POINT) {
					break;
				}
				if(playerTwoCurrentPosition > prevTwo) {
					System.out.println("Since you got a ladder you can roll again");
					continue;
				}
				turn = !turn;
			}
			System.out.println();
		}
		System.out.println();
		if (playerOneCurrentPosition == 100) {
			System.out.println("Congratulations! Player 1 Won!");
		} else {
			System.out.println("Congratulations! Player 2 Won!");
		}

		// UC-6 Report the number of die was played
		System.out.println("Player 1 threw the die " + numberOfDiceThrowsOne + " times");
		System.out.println("Player 2 threw the die " + numberOfDiceThrowsTwo + " times");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakesAndLaddersGame obj = new SnakesAndLaddersGame();
		obj.gameBoard();
	}

}