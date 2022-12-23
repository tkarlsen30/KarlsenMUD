import java.awt.Dimension;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;

public class Game extends GLJPanel implements GLEventListener {

	private World world;
	
	public Game () {
		
		super ( new GLCapabilities ( null ) );
		
		setPreferredSize ( new Dimension ( 1280, 720 ) );
		
		addGLEventListener ( this );
		
		world = new World ();
		
	}
	
	public void display ( GLAutoDrawable drawable ) {
		
		GL2 gl2 = drawable.getGL ().getGL2 ();
		
		gl2.glClear ( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
		gl2.glLoadIdentity ();

		GLU glu = new GLU ();
		
		glu.gluLookAt ( 0.0f, 5.0f, 0.0f, 3.0f, 5.0f, 0.0f, 0.0f, 1.0f, 0.0f );
		
		gl2.glVertexPointer ( 3, GL2.GL_FLOAT, 0, world.getWorldVertices () );
		gl2.glNormalPointer ( GL2.GL_FLOAT, 0, world.getWorldNormals () );
		
		gl2.glEnableClientState ( GL2.GL_VERTEX_ARRAY );
		gl2.glEnableClientState ( GL2.GL_NORMAL_ARRAY );
		
		gl2.glDrawElements ( GL2.GL_TRIANGLES, world.getNumWorldElements (), GL2.GL_UNSIGNED_INT, world.getworldElements () );
		
		gl2.glDisableClientState ( GL2.GL_VERTEX_ARRAY );
		gl2.glDisableClientState ( GL2.GL_NORMAL_ARRAY );
		
	}
	
	public void init ( GLAutoDrawable drawable ) {
		
		GL2 gl2 = drawable.getGL ().getGL2 ();
		
		gl2.glMatrixMode ( GL2.GL_PROJECTION );
		
		GLU glu = new GLU ();
		
		glu.gluPerspective ( 60.0f, 16.0f/9.0f, 1.0f, 50.0f );
		
		gl2.glMatrixMode ( GL2.GL_MODELVIEW );
		
		gl2.glEnable ( GL2.GL_DEPTH_TEST );
		
	}
	
	public void dispose ( GLAutoDrawable drawable ) {
		
		
		
	}
	
	public void reshape ( GLAutoDrawable drawable, int x, int y, int width, int height ) {
		
		
		
	}
	
}