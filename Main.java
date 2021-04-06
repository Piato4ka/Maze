package Game;

public class Main extends Board {

	public static void main(String[] arg) {
		Loader.chooseLVL();
		Loader.load(board);
		System.out.printf("%nCoolect all treasures # %nDirection: press w,s,a,d %nInput 'save' for saving your result %n");
		display(board);
		while (isGameProceed) {
			move(board);
			isGamefinished(board);
			display(board);
		}
	}
}
