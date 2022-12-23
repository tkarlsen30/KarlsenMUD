import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	private static void startup () {
		
		Thread gameThread = new Thread () {
			
			public void run () {
				
				GameFrame gameFrame = new GameFrame ( "KarlsenMUD" );
				
				Game game = new Game ();
				
				gameFrame.setContentPane ( game );
				gameFrame.pack ();
				gameFrame.setLocation ( 100, 100 );
				gameFrame.setResizable ( false );
				gameFrame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
				gameFrame.setVisible ( true );
				
				game.requestFocusInWindow ();
				
			}
			
		};
		
		gameThread.start ();
		
	}
	
	private GameFrame ( String gameFrameTitle ) {
		
		super ( gameFrameTitle );
		
	}
	
	public static void main ( String[] args ) {
		
		startup ();
		
	}
	
}