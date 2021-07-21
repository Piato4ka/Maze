package Game;

import java.util.Scanner;

public class Game {
	public static int[] PlayerPlace = new int[] { 0, 0 };
	public static int getX() {
		return PlayerPlace[0];
	}
	public static int getY() {
		return PlayerPlace[1];
	}

	public static void display(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void move(char[][] board) {
		board[getX()][getY()] = '.';
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		switch (input) {
		case "w":
			if ((board[getX() - 1][getY()] != '-') & (board[getX() - 1][getY()] != '|')) {
				PlayerPlace[0] -= 1;
				board[getX()][getY()] = check(board[getX()][getY()]);
			}
			board[getX()][getY()] = check(board[getX()][getY()]);
			break;
		case "s":
			if ((board[getX() + 1][getY()] != '-') & (board[getX() + 1][getY()] != '|')) {
				PlayerPlace[0] += 1;
				board[getX()][getY()] = check(board[getX()][getY()]);
			}
			board[getX()][getY()] = check(board[getX()][getY()]);
			break;
		case "a":
			if ((board[getX()][getY() - 1] != '-') & (board[getX()][getY() - 1] != '|')) {
				PlayerPlace[1] -= 1;
				board[getX()][getY()] = check(board[getX()][getY()]);
			}
			board[getX()][getY()] = check(board[getX()][getY()]);
			break;
		case "d":
			if ((board[getX()][getY() + 1] != '-') & (board[getX()][getY() + 1] != '|')) {
				PlayerPlace[1] += 1;
				board[getX()][getY()] = check(board[getX()][getY()]);
			}
			board[getX()][getY()] = check(board[getX()][getY()]);
			break;
		case "ass":
			System.out.println("RUKOJOP");
			board[getX()][getY()] = check(board[getX()][getY()]);
			break;
		case "save":
			board[getX()][getY()] = check(board[getX()][getY()]);
			Board.save(board);
			Board.isGameProceed = false;
			break;
		default:
			board[getX()][getY()] = check(board[getX()][getY()]);
			break;
		}
	}

	public static char check(char a) {
		switch (a) {
		case '.':
			return '&';
		case '#':
			Player.savedTreasures++;
			return '&';
		case '>':
			return '>';
		case '|':
			return '|';
		case '-':
			return '-';
		default:
			return '&';
		}
	}

	public static void isGamefinished(char[][] board) {
		if ((check(board[getX()][getY()]) == '>') & Board.treasures == Player.savedTreasures) {
			System.out.println("VICTORY");
			Board.isGameProceed = false;
		} else if ((check(board[getX()][getY()]) == '>') & Board.treasures != Player.savedTreasures) {
			System.out.println("NOT ENOUGH TREASURES. GAME OVER");
			Board.isGameProceed = false;
		}
	}

}
