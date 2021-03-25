package Game;

import java.util.Scanner;

public class Game {
	
	
	public static void display (char[][] board){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void move (char[][] board) {
		board[Player.Place[0]][Player.Place[1]] = '.';
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		switch (input) {
		case "w":
			if (Player.Place[0] != 0) {
				Player.Place[0] -= 1;
				board[Player.Place[0]][Player.Place[1]] = check(board[Player.Place[0]][Player.Place[1]]);
			}
			board[Player.Place[0]][Player.Place[1]] = check(board[Player.Place[0]][Player.Place[1]]);
			break;
		case "s":
			if (Player.Place[0] != board.length-1) {
				Player.Place[0] += 1;
				board[Player.Place[0]][Player.Place[1]] = check(board[Player.Place[0]][Player.Place[1]]);
			}
			board[Player.Place[0]][Player.Place[1]] = check(board[Player.Place[0]][Player.Place[1]]);
			break;
		case "a":
			if (Player.Place[1] != 0) {
				Player.Place[1] -= 1;
				board[Player.Place[0]][Player.Place[1]] = check(board[Player.Place[0]][Player.Place[1]]);
			}
			board[Player.Place[0]][Player.Place[1]] = check(board[Player.Place[0]][Player.Place[1]]);
			break;
		case "d":
			if (Player.Place[1] != board[1].length-1) {
				Player.Place[1] += 1;
				board[Player.Place[0]][Player.Place[1]] = check(board[Player.Place[0]][Player.Place[1]]);
			}
			board[Player.Place[0]][Player.Place[1]] = check(board[Player.Place[0]][Player.Place[1]]);
			break;
		case "ass":
			System.out.println("RUKOJOP");
			board[Player.Place[0]][Player.Place[1]] = check(board[Player.Place[0]][Player.Place[1]]);
			break;
		case "save":
			board[Player.Place[0]][Player.Place[1]] = check(board[Player.Place[0]][Player.Place[1]]);
			Board.save(board);
			Board.proceed = false;
			break;
		default:
			board[Player.Place[0]][Player.Place[1]] = check(board[Player.Place[0]][Player.Place[1]]);
			break;
		}
	}
	
	
	public static char check (char a) {
		switch (a) {
		case '.':
			return '&';
		case '#':
			Player.savedTreasures++;
			return '&';
		case '>':
			return '>';
		default:
			return '&';
		}
	}
	
	public static void finish (char[][] board) {
		if ((check(board[Player.Place[0]][Player.Place[1]]) == '>') 
		    & Board.treasures == Player.savedTreasures)
		{
			System.out.println("VICTORY");
			Board.proceed = false;
		}
		else if ((check(board[Player.Place[0]][Player.Place[1]]) == '>')
				& Board.treasures != Player.savedTreasures)
		{
			System.out.println("NOT ENOUGH TREASURES. GAME OVER");
			Board.proceed = false;
		}
	}

}
