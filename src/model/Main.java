package model;

public class Main {

	public static boolean mutex = false;
	public static Frame f;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		f = new Frame();
		Frame.TempoPens.setText("4000");
		Frame.TempoComen.setText("3000");
		
		
		f.setSize(700,600);
		f.setVisible(true);
		
	}
	
}
