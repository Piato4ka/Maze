package Game; 

public class Main extends Board {
	
public static void main (String [] arg) {
	load(board);
	System.out.printf("%nCoolect all treasures # %nDirection: press w,s,a,d %nInput 'save' for saving your result %n");
	display(board);
	while (proceed) {
		move(board);
		finish(board);
		display(board);
		}
}
}
