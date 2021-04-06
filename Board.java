package Game;

import java.io.*;

public class Board extends Game {
	public static char[][] board = new char[9][9];
	public static int treasures;
	public static boolean isGameProceed = true;

	public static void save(char[][] board) {
		try (FileOutputStream fos = new FileOutputStream("D://JavaFiles//Save.txt", false)) { // никак не выходит
																								// записать число в файл
			char c;
			int d = Game.getX() + 48; // American Standard Code, т.к. FileOutputStream записывает char
			fos.write(d);
			d = Game.getY() + 48;
			fos.write(d);
			d = (treasures - Player.savedTreasures) + 48;
			fos.write(d);
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 9; j++) {
					c = board[i][j];
					d = (byte) c;
					fos.write(d);
				}
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
