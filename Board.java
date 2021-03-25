package Game;
import java.io.*;
import java.util.Scanner;

public class Board extends Game  {
	public static char [] [] board = new char[3][6];
	public static int treasures;
	public static boolean proceed = true;
	
	
	public static void load(char[][] board) {
		System.out.println("choose level 1, 2, 3 or 'load' previous game");
		Scanner scn = new Scanner(System.in); 
		String path = " ";
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
			load(board);
			break;
		}
		
		try (FileInputStream brd = new FileInputStream (path)) {
				int d = -1;
				Player.Place[0] = Character.getNumericValue(brd.read());  // считываем координаты
				Player.Place[1] = Character.getNumericValue(brd.read());
				treasures = Character.getNumericValue(brd.read()); // считываем количество сокровищ 
					while ((d = brd.read()) != -1) {
						for(int i = 0; i <3; i++) {
							for (int j = 0; j <6; j++) {
								board[i][j] = (char)d;
								d = brd.read(); 
							} 
					}
				}
		}
			catch(IOException ex){
		        System.out.println(ex.getMessage());
		    } 
	}
	
	public static void save (char [][] board) {
		try (FileOutputStream fos = new FileOutputStream("D://JavaFiles//Save.txt", false)) { // никак не выходит записать число в файл
			char c;
			int d = Player.Place[0] + 48; // American Standard Code, т.к. FileOutputStream записывает char
			fos.write(d);
			d = Player.Place[1] + 48;
			fos.write(d);
			d = (treasures-Player.savedTreasures) + 48;
			fos.write(d);
			for(int i = 0; i <3; i++) {
				for (int j = 0; j <6; j++) {
					c = board[i][j];
					d = (byte)c;
					fos.write(d); 
				} 
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
