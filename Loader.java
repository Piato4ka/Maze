package Game;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Loader {
static String path;
	
	public static void chooseLVL () {
		System.out.println("choose level 1, 2, 3 or 'load' previous game");
		Scanner scn = new Scanner(System.in);
		String lvl = scn.next();
		switch (lvl) {
		case "1":
			path = "D://JavaFiles//Board1.txt";
			break;
		case "2":
			path = "D://JavaFiles//Board2.txt";
			break;
		case "3":
			path = "D://JavaFiles//Board3.txt";
			break;
		case "load":
			path = "D://JavaFiles//Save.txt";
			break;
		default:
			System.out.println("Choose one of this levels:");
			chooseLVL();
			break;
		}
	}
	
		public static void load(char[][] board) {
			try (FileInputStream brd = new FileInputStream(path)) {
				int d = -1;
				Game.PlayerPlace[0] = Character.getNumericValue(brd.read()); // считываем координаты
				Game.PlayerPlace[1] = Character.getNumericValue(brd.read());
				Board.treasures = Character.getNumericValue(brd.read()); // считываем количество сокровищ
				while ((d = brd.read()) != -1) {
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 9; j++) {
							board[i][j] = (char) d;
							d = brd.read();
						}
					}
				}
			} 
			
			catch (IOException ex) {
				System.out.println("There is no file with board");
				Board.isGameProceed = false;
			}
		}
}


